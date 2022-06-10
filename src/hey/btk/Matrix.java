package hey.btk;

public class Matrix {

    private double[][] matrix = new double[4][4];

    public Matrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }
    }

    public Matrix(double m00, double m01, double m02, double m03,
                  double m10, double m11, double m12, double m13,
                  double m20, double m21, double m22, double m23,
                  double m30, double m31, double m32, double m33) {
        setValue(0, 0, m00);
        setValue(0, 1, m01);
        setValue(0, 2, m02);
        setValue(0, 3, m03);
        setValue(1, 0, m10);
        setValue(1, 1, m11);
        setValue(1, 2, m12);
        setValue(1, 3, m13);
        setValue(2, 0, m20);
        setValue(2, 1, m21);
        setValue(2, 2, m22);
        setValue(2, 3, m23);
        setValue(3, 0, m30);
        setValue(3, 1, m31);
        setValue(3, 2, m32);
        setValue(3, 3, m33);
    }

//    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
//        int[][] c = new int[a.length][a.length];
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b.length; j++) {
//                for (int k = 0; k < a.length; k++) {
//                    c[i][j] += a[i][k]*b[k][j];
//                }
//            }
//        }
//        return c;
//    }

    public Matrix mult(Matrix m2) {
        Matrix res = new Matrix();
        res.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    res.setValue(i, j, res.getValue(i, j) + matrix[i][k] * m2.getValue(k, j));
                }
            }
        }
        return res;
    }

    public void clear() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void setValue(int i, int j, double value) {
        matrix[i][j] = value;
    }

    public double getValue(int i, int j) {
        return matrix[i][j];
    }


    public void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
