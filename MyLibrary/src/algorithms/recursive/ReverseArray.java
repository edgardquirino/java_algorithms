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
public class ReverseArray {
    
    public static void reverseIterativeArray(int[] array){
        int low = 0;
        int high = array.length-1;
        while(low < high){
           int temp = array[high];
           array[high] = array[low];
           array[low] = temp;
           low++;high--;
        }
    }
    
    public static void reverseRecursiveArray(int[] array,int low, int high){
        if(low < high){
           int temp = array[high];
           array[high] = array[low];
           array[low] = temp;
           reverseRecursiveArray(array,low+1,high-1); 
        }
    }
    
    
}
