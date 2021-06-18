package app;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

/**
 *  The code SimpleLinearRegression class performs a simple linear regression
 *  on an set of n data points (y_i, x_i).
 *  That is, it fits a straight line y = alpha + beta * x,
 *  (where y is the response variable, x is the predictor variable,
 *  alpha is the y-intercept, and beta is the slope)
 *  that minimizes the sum of squared residuals of the linear regression model.
 *  It also computes associated statistics, including the coefficient of
 *  determination R^2 and the standard deviation of the
 *  estimates for the slope and y-intercept.
 *
 */

public class SimpleLinearRegression {

    private final double intercept, slope;
    private final double r2;
    private final double svar0, svar1;
    private final double r2Adjusted;
    private final int confidenceLevel;
    private final int significanceLevel;
    private final int n;
    private final int degreesOfFreedom;
    private final double variance;
    private double xbar;
    private double xxbar;
    private double auxYMenosYChapeuQuadrado;
    private double rss;
    private double ssr;
    private double st;
    private double msr;
    private double mse;
    private double fObs;
    private final double fSnedecor;

    /**
     * Performs a linear regression on the data points (y[i], x[i]).
     *
     * @param  x the values of the predictor variable
     * @param  y the corresponding values of the response variable
     * @throws IllegalArgumentException if the lengths of the two arrays are not equal
     */
    public SimpleLinearRegression(double[] x, double[] y, int confidenceLevel, int significanceLevel) {
        this.confidenceLevel=confidenceLevel;
        this.significanceLevel=significanceLevel;
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        this.n = x.length;

        // first pass
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int i = 0; i < n; i++) {
            sumx  += x[i];
            sumx2 += x[i]*x[i];
            sumy  += y[i];
        }
        xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        xxbar = 0.0;
        double yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        slope  = xybar / xxbar;
        intercept = ybar - slope * xbar;

        // more statistical analysis
        rss = 0.0;      // residual sum of squares
        ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = slope*x[i] + intercept;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }
        this.degreesOfFreedom = n-2;
        this.st=ssr+rss;
        this.msr=ssr/1;
        this.mse=rss/degreesOfFreedom;
        this.fObs=msr/mse;
        this.fSnedecor=fSnedecor((double) significanceLevel/100);
        r2    = ssr / yybar;
        double svar  = rss / degreesOfFreedom;
        svar1 = svar / xxbar;
        svar0 = svar/n + xbar*xbar*svar1;
        r2Adjusted = 1-(1-r2)*(n-1)/(n-2);
        this.auxYMenosYChapeuQuadrado = 0;
        for (int i = 0; i < n; i++) {
            auxYMenosYChapeuQuadrado += (y[i]-predict(x[i]))*(y[i]-predict(x[i]));
        }
        this.variance = Math.sqrt(auxYMenosYChapeuQuadrado/(degreesOfFreedom));
    }

    public double getfObs() {
        return fObs;
    }

    public double getfSnedecor() {
        return fSnedecor;
    }

    public double getMse() {
        return mse;
    }

    public double getMsr() {
        return msr;
    }

    public double getRss() {
        return rss;
    }

    public double getSsr() {
        return ssr;
    }

    public double getSt() {
        return st;
    }

    /**
     * Returns the y-intercept alpha of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the y-intercept alpha of the best-fit line y = alpha + beta * x
     */
    public double intercept() {
        return intercept;
    }

    /**
     * Returns the slope beta of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the slope beta of the best-fit line y = alpha + beta * x
     */
    public double slope() {
        return slope;
    }

    /**
     * Returns the coefficient of determination R^2.
     *
     * @return the coefficient of determination R^2,
     *         which is a real number between 0 and 1
     */
    public double R2() {
        return r2;
    }

    /**
     * Returns the standard error of the estimate for the intercept.
     *
     * @return the standard error of the estimate for the intercept
     */
    public double interceptStdErr() {
        return Math.sqrt(svar0);
    }

    /**
     * Returns the standard error of the estimate for the slope.
     *
     * @return the standard error of the estimate for the slope
     */
    public double slopeStdErr() {
        return Math.sqrt(svar1);
    }

    /**
     * Returns the expected response y given the value of the predictor
     * variable x.
     *
     * @param  x the value of the predictor variable
     * @return the expected response y given the value of the predictor
     *         variable x
     */
    public double predict(double x) {
        return slope*x + intercept;
    }

    public double r2Adjusted (){
        return r2Adjusted;
    }

    public double[] trustInterval(double x0, double yEstimated){
        double[] limits = new double[2];
        double confidenceLevelAux = (double) confidenceLevel/100;
        double alpha = 1.0 - confidenceLevelAux;
        double tc = tStudent(alpha/2,degreesOfFreedom);
        double aux = Math.sqrt(1.0+(1/n)+(((x0-xbar)*(x0-xbar))/xxbar));
        double delta = variance*aux*tc;
        double linf = yEstimated-delta;
        double lsup = yEstimated + delta;
        limits[0] = linf;
        limits[1] = lsup;
        return limits;
    }

    public void straightSlopeHypothesisTest(){
        double alpha = (double) significanceLevel/100;
        double tc = tStudent(alpha/2,degreesOfFreedom);
        int b0 = 0;
        double S = Math.sqrt(auxYMenosYChapeuQuadrado/degreesOfFreedom);
        double aux=Math.sqrt(1/xxbar);
        double tb = (slope-b0)/(S*aux);
    }

    public void ordinateOriginHypothesisTest(){
        double alpha = (double) significanceLevel/100;
        double tc = tStudent(alpha/2,degreesOfFreedom);
        int a0 = 0;
        double S = Math.sqrt(((1.0/degreesOfFreedom))*(auxYMenosYChapeuQuadrado));
        double aux=Math.sqrt((1.0/n)+((xbar*xbar)/xxbar));
        double tb = (intercept-a0)/(S*aux);
    }

    private double fSnedecor(double alpha){
        FDistribution fd= new FDistribution(1,degreesOfFreedom);
        double alphaFD= alpha;
        return fd.inverseCumulativeProbability(1- alphaFD);
    }

    private double tStudent(double alpha,int degreesOfFreedom){
        TDistribution td= new TDistribution(degreesOfFreedom);
        double critTD;
        if(alpha> 0.5) {
            critTD = td.inverseCumulativeProbability(alpha);
        }
        else {
            critTD = td.inverseCumulativeProbability(1 - alpha);
        }
        return critTD;
    }

    /**
     * Returns a string representation of the simple linear regression model.
     *
     * @return a string representation of the simple linear regression model,
     *         including the best-fit line and the coefficient of determination
     *         R^2
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%.2f n + %.2f", slope(), intercept()));
        s.append("  (R^2 = " + String.format("%.3f", R2()) + ")");
        return s.toString();
    }

}