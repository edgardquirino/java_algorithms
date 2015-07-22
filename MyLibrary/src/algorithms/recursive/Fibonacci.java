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
public class Fibonacci {
    
    //Bad because it uses exponential time 2^n
    public static long badFibonacci(int n){
        if(n<=1) return 1;
        else return badFibonacci(n-2) + badFibonacci(n-1);
    }
    
    
    //Good implementation, since it can run in O(n) time
    //Return an array containing the pair F(n) and F(n-1), this way you avoid computing
    //elements that were already being computed in past calls.
    public static long[] goodFibonacci(int n){
        if(n<=1){
            long[] answer = {0,n};
            return answer;
        }else{
            long[] temp = goodFibonacci(n-1);
            long[] answer = {temp[0] + temp[1],temp[0]};
            return answer;
        }
    }
}
