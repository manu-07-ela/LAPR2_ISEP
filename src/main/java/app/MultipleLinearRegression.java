package app;
import app.interfaces.RegressionModel;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.util.List;

public class MultipleLinearRegression implements RegressionModel {

    private final double[][] matrixX;
    private final double[][] matrixXTXInverse;
    private final double[][] confidenceInterval;
    private final double[] matrixY;
    private final double[] matrixXTY;
    private final double[] matrixB;
    private final double[] cjj;
    private final double[][] matrixHypotheses;
    private  List<String> historicalPoints;
    private  double[] historicalPointsY;
    private  double[] historicalPointsX1;
    private  double[] historicalPointsX2;
    private double  y;
    private final double f0;
    private double trustLevel;
    private double significanceLevel;

    /**
     *
     * @param x1
     * @param x2
     * @param y
     */
    public MultipleLinearRegression(double[] x1, double[] x2, double[] y, double trustLevel, double significanceLevel, List<String> historicalPoints, double[] historicalPointsY, double[] historicalPointsX1, double[] historicalPointsX2) {
        if (x1.length!=y.length){
            throw new IllegalArgumentException();
        }
        this.historicalPointsX1 = historicalPointsX1;
        this.historicalPointsX2 = historicalPointsX2;
        this.historicalPointsY = historicalPointsY;
        matrixY = y;
        for (int i = 0; i < y.length; i++) {
            this.y += y[i];
        }
        this.y = this.y / y.length;
        this.trustLevel = trustLevel/100;
        this.significanceLevel = significanceLevel/100;
        matrixX = matrixX(x1, x2);
        double[][] matrixXTransposed = transpose(matrixX);
        double[][] matrixXTX = matrixXXT(matrixXTransposed, matrixX);
        matrixXTY = matrixXTY(matrixXTransposed, y);
        matrixXTXInverse = invert(matrixXTX);

        matrixB = multiplyBiArrayWithArray(matrixXTXInverse, matrixXTY);
        double[] matrixYHat = multiplyBiArrayWithArray(matrixX, matrixB);
        this.cjj = cjj();
        f0 = testStatistics();
        matrixHypotheses = hypothesisTest(significanceLevel);
        this.historicalPoints = historicalPoints;


        this.confidenceInterval = confidenceInterval();




    }

    private double[][] matrixX(double[] x1, double[] x2) {
        if (x1.length != x2.length) throw new IllegalArgumentException("The arrays sizes should be the same");
        int length = x1.length;

        double[][] matrixAux = new double[length][3];
        // X matrix
        for (int i = 0; i < matrixY.length; i++) {
            matrixAux[i][0] = 1;
            matrixAux[i][1] = x1[i];
            matrixAux[i][2] = x2[i];
        }
        return matrixAux;
    }

