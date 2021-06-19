package app;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.util.Arrays;

public class MultipleLinearRegression {

    private final double[][] matrixX;
    private final double[][] matrixXTXInverse;
    private final double[] matrixY;
    private final double[] matrixXTY;
    private final double[] matrixB;
    private final double[] cjj;
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
    public MultipleLinearRegression(double[] x1, double[] x2, double[] y, double trustLevel, double significanceLevel) {
        if (x1.length!=y.length){
            throw new IllegalArgumentException();
        }
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


    public double[][] matrixXXT(double[][] matrixX, double[][] matrixXTransposed) {
        return multiplyTwoArraysBi(matrixX, matrixXTransposed);
    }

    public double[] matrixXTY(double[][] matrixXTransposed, double[] y) {
        return multiplyBiArrayWithArray(matrixXTransposed, y);

    }

    public static double[][] invert(double a[][]) {
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
    public static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
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
                double pj = a[index[i]][j] / a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] -= pj * a[index[j]][l];
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

    public double sqr() {
        double som=0;
        for (int i=0; i<matrixB.length; i++){
            som+=matrixB[i]*matrixXTY[i];
        }
        return som-(matrixY.length*(Math.pow(y,2)));

    }

    public double sqe() {
        double som=0;
        for (int i=0; i<matrixB.length; i++){
            som+=matrixB[i]*matrixXTY[i];
        }
        return multipleYTY() - som;

    }

    public double rSquare() {
        return sqr() / sqt();
    }

    public double rSquareAdjusted() {
        return (1-(((double)(matrixY.length-1)/(matrixY.length-matrixX[0].length))*(1- rSquare())));
    }

    public double standardDeviation() {
        return sqe() / (matrixY.length - matrixX[0].length);
    }

    private double[] cjj() {
        double[] xt, cjj = new double[matrixY.length];
        for (int i=0; i<matrixX.length; i++){
            xt = matrixX[i];
            double[] aux = multiplyBiArrayWithArray(xt, matrixXTXInverse);
            for (int j=0; j<aux.length; j++){
                cjj[i]+=aux[j]*xt[j];
            }
        }
        return cjj;
    }

    private double tStudent(double alpha) {
        TDistribution td = new TDistribution(matrixY.length-matrixX[0].length);
        double critTD;
        double alphaTD = 1 - trustLevel/2;
        if (alphaTD > 0.5) {
            critTD = td.inverseCumulativeProbability(alphaTD);
        } else {
            critTD = td.inverseCumulativeProbability(1 - alphaTD);
        }
        return critTD;
    }

    private double yHat(int index){
        return matrixB[0]+matrixB[1]*matrixX[index][1]+matrixB[2]*matrixX[index][2];
    }
    public double[][] multiplyTwoArraysBi(double[][] xt, double[][] x){
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
    public double[] multiplyBiArrayWithArray(double[][] x, double[]y){
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
    public double[] multiplyBiArrayWithArray(double[] x, double[][]y){
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

    public double[][] confidenceInterval(int meaningfulness){
        double[][] breaks = new double[matrixY.length][2];

        for (int i=0; i< matrixY.length; i++){
            breaks[i][0] = yHat(i)-(tStudent(trustLevel)*Math.sqrt(standardDeviation()*(1+cjj[i])));
            breaks[i][1] = yHat(i)+(tStudent(trustLevel)*Math.sqrt(standardDeviation()*(1+cjj[i])));
        }
        return breaks;
    }
    public double mqr(){
        return sqr()/(double) (matrixX[0].length-1);
    }
    public double mqe(){
        return sqe()/(double) (matrixY.length-matrixX[0].length);
    }
    public double testStatistics(){
        return mqr()/mqe();
    }

    public double fDistribution(){
        FDistribution fd= new FDistribution(matrixX[0].length-1,matrixY.length-matrixX[0].length);
        double alphaFD= significanceLevel;
        return fd.inverseCumulativeProbability(1- alphaFD);
    }

    public String  decision(){
        StringBuilder stringBuilder = new StringBuilder();
        if (testStatistics()>fDistribution()){
            stringBuilder.append(String.format("Decision: (f0 = %.2f) > (f%.2f(%d, %d) = %.2f\n)", f0, significanceLevel,matrixX[0].length-1, matrixY.length-1,fDistribution()));
            stringBuilder.append(String.format("Reject H0, the model is significant\n"));
        }else {
            stringBuilder.append(String.format("Decision: (f0 = %.2f) <= (f%.2f(%d, %d) = %.2f)\n", f0, significanceLevel,matrixX[0].length-1, matrixY.length-1,fDistribution()));
            stringBuilder.append(String.format("Don't reject H0, the model is not significant\n"));
        }

        return stringBuilder.toString();
    }

    public double[][] hypothesisTest(int significanceLevel){
        double[][] matrix = new double[3][2];
        double tAlpha;
        tAlpha = tStudent(significanceLevel);
        for (int i=0; i<matrix.length;i++){
            matrix[i][0] = tAlpha;
            matrix[i][1] = matrixB[i]/Math.sqrt(standardDeviation()*matrixXTXInverse[i][i]);
        }
        System.out.println(Arrays.deepToString(matrix));
        hypothesisTestText(matrix);
        return matrix;
    }

    public void hypothesisTestText(double[][] matrix){
        for (int i=0; i<matrix.length; i++){
            if (Math.abs(matrix[i][1])<=matrix[i][0]){
                System.out.println("Don't reject H0");
            }else {
                System.out.println("Rejects H0");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The regression model fitted using data from the interval: y = %.2f + %.2fx1 + %.2fx2\n", matrixB[0], matrixB[1], matrixB[2]));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("----------* Other statistics *----------\n"));
        stringBuilder.append(String.format("R^2 = %.2f\n", rSquare() ));
        stringBuilder.append(String.format("R^2 adjusted = %.2f\n", rSquareAdjusted()));
        stringBuilder.append(String.format("y Average = %f\n", y));
        stringBuilder.append(String.format("Standard deviation = %f\n", standardDeviation()));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("----------* Significance model with Anova *----------\n"));
        stringBuilder.append(String.format("                     Sum of squares          Degrees of freedom          Root mean          Test statistic f \n"));
        stringBuilder.append(String.format(" Regression        |     %.2f           |             %d            |      %.2f       |          %.2f        \n", sqr(), matrixX[0].length-1, mqr(), testStatistics()));
        stringBuilder.append(String.format(" Error             |     %.2f           |             %d            |      %.2f       |                       \n", sqe(), matrixY.length-matrixX[0].length, mqe()));
        stringBuilder.append(String.format(" Error             |     %.2f           |             %d            |                 |                       \n", sqt(), matrixY.length-1));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(decision());
        stringBuilder.append(String.format("f0: %f\n",f0));
        stringBuilder.append(String.format("mqe: %f\n",mqe()));
        stringBuilder.append(String.format("mqr: %f\n",mqr()));

        return stringBuilder.toString();
    }

}