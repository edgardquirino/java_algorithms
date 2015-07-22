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
public class Factorial {

    public static double factorial(double n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }

    }

}
