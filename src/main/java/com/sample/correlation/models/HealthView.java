package com.sample.correlation.models;

import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by lschidu on 3/4/17.
 *
 * This is the model that will be shown in the TableView
 */
public class HealthView {
    private SimpleDoubleProperty estPopulation = new SimpleDoubleProperty();
    private SimpleDoubleProperty sampleSize = new SimpleDoubleProperty();
    private SimpleDoubleProperty year = new SimpleDoubleProperty();
    private SimpleDoubleProperty populationSize = new SimpleDoubleProperty();
    private SimpleDoubleProperty percentange = new SimpleDoubleProperty();
    private SimpleDoubleProperty sampleCases = new SimpleDoubleProperty();
    private SimpleDoubleProperty lower = new SimpleDoubleProperty();
    private SimpleDoubleProperty upper = new SimpleDoubleProperty();

    public double getEstPopulation() {
        return estPopulation.get();
    }

    public SimpleDoubleProperty estPopulationProperty() {
        return estPopulation;
    }

    public void setEstPopulation(double estPopulation) {
        this.estPopulation.set(estPopulation);
    }

    public double getSampleSize() {
        return sampleSize.get();
    }

    public SimpleDoubleProperty sampleSizeProperty() {
        return sampleSize;
    }

    public void setSampleSize(double sampleSize) {
        this.sampleSize.set(sampleSize);
    }

    public double getYear() {
        return year.get();
    }

    public SimpleDoubleProperty yearProperty() {
        return year;
    }

    public void setYear(double year) {
        this.year.set(year);
    }

    public double getPopulationSize() {
        return populationSize.get();
    }

    public SimpleDoubleProperty populationSizeProperty() {
        return populationSize;
    }

    public void setPopulationSize(double populationSize) {
        this.populationSize.set(populationSize);
    }

    public double getPercentange() {
        return percentange.get();
    }

    public SimpleDoubleProperty percentangeProperty() {
        return percentange;
    }

    public void setPercentange(double percentange) {
        this.percentange.set(percentange);
    }

    public double getSampleCases() {
        return sampleCases.get();
    }

    public SimpleDoubleProperty sampleCasesProperty() {
        return sampleCases;
    }

    public void setSampleCases(double sampleCases) {
        this.sampleCases.set(sampleCases);
    }

    public double getLower() {
        return lower.get();
    }

    public SimpleDoubleProperty lowerProperty() {
        return lower;
    }

    public void setLower(double lower) {
        this.lower.set(lower);
    }

    public double getUpper() {
        return upper.get();
    }

    public SimpleDoubleProperty upperProperty() {
        return upper;
    }

    public void setUpper(double upper) {
        this.upper.set(upper);
    }
}
