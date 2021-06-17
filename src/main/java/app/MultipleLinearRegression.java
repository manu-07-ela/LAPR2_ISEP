package app;

public class MultipleLinearRegression {

    private final double[][] matrixX, matrixXTransposed,matrixXXT, matrixXTY, matrixXXTInverse, matrixXTYInverse, matrixB, matrixY;

    public MultipleLinearRegression(double[] x1, double[]x2, double[]y) {
         matrixX = matrixX(x1, x2);
         matrixXTransposed = matrixXTransposed(matrixX);
         matrixXXT = matrixXXT(matrixX, matrixXTransposed);
         matrixXTY = matrixXTY(matrixXTransposed, y);
         matrixXTYInverse = invert(matrixXTY);
         matrixXXTInverse = invert(matrixXXT);
         matrixB = multipleMatrix(matrixXXTInverse, matrixXTY);
         matrixY = multipleMatrix(matrixX, matrixB);


    }

    private double[][] matrixX(double[] x1, double[]x2){
        if (x1.length!= x2.length) throw new IllegalArgumentException("The arrays sizes should be the same");
        int length = x1.length;

        double[][] matrixAux = new double[3][length];
        // X matrix
        for (int i=0; i<length;  i++){
            matrixAux[i][0] = 1;
            matrixAux[i][1] = x1[i];
            matrixAux[i][2] = x2[i];
        }
        return  matrixAux;
    }

    private double[][] matrixXTransposed(double[][] matrix){
        double[][] matrixTransposed = new double[matrix[0].length][matrix.length];

        for (int i=0; i<matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixTransposed[i][j] = matrix[j][i];
            }
        }

        return matrixTransposed;

    }


    public double[][] matrixXXT(double[][] matrixX, double[][] matrixXTranposta){
        int n = matrixX[0].length; //A.columns = B.rows
        //Verfica se A.columns = B.rows
        if(n != matrixXTranposta.length){
            throw new IllegalArgumentException("A.columns != B.rows");
        }
        int rows = matrixX.length; //A.rows
        int cols = matrixXTranposta[0].length; //B.columns
        double[][] matrixXXT = new double[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int k = 0; k < n; k++){
                    matrixXXT[i][j] = matrixXXT[i][j] + matrixX[i][k] * matrixXTranposta[k][j];
                }
            }
        }
        return matrixXXT;
    }
    public double[][] matrixXTY(double[][] matrixXTransposta, double[] y) {
        int n = matrixXTransposta[0].length; //A.columns = B.rows
        //Verfica se A.columns = B.rows
        if (n != y.length) {
            throw new IllegalArgumentException("A.columns != B.rows");
        }
        int rows = matrixXTransposta.length; //A.rows
        int cols = y.length; //B.columns
        double[][] matrixXTY = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < n; k++) {
                    matrixXTY[i][j] = matrixXTY[i][j] + matrixXTransposta[i][k] * y[k];
                }
            }
        }
        return matrixXTY;
    }

    public static double[][] invert(double a[][])
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    // Method to carry out the partial-pivoting Gaussian
    // elimination.  Here index[] stores pivoting order.
    public static void gaussian(double a[][], int index[])
    {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i=0; i<n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            for (int j=0; j<n; ++j)
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    private double[][] multipleMatrix(double[][] matrix, double[][] matrixAux){
        double[][] matrixMultiplication = new double[matrix[0].length][matrixAux.length];
        if (matrix.length==matrix[0].length){
            for(int i=0;i<matrixMultiplication.length;i++) {
                for (int j = 0; j < matrixMultiplication[0].length; j++) {
                    matrixMultiplication[i][j] = 0;
                    for (int k = 0; k < 3; k++) {
                        matrixAux[i][j] += matrix[i][k] * matrixAux[k][j];
                    }
                }
            }
        }
        return matrixMultiplication;
    }
}
