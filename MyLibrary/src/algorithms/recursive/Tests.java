/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.recursive;

import java.io.File;

/**
 *
 * @author tsukanomon
 */
public class Tests {
    public static void main(String... args){
        
        
        double n = 15;
        int[] mArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //Naive Factorial
        System.out.println(Factorial.factorial(n));
        
        //Binary Search
        System.out.println(BinarySearch.binarySearch(mArray, 12, 0, 
                mArray.length-1));
        
        //Disk Usage Recursive way
        System.out.println(FileSystem.diskUsage(new File("C:\\Users\\tsukanomon\\Downloads")));
        
    }
    
    
}