    private double[][] transpose(double[][] matrix) {
        double[][] matrixTransposed = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixTransposed[i][j] = matrix[j][i];
            }
        }

        return matrixTransposed;

    }
    private double regressionLine(double x1, double x2){
        return matrixB[0]+matrixB[1]*x1+matrixB[2]*x2;

    }

    private double[][] matrixXXT(double[][] matrixX, double[][] matrixXTransposed) {
        return multiplyTwoArraysBi(matrixX, matrixXTransposed);
    }

    private double[] matrixXTY(double[][] matrixXTransposed, double[] y) {
        return multiplyBiArrayWithArray(matrixXTransposed, y);

    }

    private static double[][] invert(double a[][]) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i] * b[index[i]][k];

        // Perform backward substitutions
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    // Method to carry out the partial-pivoting Gaussian
    // elimination.  Here index[] stores pivoting order.
    public static void gaussian(double matrix[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(matrix[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(matrix[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = matrix[index[i]][j] / matrix[index[j]][j];

                // Record pivoting ratios below the diagonal
                matrix[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    matrix[index[i]][l] -= pj * matrix[index[j]][l];
            }
        }
    }


    private double sqt() {
        return multipleYTY() - (matrixY.length * y * y);
    }

    private double multipleYTY() {
        double som = 0;
        for (int i = 0; i < matrixY.length; i++) {
            som += Math.pow(matrixY[i], 2);
        }
        return som;
    }

    private double sqr() {
        double som=0;
        for (int i=0; i<matrixB.length; i++){
            som+=matrixB[i]*matrixXTY[i];
        }
        return som-(matrixY.length*(Math.pow(y,2)));

    }

    private double sqe() {
        double som=0;
        for (int i=0; i<matrixB.length; i++){
            som+=matrixB[i]*matrixXTY[i];
        }
        return multipleYTY() - som;

    }

    private double rSquare() {
        return sqr() / sqt();
    }

    private double rSquareAdjusted() {
        return (1-(((double)(matrixY.length-1)/(matrixY.length-matrixX[0].length))*(1- rSquare())));
    }

    private double standardDeviation() {
        return sqe() / (matrixY.length - matrixX[0].length);
    }

    private double[] cjj() {
        double[] cjj = new double[historicalPointsY.length];
        for (int i=0; i<cjj.length; i++){
            double[] xt = {1, historicalPointsX1[i], historicalPointsX2[i]};
            double[] aux = multiplyBiArrayWithArray(xt, matrixXTXInverse);
            for (int j=0; j<aux.length; j++){
                cjj[i]+=aux[j]*xt[j];
            }
        }
        return cjj;
    }

    private double tStudent() {
        TDistribution td = new TDistribution(matrixY.length-matrixX[0].length);
        double critTD;
        double alphaTD = 1 - (1-trustLevel)/(double) 2;
        if (alphaTD > 0.5) {
            critTD = td.inverseCumulativeProbability(alphaTD);
        } else {
            critTD = td.inverseCumulativeProbability(1 - alphaTD);
        }
        return critTD;
    }

    private double yHat(int index){
        return matrixB[0]+matrixB[1]*historicalPointsX1[index]+matrixB[2]*historicalPointsX2[index];
    }
    private double[][] multiplyTwoArraysBi(double[][] xt, double[][] x){
        double[][] temp = new double[xt.length][x[0].length];
        for (int i = 0; i < xt.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                temp[i][j] = 0;
                for (int k = 0; k < x.length; k++) {
                    temp[i][j] += xt[i][k] * x[k][j];
                }
            }
        }
        return temp;
    }
    private double[] multiplyBiArrayWithArray(double[][] x, double[]y){
        double[] temp=new double[x.length];
        int result=-1;
        for (double[] doubles : x) {
            result++;
            for (int j = 0; j < y.length; j++) {
                temp[result] += doubles[j] * y[j];
            }

        }
        return temp;
    }
    private double[] multiplyBiArrayWithArray(double[] x, double[][]y){
        double[] temp=new double[y.length];
        int result=-1;
        for (double[] doubles : y) {
            result++;
            for (int j = 0; j < y.length; j++) {
                temp[result] += doubles[j] * x[j];
            }

        }
        return temp;
    }

    private double[][] confidenceInterval(){
        double[][] breaks = new double[historicalPointsY.length][2];

        for (int i=0; i< historicalPointsY.length; i++){
            breaks[i][0] = yHat(i)-(tStudent()*Math.sqrt(standardDeviation()*(1+cjj[i])));
            breaks[i][1] = yHat(i)+(tStudent()*Math.sqrt(standardDeviation()*(1+cjj[i])));
        }
        return breaks;
    }
    private double mqr(){
        return sqr()/(double) (matrixX[0].length-1);
    }
    private double mqe(){
        return sqe()/(double) (matrixY.length-matrixX[0].length);
    }
    private double testStatistics(){
        return mqr()/mqe();
    }

    private double fDistribution(){
        FDistribution fd= new FDistribution(matrixX[0].length-1,matrixY.length-matrixX[0].length);
        double alphaFD= significanceLevel;
        return fd.inverseCumulativeProbability(1- alphaFD);
    }

    private String  decision(){
        StringBuilder stringBuilder = new StringBuilder();
        if (testStatistics()>fDistribution()){
            stringBuilder.append(String.format("Decision: (f0 = %.2f) > (f%.2f(%d, %d) = %.2f)\n", f0, significanceLevel,matrixX[0].length-1, matrixY.length-1,fDistribution()));
            stringBuilder.append(String.format("Reject H0, the model is significant\n"));
        }else {
            stringBuilder.append(String.format("Decision: (f0 = %.2f) <= (f%.2f(%d, %d) = %.2f)\n", f0, significanceLevel,matrixX[0].length-1, matrixY.length-1,fDistribution()));
            stringBuilder.append(String.format("Don't reject H0, the model is not significant\n"));
        }

        return stringBuilder.toString();
    }

    private double[][] hypothesisTest(double significanceLevel){
        double[][] matrix = new double[3][2];
        double tAlpha;
        tAlpha = tStudent();
        for (int i=0; i<matrix.length;i++){
            matrix[i][0] = tAlpha;
            matrix[i][1] = matrixB[i]/Math.sqrt(standardDeviation()*matrixXTXInverse[i][i]);
        }
        return matrix;
    }

    private String hypothesisTestText(int index ){
        String result;
        double[][] matrix = hypothesisTest(significanceLevel);
        if (Math.abs(matrix[index][1])<=matrix[index][0]){
            result = "Don't reject H0";
        }else {
            result = "Reject H0";
        }
        return  result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The regression model fitted using data from the interval: y = %.2f + %.2fx1 + %.2fx2\n", matrixB[0], matrixB[1], matrixB[2]));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("----------* Other statistics *----------\n"));
        stringBuilder.append(String.format("R^2 = %.2f\n", rSquare() ));
        stringBuilder.append(String.format("R^2 adjusted = %.2f\n", rSquareAdjusted()));
        stringBuilder.append(String.format("y Average = %.2f\n", y));
        stringBuilder.append(String.format("Standard deviation = %.2f\n", standardDeviation()));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("----------* Significance model with Anova *----------\n"));
        stringBuilder.append(String.format("                     Sum of squares          Degrees of freedom          Root mean          Test statistic f \n"));
        stringBuilder.append(String.format(" Regression        |     %.2f           |             %d            |      %.2f       |          %.2f        \n", sqr(), matrixX[0].length-1, mqr(), testStatistics()));
        stringBuilder.append(String.format(" Error             |     %.2f            |             %d            |      %.2f       |                       \n", sqe(), matrixY.length-matrixX[0].length, mqe()));
        stringBuilder.append(String.format(" Total             |     %.2f           |             %d            |                 |                       \n", sqt(), matrixY.length-1));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(decision());
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("----------* Hypothesis tests for regression coefficients β0 *----------\n"));
        stringBuilder.append(String.format("H0 : β0 = 0\n"));
        stringBuilder.append(String.format("H1 : β0 != 0\n"));
        stringBuilder.append(String.format("Critical region: ]-∞, %.2f[ U ]%.2f, +∞[\n", matrixHypotheses[0][0], matrixHypotheses[0][0]));
        stringBuilder.append(String.format("t Observed = %.2f\n", matrixHypotheses[0][1]));
        stringBuilder.append(String.format("Decision : %s\n", hypothesisTestText(0)));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("----------* Hypothesis tests for regression coefficients β1 *----------\n"));
        stringBuilder.append(String.format("H0 : β1 = 0\n"));
        stringBuilder.append(String.format("H1 : β1 != 0\n"));
        stringBuilder.append(String.format("Critical region: ]-∞, %.2f[ U ]%.2f, +∞[\n", matrixHypotheses[0][0], matrixHypotheses[0][0]));
        stringBuilder.append(String.format("t Observed = %.2f\n", matrixHypotheses[1][1]));
        stringBuilder.append(String.format("Decision : %s\n", hypothesisTestText(1)));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("----------* Hypothesis tests for regression coefficients β2 *----------\n"));
        stringBuilder.append(String.format("H0 : β2 = 0\n"));
        stringBuilder.append(String.format("H1 : β2 != 0\n"));
        stringBuilder.append(String.format("Critical region: ]-∞, %.2f[ U ]%.2f, +∞[\n", matrixHypotheses[0][0], matrixHypotheses[0][0]));
        stringBuilder.append(String.format("t Observed = %.2f\n", matrixHypotheses[2][1]));
        stringBuilder.append(String.format("Decision : %s\n", hypothesisTestText(2)));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("----------* Prediction values *----------\n"));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("Date                    |          Number of OBSERVED positive cases          |          Number of ESTIMATED positive cases           |          %.1f%% intervals             \n", trustLevel*100));
        for (int i=0; i<historicalPointsY.length; i++){
            stringBuilder.append(String.format("%s              |                       %.2f                          |                       %.2f                           |          ] %.2f; %.2f [             \n", historicalPoints.get(i), regressionLine(historicalPointsX1[i], historicalPointsX2[i]), confidenceInterval[i][0], confidenceInterval[i][1]));
        }



        return stringBuilder.toString();
    }

    @Override
    public String regressionInformation() {
        return toString();
    }
}