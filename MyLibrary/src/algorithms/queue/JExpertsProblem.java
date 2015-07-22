package algorithms.queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsukanomon
 *
 * /**
 * Printar numeros de 1 a 100 separados por virgula quando for multiplo de 3
 * printar J quando for multiplo de 5 printar Experts quando for multiplo de 3 e
 * 5 printar JExperts para os demais numeros printar o proprio numero separado
 * por virgula. 1,2,J,4,Experts,J,7,8,J...14,JExperts,...100
*
 */
public class JExpertsProblem {

    public static void printNumbers() {
        for (int i = 1; i <= 100; i++) {
             if(isMultiple(i, 3) && isMultiple(i, 5)){
                 System.out.print("JExperts,");
             }else if(isMultiple(i, 3)){
                 System.out.print("J,");
             }else if(isMultiple(i, 5)){
                 System.out.print("Experts,");
             }else{
                 System.out.print(i+",");
             }   
        }
    }

    private static boolean isMultiple(int number, int multiple) {
        return ((number % multiple) == 0);
    }

    public static void main(String... args){
        JExpertsProblem.printNumbers();
    }
}
