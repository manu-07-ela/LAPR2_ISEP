package app;

import app.interfaces.RegressionModel;
import app.ui.gui.LabCoordinatorUi;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.util.Date;
import java.util.List;

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

public class SimpleLinearRegression implements RegressionModel {
    private final double intercept, slope;
    private final double r2;
    private final double svar0, svar1;
    private final double r2Adjusted;
    private final double confidenceLevel;
    private final double significanceLevel;
    private final int n;
    private final int degreesOfFreedom;
    private final double variance;
    private final double xbar;
    private double xxbar;
    private double auxYMenosYChapeuQuadrado;
    private double rss;
    private double ssr;
    private final double st;
    private final double msr;
    private final double mse;
    private final double fObs;
    private final double fSnedecor;
    private final double[] xHistorical;
    private final double[] yHistorical;
    private final List<String> dateHistorical;

    public SimpleLinearRegression(double[] x, double[] y, double[] xHistoricalPoints, double[] yHistoricalPoints, double confidenceLevel, double significanceLevel, List<String> datesHistoricalPoints) {
        this.confidenceLevel = confidenceLevel;
        this.significanceLevel = significanceLevel;
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        this.n = x.length;

        // first pass
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int i = 0; i < n; i++) {
            sumx += x[i];
            sumx2 += x[i] * x[i];
            sumy += y[i];
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
        slope = xybar / xxbar;
        intercept = ybar - slope * xbar;

        // more statistical analysis
        rss = 0.0;      // residual sum of squares
        ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = slope * x[i] + intercept;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }
        this.degreesOfFreedom = n - 2;
        this.st = ssr + rss;
        this.msr = ssr / 1;
        this.mse = rss / degreesOfFreedom;
        this.fObs = msr / mse;
        this.fSnedecor = fSnedecor(significanceLevel / 100);
        r2 = ssr / yybar;
        double svar = rss / degreesOfFreedom;
        svar1 = svar / xxbar;
        svar0 = svar / n + xbar * xbar * svar1;
        r2Adjusted = 1 - (1 - r2) * (n - 1) / (n - 2);
        this.auxYMenosYChapeuQuadrado = 0;
        for (int i = 0; i < n; i++) {
            auxYMenosYChapeuQuadrado += (y[i] - predict(x[i])) * (y[i] - predict(x[i]));
        }
        this.variance = Math.sqrt(auxYMenosYChapeuQuadrado / (degreesOfFreedom));
        this.xHistorical = xHistoricalPoints;
        this.yHistorical = yHistoricalPoints;
        this.dateHistorical = datesHistoricalPoints;
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
     * which is a real number between 0 and 1
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
     * @param x the value of the predictor variable
     * @return the expected response y given the value of the predictor
     * variable x
     */
    public double predict(double x) {
        return slope * x + intercept;
    }

    public double r2Adjusted() {
        return r2Adjusted;
    }

    private double[] trustInterval(double x0, double yEstimated) {
        double[] limits = new double[2];
        double confidenceLevelAux = confidenceLevel / 100;
        double alpha = 1.0 - confidenceLevelAux;
        double tc = tStudent(alpha / 2, degreesOfFreedom);
        double aux = Math.sqrt(1.0 + (1.0 / n) + (((x0 - xbar) * (x0 - xbar)) / xxbar));
        double delta = variance * aux * tc;
        double linf = yEstimated - delta;
        double lsup = yEstimated + delta;
        limits[0] = linf;
        limits[1] = lsup;
        return limits;
    }

    private String straightSlopeHypothesisTest() {
        StringBuilder stringBuilder = new StringBuilder();
        double alpha = significanceLevel / 100;
        double tc = tStudent(alpha / 2, degreesOfFreedom);
        int b0 = 0;
        double S = Math.sqrt(auxYMenosYChapeuQuadrado / degreesOfFreedom);
        double aux = Math.sqrt(1 / xxbar);
        double tObs = (slope - b0) / (S * aux);
        stringBuilder.append(String.format("H0: b = 0\n"));
        stringBuilder.append(String.format("H1: b != 0 \n"));
        stringBuilder.append(String.format("t observed = %.2f \n", tObs));
        if (Math.abs(tObs) > tc) {
            stringBuilder.append(String.format("Rejects H0\n"));
        } else {
            stringBuilder.append(String.format("Don't reject H0\n"));
        }
        return stringBuilder.toString();
    }

