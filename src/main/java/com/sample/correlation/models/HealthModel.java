package com.sample.correlation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by lschidu on 3/4/17.
 *
 *
 * This is the model that will be fetched from the api
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthModel {

    private int est_pop_ct_w_characteristic;
    private int overall_sample_size;
    private int overall_population_size;
    private double percentage_w_characteristic;
    private int sample_cases_w_characteristic;
    private double lowercl;
    private double uppercl;
    private int year;


    public int getEst_pop_ct_w_characteristic() {
        return est_pop_ct_w_characteristic;
    }

    public void setEst_pop_ct_w_characteristic(int est_pop_ct_w_characteristic) {
        this.est_pop_ct_w_characteristic = est_pop_ct_w_characteristic;
    }

    public int getOverall_sample_size() {
        return overall_sample_size;
    }

    public void setOverall_sample_size(int overall_sample_size) {
        this.overall_sample_size = overall_sample_size;
    }

    public int getOverall_population_size() {
        return overall_population_size;
    }

    public void setOverall_population_size(int overall_population_size) {
        this.overall_population_size = overall_population_size;
    }

    public double getPercentage_w_characteristic() {
        return percentage_w_characteristic;
    }

    public void setPercentage_w_characteristic(double percentage_w_characteristic) {
        this.percentage_w_characteristic = percentage_w_characteristic;
    }

    public int getSample_cases_w_characteristic() {
        return sample_cases_w_characteristic;
    }

    public void setSample_cases_w_characteristic(int sample_cases_w_characteristic) {
        this.sample_cases_w_characteristic = sample_cases_w_characteristic;
    }

    public double getLowercl() {
        return lowercl;
    }

    public void setLowercl(double lowercl) {
        this.lowercl = lowercl;
    }

    public double getUppercl() {
        return uppercl;
    }

    public void setUppercl(double uppercl) {
        this.uppercl = uppercl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
