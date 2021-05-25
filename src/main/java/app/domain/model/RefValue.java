package app.domain.model;

import java.util.Date;
import java.util.Objects;

public class RefValue {

    /**
     *
     */
    private String metric;
    /**
     *
     */
    private double minValue;

    /**
     *
     */
    private double maxValue;



    /**
     *
     * @param obj
     */
    public RefValue (RefValue obj){
        this.metric = obj.metric;
        this.minValue = obj.minValue;
        this.maxValue = obj.maxValue;

    }

    /**
     *
     * @param metric
     * @param minValue
     * @param maxValue
     */
    public RefValue(String metric, double minValue, double maxValue){
        this.metric=metric;
        this.minValue=minValue;
        this.maxValue = maxValue;
    }

    /**
     *
     * @return
     */
    public String getMetric() {
        return metric;
    }
    /**
     *
     * @return
     */
    public double getMinValue() {
        return minValue;
    }
    /**
     *
     * @return
     */
    public double getMaxValue() {
        return maxValue;
    }

}
