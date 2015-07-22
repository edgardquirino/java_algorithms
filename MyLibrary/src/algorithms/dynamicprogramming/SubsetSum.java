/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamicprogramming;

/**
 *
 * @author edgard
 */
public class SubsetSum {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = {63, 21, 78, 45, 59, 62, 37, 22, 19, 101};
        
        if( hasSum(array, 200) )
            System.out.println("Yes");
        else
            System.out.println("No");
            
        int [] array1 = {10, 34, 19, 27, 58, 45};
        
        if( hasSum(array1, 100) )
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
    //Brute force method based on recursion; exponential time cmplexity
    /*public static boolean hasSum(int [] array, int start, int sum)
    {
        if( sum == 0 ) //found the sum?
            return true;
        
        if( start > array.length-1 )//reached end of the array?
            return false;
        
        return hasSum(array, start+1, sum) || hasSum(array, start+1, sum-array[start]);
        
    }*/
    
    //method based on dynamic programming
    public static boolean hasSum(int [] array, int sum)
    {
        int len = array.length;
        boolean[][] table = new boolean[sum+1][len+1];
        
        int i;
        
        //If sum is zero; empty subset always has a sum 0; hence true
        for( i = 0; i <= len; i++ )
            table[0][i] = true;
        
        //If set is empty; no way to find the subset with non zero sum; hence false
        for( i = 1; i <= sum; i++ )
            table[i][0] = false;
        
        //calculate the table entries in terms of previous values
        for( i = 1; i <= sum; i++ )
        {
            for( int j = 1; j <= len; j++ )
            {
                table[i][j] = table[i][j-1]; 
                
                if( !table[i][j] && i >= array[j-1] )
                    table[i][j] = table[i-array[j-1]][j-1];
            }
        }        
        
        return table[sum][len];
    }
}
