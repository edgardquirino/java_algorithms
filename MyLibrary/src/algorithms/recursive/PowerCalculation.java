/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.recursive;

/**
 *
 * @author tsukanomon
 */
public class PowerCalculation {

    //O(n) implementation
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return power(x, n - 1) * x;
        }
    }

    //O(log n) implementation
    public static double powerLogN(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double partial = powerLogN(x, n / 2); // rely on truncated division
            double result = partial * partial;
            if (n % 2 == 1) { //if n is odd we need to include an extra factor of x
                result *= x;                
            }
            return result;
        }
    }

}
