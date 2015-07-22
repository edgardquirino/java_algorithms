/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.math;

/**
 *
 * @author edgard
 */
public class Matrix {
    /**
 * Matrix multiplication method.
 * @param m1 Multiplicand
 * @param m2 Multiplier
 * @return Product
 */

    
    
    public static double[][] transpose(double[][] m1) {

        for (int i = 0; i < m1.length; i++) {
            for (int j = i; j < m1[0].length; j++) {
                double x = m1[i][j];
                m1[i][j] = m1[j][i];
                m1[j][i] = x;
            }
        }
        return m1;
    }
    
     public static double[][] rotateByNinetyToLeft(double[][] m) {
        // transpose
        m=transpose(m);

        //  swap rows
        for (int  i = 0; i < m.length/2; i++) {
            for (int j = 0; j < m[0].length; j++) {
                double x = m[i][j];
                m[i][j] = m[m.length -1 -i][j]; 
                m[m.length -1 -i][j] = x;
            }
        }
        return m;
    }


    public static double[][] rotateByNinetyToRight(double[][] m) {
        // transpose
        m=transpose(m);

        // swap columns
        for (int  j = 0; j < m[0].length/2; j++) {
            for (int i = 0; i < m.length; i++) {
                double x = m[i][j];
                m[i][j] = m[i][m[0].length -1 -j]; 
                m[i][m[0].length -1 -j] = x;
            }
        }
        return m;
    }
    
    
    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if(m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m1
            for(int j = 0; j < mRColLength; j++) {     // columns from m2
                for(int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

    
    public static String toString(double[][] m) {
        String result = "";
        for (double[] m1 : m) {
            for (int j = 0; j < m1.length; j++) {
                result += String.format("%11.2f", m1[j]);
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        // #1
        double[][] multiplicand = new double[][] {
                {3, -1, 2},
                {2,  0, 1},
                {1,  2, 1}
        };
        double[][] multiplier = new double[][] {
                {2, -1, 1},
                {0, -2, 3},
                {3,  0, 1}
        };
        System.out.println("#1\n" + toString(multiplyByMatrix(multiplicand, multiplier)));
        System.out.println("#1RotateByRight\n"+ toString(rotateByNinetyToRight(multiplier)));
        // #2
        multiplicand = new double[][] {
                {1, 2, 0},
                {-1, 3, 1},
                {2, -2, 1}
        };
        multiplier = new double[][] {
                {2},
                {-1},
                {1}
        };
        System.out.println("#2\n" + toString(multiplyByMatrix(multiplicand, multiplier)));
        // #3
        multiplicand = new double[][] {
                {1, 2, -1},
                {0,  1, 0}
        };
        multiplier = new double[][] {
                {1, 1, 0, 0},
                {0, 2, 1, 1},
                {1, 1, 2, 2}
        };
        System.out.println("#3\n" + toString(multiplyByMatrix(multiplicand, multiplier)));
    }
}

