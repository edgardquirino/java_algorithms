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
public class ArrayElementsSumm {
    
    //Linear implementation of Array Sum Elements O(n)
    public static int linearArrayElementsSum(int[] array, int n){
        if(n == 0){
            return 0;
        }else{
            return linearArrayElementsSum(array,n-1) + array[n-1];
        }  
    }
    //Linear in time O(n) but logathmic in space O(log n)
    public static int binaryArrayElementsSum(int[] array, int low, int high){
        if(low > high) return 0;
        else if( low == high) return array[low];
        else {
            int median = (low + high)/2;
            return binaryArrayElementsSum(array,low,median) + binaryArrayElementsSum(array,median+1,high); 
        }        
    }    
}
