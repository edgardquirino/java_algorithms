/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamicprogramming;

/**
 *
 * @author tsukanomon
 */
public class LongestCommonSubString {
    //Returns table such that L[j][k] is length of LCS for X[0..j-1] and Y[0..k-1]
    public static int[][] LCS(char[] C, char[] S){
        int n = C.length;
        int m = S.length;
        int[][] L = new int[n+1][m+1];
        for(int j = 0; j<n;j++){
         for(int k=0;k<m;k++){
             if(C[j] == S[k]){ //align this match
                 L[j+1][k+1] = L[j][k]+1;
             }else{
                 L[j+1][k+1] = Math.max(L[j][k+1],L[j+1][k]);
             }
         }   
        }
        return L;
    }
   //Returns the longest common substring of X and Y, given LCS table L
    public static char[] reconstructLCS(char[] X, char[] Y, int[][] L){
        StringBuilder solution = new StringBuilder();
        int j = X.length;
        int k = Y.length;
        while(L[j][k] > 0){
            if(X[j-1] == Y[k-1]){
                solution.append(X[j-1]);
                j--;
                k--;
            }else if(L[j-1][k] >= L[j][k-1]) {
                j--;
            }else{
                k--;
            }  
        }
        //return the reversed string, since this is a botton-up approach
        return solution.reverse().toString().toCharArray();
    }
    
}
