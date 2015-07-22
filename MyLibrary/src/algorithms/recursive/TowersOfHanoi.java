/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.recursive;

import java.util.Scanner;

/**
 *
 * @author tsukanomon
 */
public class TowersOfHanoi {
     public void solve(int topN, String start, String auxiliary, String end ) {
       if (topN == 1) {
            System.out.println("Disk 1 from " + start + " to " + end);
       } else {
           solve(topN - 1, start, end, auxiliary);
          System.out.println("Disk " + topN + " from " + start + " to " + end);
           solve(topN - 1, auxiliary, start, end);
       }
   }

   public static void main(String[] args) {
       TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
       //System.out.print("Enter number of discs: ");
       //Scanner scanner = new Scanner(System.in);
       //int discs = scanner.nextInt();
       int discs = 3;
       //A, B and C are the name of my Towers
       towersOfHanoi.solve(discs, "A", "B", "C");
   }
    
    
    
    
}