    private String ordinateOriginHypothesisTest() {
        StringBuilder stringBuilder = new StringBuilder();
        double alpha = significanceLevel / 100;
        double tc = tStudent(alpha / 2, degreesOfFreedom);
        int a0 = 0;
        double S = Math.sqrt(((1.0 / degreesOfFreedom)) * (auxYMenosYChapeuQuadrado));
        double aux = Math.sqrt((1.0 / n) + ((xbar * xbar) / xxbar));
        double tObs = (intercept - a0) / (S * aux);
        stringBuilder.append(String.format("H0: a = 0\n"));
        stringBuilder.append(String.format("H1: a != 0 \n"));
        stringBuilder.append(String.format("t observed = %.2f \n", tObs));
        if (Math.abs(tObs) > tc) {
            stringBuilder.append(String.format("Rejects H0\n"));
        } else {
            stringBuilder.append(String.format("Don't reject H0\n"));
        }
        return stringBuilder.toString();
    }

    private double fSnedecor(double alpha) {
        FDistribution fd = new FDistribution(1, degreesOfFreedom);
        return fd.inverseCumulativeProbability(1 - alpha);
    }

    private double tStudent(double alpha, int degreesOfFreedom) {
        TDistribution td = new TDistribution(degreesOfFreedom);
        double critTD;
        if (alpha > 0.5) {
            critTD = td.inverseCumulativeProbability(alpha);
        } else {
            critTD = td.inverseCumulativeProbability(1 - alpha);
        }
        return critTD;
    }

    private String compare() {
        StringBuilder stringBuilder = new StringBuilder();
        if (fObs > fSnedecor) {
            stringBuilder.append(String.format("Decision: (f0 = %.2f) > (f%.2f(%d, %d) = %.2f)\n", fObs, significanceLevel/100, 1, degreesOfFreedom, fSnedecor));
            stringBuilder.append(String.format("Reject H0, the model is significant\n"));
        } else {
            stringBuilder.append(String.format("Decision: (f0 = %.2f) <= (f%.2f(%d, %d) = %.2f)\n", fObs, significanceLevel/100, 1, degreesOfFreedom, fSnedecor));
            stringBuilder.append(String.format("Don't reject H0, the model is not significant\n"));
        }
        return stringBuilder.toString();
    }

    /**
     * Returns a string representation of the simple linear regression model.
     *
     * @return a string representation of the simple linear regression model,
     * including the best-fit line and the coefficient of determination
     * R^2
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------* The regression model fitted using data from the interval *----------\n");
        s.append(String.format("y = %.2fx + %.2f\n", slope(), intercept()));
        s.append(String.format("\n"));
        s.append("----------* Other statistics *----------\n");
        s.append(String.format("R^2 = %.3f\n", R2()));
        s.append(String.format("R^2 adjusted = %.3f\n", r2Adjusted()));
        s.append(String.format("R = %.3f\n", Math.sqrt(R2())));
        s.append("\n");
        s.append("----------* Significance model with Anova *----------\n");
        s.append("                     Sum of squares          Degrees of freedom          Root mean          Test statistic f \n");
        s.append(String.format(" Regression        |     %.2f           |             %d            |      %.2f        |          %.2f        \n", ssr, 1, msr, fObs));
        s.append(String.format(" Error             |     %.2f           |             %d            |      %.2f        |                       \n", rss, degreesOfFreedom, mse));
        s.append(String.format(" Total             |     %.2f           |             %d            |                  |                       \n", st, degreesOfFreedom + 1));
        s.append("\n");
        s.append(compare());
        s.append("\n");
        s.append("----------* Hypothesis tests for regression coefficients *----------\n");
        s.append(straightSlopeHypothesisTest());
        s.append("\n");
        s.append(ordinateOriginHypothesisTest());
        s.append("\n");
        s.append("----------* Prediction values *----------\n");
        s.append("\n");
        s.append(String.format("Date                    |          Number of OBSERVED positive cases          |          Number of ESTIMATED positive cases           |          %.1f%% intervals             \n", confidenceLevel));
        for (int i = 0; i < xHistorical.length; i++) {
            double[] intervalOfConfidence = trustInterval(xHistorical[i], predict(xHistorical[i]));
            s.append(String.format("%s              |                       %.2f                          |                       %.2f                           |          ] %.2f; %.2f [             \n", dateHistorical.get(i), yHistorical[i], predict(xHistorical[i]), intervalOfConfidence[0], intervalOfConfidence[1]));
        }

        return s.toString();
    }

    @Override
    public String regressionInformation() {
        return toString();
    }

    @Override
    public double r2() {
        return r2();
    }
}