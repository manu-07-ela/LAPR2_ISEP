package app.domain.model.testrelated;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class TestParameterResult implements Serializable {
    /**
     * The metric of the result
     */
    private String metric;
    /**
     * The result of the TestParameter
     */
    private String result;
    /**
     * An object of RefValue with the reference values
     */
    private RefValue refValue;
    /**
     * Date and Time of the Chemical Analysis
     */
    private Date chemicalAnalysisDate;

    /**
     * Constructs an instance of the TestParameterResult
     */
    public TestParameterResult(){
        this.refValue=null;
        this.result = null;
        this.metric = null;
        this.chemicalAnalysisDate = null;
    }

    /**
     * Constructs an instance of the TestParameterResult
     * @param refValue An object of RefValue with the reference values
     * @param result The result of the testParameter
     * @param metric The metric of the result
     */
    public TestParameterResult(RefValue refValue , String result , String metric){
        resultValidation(result);
        metricValidation(metric);
        this.refValue=refValue;
        this.result = result;
        this.metric = metric;
        this.chemicalAnalysisDate = Calendar.getInstance().getTime();
    }

    /**
     * Constructs an instance of the TestParameterResult
     * @param refValue An object of RefValue with the reference values
     * @param result The result of the testParameter
     * @param metric The metric of the result
     * @param chemicalAnalysisDate the date of chemical analysis
     */
    public TestParameterResult(RefValue refValue , String result , String metric,Date chemicalAnalysisDate){
        resultValidation(result);
        metricValidation(metric);
        this.refValue=refValue;
        this.result = result;
        this.metric = metric;
        this.chemicalAnalysisDate = chemicalAnalysisDate;
    }

    /**
     * Get the metric of the result
     * @return the metric of the result
     */
    public String getMetric() {
        return metric;
    }
    /**
     * Get the result of the TestParameter
     * @return the result of the TestParameter
     */
    public String getResult() {
        return result;
    }
    /**
     * Get the object of the reference values
     * @return an object of the reference values
     */
    public RefValue getRefValue() {
        return refValue;
    }

    /**
     * Get the Date of the Chemical Analysis
     * @return the Date of the Chemical Analysis
     */
    public Date getChemicalAnalysisDate() { return this.chemicalAnalysisDate;}

    /**
     * Sets the Date of the Chemical Analysis
     */
    public void setChemicalAnalysisDate(Date chemicalAnalysisDate) {
        this.chemicalAnalysisDate = chemicalAnalysisDate;
    }

    @Override
    public String toString() {
        return "TestParameterResult{" +
                "metric='" + metric + '\'' +
                ", result='" + result + '\'' +
                ", refValue=" + refValue +
                '}';
    }

    /**
     *  Validation of the result
     * @param result The result
     */
    private void resultValidation(String result){
        if (StringUtils.isBlank(result)){
            throw  new IllegalArgumentException("Result must be a number and cannot be blank");
        }
    }

    /**
     * Validation of the metric
     * @param metric the metric
     */
    private void metricValidation(String metric){
        if (StringUtils.isBlank(metric) ){
            throw  new IllegalArgumentException("Metric cannot be blank");
        }
    }

}
