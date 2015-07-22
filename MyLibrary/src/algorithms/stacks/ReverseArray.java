/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.stacks;

import stacks.ArrayStack;
import stacks.Stack;

/**
 *
 * @author tsukanomon
 */
public class ReverseArray {
    
    public static <E> void reverse(E[] array){
        Stack<E> buffer = new ArrayStack<>(array.length);
        for (E array1 : array) {
            buffer.push(array1);
        }
        for(int i = 0; i<array.length;i++){
            array[i] = buffer.pop();
        }
        
    }
    
    
}
