package app.domain.model;

import java.util.Date;
import java.util.Objects;

public class RefValue {

    /**
     *
     */
    private String code;
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
     */
    private Date referenceDate;

    /**
     *
     * @param parameterid
     * @param metric
     * @param minValue
     * @param maxValue
     * @param referenceDate
     */
    public RefValue(String parameterid,String metric, double minValue, double maxValue, Date referenceDate){
        this.code=parameterid;
        this.metric=metric;
        this.minValue=minValue;
        this.maxValue = maxValue;
        this.referenceDate=referenceDate;
    }
    /**
     *
     * @param obj
     */
    public RefValue (RefValue obj){
        this.code= obj.code;
        this.metric = obj.metric;
        this.minValue = obj.minValue;
        this.maxValue = obj.maxValue;
        this.referenceDate =obj.referenceDate;
    }
    /**
     *
     * @param parameterid
     * @param metric
     * @param minValue
     * @param maxValue
     */
    public RefValue(String parameterid,String metric, double minValue, double maxValue){
        this.code=parameterid;
        this.metric=metric;
        this.minValue=minValue;
        this.maxValue = maxValue;
        this.referenceDate=null;
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
    public String getCode() {
        return code;
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
    /**
     *
     * @return
     */
    public Date getReferenceDate() {
        return referenceDate;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        } else {
            RefValue other = (RefValue)obj;
            if (!Objects.equals(this.code, other.code)) {
                return false;
            } else if (this.metric != other.metric) {
                return false;
            } else if (!Objects.equals(this.minValue, other.minValue)) {
                return false;
            } else if (!Objects.equals(this.maxValue, other.maxValue)) {
                return false;
            } else {
                return Objects.equals(this.referenceDate, other.referenceDate);
            }
        }
    }
}
