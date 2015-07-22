/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.math;

import java.util.LinkedList;

/**
 *
 * @author edgard
 */
public class Permutations {

   public static void main(String args[]) {
    LinkedList<String> permList = permuteString("aabc");
    System.out.println(permList.toString());
  }

   
  public static LinkedList<String> permuteString(String text){
      LinkedList<String> permList = new LinkedList<>();
      permuteString("", text,permList);
      return permList;
  } 
   
  private static void permuteString(String beginningString, String endingString,LinkedList<String> permList) {
    if (endingString.length() <= 1)
      permList.add(beginningString + endingString);
    else
      for (int i = 0; i < endingString.length(); i++) {
        try {
          String newString = endingString.substring(0, i) + endingString.substring(i + 1);

          permuteString(beginningString + endingString.charAt(i), newString,permList);
        } catch (StringIndexOutOfBoundsException exception) {
          exception.printStackTrace();
        }
      }
  }

}
