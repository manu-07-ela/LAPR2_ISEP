package app.domain.model.testrelated;

import java.io.Serializable;
import java.util.Objects;

public class RefValue implements Serializable {

    /**
     * Get the metric of the reference values
     * @return the metric of the reference values
     */
    private String metric;
    /**
     * The minimum value
     */
    private double minValue;

    /**
     * The maximum value
     */
    private double maxValue;



    /**
     * Constructs an instance of RefValue
     * @param obj an intance of RefValue
     */
    public RefValue (RefValue obj){
        this.metric = obj.metric;
        this.minValue = obj.minValue;
        this.maxValue = obj.maxValue;

    }

    /**
     * Constructs an instance of RefValue
     * @param metric the metric of the reference values
     * @param minValue The minimum value
     * @param maxValue The maximum value
     */
    public RefValue(String metric, double minValue, double maxValue){
        this.metric=metric;
        this.minValue=minValue;
        this.maxValue = maxValue;
    }

    /**
     * Get the metric of the result
     * @return the metric of the result
     */
    public String getMetric() {
        return metric;
    }
    /**
     * Gets the minimum value
     * @return minimum value
     */
    public double getMinValue() {
        return minValue;
    }
    /**
     * Gets the maximum value
     * @return maximum value
     */
    public double getMaxValue() {
        return maxValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefValue refValue = (RefValue) o;
        return Double.compare(refValue.minValue, minValue) == 0 && Double.compare(refValue.maxValue, maxValue) == 0 && Objects.equals(metric, refValue.metric);
    }
}
