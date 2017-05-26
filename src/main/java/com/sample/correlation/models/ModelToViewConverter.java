package com.sample.correlation.models;

import com.google.common.base.Converter;


/**
 * Created by lschidu on 3/4/17.
 *
 *
 */
public class ModelToViewConverter extends Converter<double[], HealthView> {
    @Override
    protected HealthView doForward(double[]array) {
        HealthView healthView = new HealthView();
        healthView.setEstPopulation(array[4]);
        healthView.setLower(array[6]);
        healthView.setPercentange(array[5]);
        healthView.setSampleCases(array[3]);
        healthView.setSampleSize(array[1]);
        healthView.setUpper(array[7]);
        healthView.setYear(array[0]);
        healthView.setPopulationSize(array[2]);

        return healthView;
    }

    @Override
    protected double[] doBackward(HealthView healthView) {
        return null;
    }


}
