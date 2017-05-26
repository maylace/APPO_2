package com.sample.correlation.utils;

import com.sample.correlation.models.HealthModel;
import com.sample.correlation.models.HealthView;
import com.sample.correlation.models.ModelToViewConverter;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lschidu on 3/4/17.
 */
public class CorrelationCalculator {

    private static final int DIMENSION = 8;
    private static CorrelationCalculator INSTANCE = null;
    private List<HealthModel> list;
    private List<HealthView> outList = new LinkedList<>();
    private RealMatrix matrix;
    private RealMatrix outMatrix;
    private final ModelToViewConverter modelToViewConverter = new ModelToViewConverter();


    private CorrelationCalculator() {

    }

    public static CorrelationCalculator getINSTANCE() {
        if(INSTANCE == null) {
            INSTANCE = new CorrelationCalculator();
        }
        return INSTANCE;
    }

    /**
     *
     * @param list
     * @return this. That is part of Builder pattern, for more coherent use of this class.
     */
    public CorrelationCalculator with(List<HealthModel> list) {
        this.list = list;
        convertListToRealMatrix();
        return this;
    }


    /**
     *
     * @return this. Again, part of Builder pattern, for chaining methods.
     * Example : CorrelationCalculator.getINSTANCE().with(data).computeCorrelationMatrix().getData();
     *
     */
    public CorrelationCalculator computeCorrelationMatrix() {
        int nVars = matrix.getColumnDimension();
        outMatrix = new BlockRealMatrix(nVars, nVars);
        for (int i = 0; i < nVars; i++) {
            for (int j = 0; j < i; j++) {

                double corr = correlation(matrix.getColumn(i), matrix.getColumn(j));
                outMatrix.setEntry(i, j, corr);
                outMatrix.setEntry(j, i, corr);
            }
            outMatrix.setEntry(i, i, 1d);
        }
        return this;

    }

    /**
     *  This method was taken from the official source code of Apache Commons Math for calculation
     *  of correlation
     * @param xArray
     * @param yArray
     * @return double value that represents the correlation between to columns
     */
    private double correlation(final double[] xArray, final double[] yArray) {
        SimpleRegression regression = new SimpleRegression();
        if (xArray.length != yArray.length) {
            throw new DimensionMismatchException(xArray.length, yArray.length);
        } else if (xArray.length < 2) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION,
                    xArray.length, 2);
        } else {
            for(int i=0; i<xArray.length; i++) {
                regression.addData(xArray[i], yArray[i]);
            }
            return regression.getR();
        }
    }

    private void convertListToRealMatrix() {
        matrix = new BlockRealMatrix(list.size(), DIMENSION);
        int i = 0;

        for(HealthModel element : list) {
            matrix.setEntry(i, 0, element.getYear());
            matrix.setEntry(i, 1, element.getOverall_sample_size());
            matrix.setEntry(i, 2, element.getOverall_population_size());
            matrix.setEntry(i, 3, element.getSample_cases_w_characteristic());
            matrix.setEntry(i, 4, element.getEst_pop_ct_w_characteristic());
            matrix.setEntry(i, 5, element.getPercentage_w_characteristic());
            matrix.setEntry(i, 6, element.getLowercl());
            matrix.setEntry(i, 7, element.getUppercl());
            i++;
        }
    }

    public List<HealthView> getOutList() {
        for(int i = 0; i < 8; i++) {
            outList.add(modelToViewConverter.convert(outMatrix.getColumn(i)));
        }
        return outList;
    }

}
