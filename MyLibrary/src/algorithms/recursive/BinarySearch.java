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
public class BinarySearch {

    //Binary Search recursive implementation
    public static boolean binarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int median = (low + high) / 2;
            if (array[median] == target) {
                return true;
            } else if (target < array[median]) {
                return binarySearch(array, target, low, median - 1);
            } else {
                return binarySearch(array, target, median + 1, high);
            }
        }
    }

    //Iterative IMplementation
    public static boolean binarySearch(int[] array, int target) {
        int low =0;
        int high = array.length-1;
        while(low <= high){
            int median = (low + high)/2;
            if(target == array[median]){
                return true;
            }else if(target < array[median]){
                high = median -1;
                
            }else{
                low = median +1;
            }
        }
        return false;
    }
    
    
}
