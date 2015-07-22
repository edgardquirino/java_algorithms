/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Comparator;
import queues.LinkedQueue;
import queues.Queue;

/**
 *
 * @author tsukanomon
 */
public class QuickSort {
    /*
     * Quick-sort contents of a Queue
     */

    public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n >= 2) {
            K pivot = S.first(); //using first as arbitrary pivot
            Queue<K> L = new LinkedQueue<>();
            Queue<K> E = new LinkedQueue<>();
            Queue<K> G = new LinkedQueue<>();
            while (!S.isEmpty()) {
                K element = S.dequeue();
                int c = comp.compare(element, pivot);
                if (c < 0) {
                    L.enqueue(element);
                } else if (c == 0) {
                    E.enqueue(element);
                } else {
                    G.enqueue(element);
                }
            }
            //conquer
            quickSort(L, comp);
            quickSort(G, comp);
            while (!L.isEmpty()) {
                S.enqueue(L.dequeue());
            }
            while (!E.isEmpty()) {
                S.enqueue(E.dequeue());
            }
            while (!G.isEmpty()) {
                S.enqueue(G.dequeue());
            }

        }
    }
    
   
    public static<K> void quickSortInPlace(K[] S, Comparator<K> comp, int a, int b){
        if(a>=b) return; //subarray is trivially resolved
        int left = a;
        int right = b-1;
        K pivot = S[b];
        K temp; //temp object used for swapping
        while(left<=right){
            //scan until reaching value equal or larger than pivot (or right marker)
            while((left <=right) && ((comp.compare(S[left], pivot))<0)){
                left++;
            }
            //scan until reaching value equal or smaller than pivot (or right marker)
            while((left <=right) && ((comp.compare(S[right], pivot))>0)){
                right--;
            }
            if(left <= right){ //indices did not strictly cross
                //so swap values or shrink values
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;right--;
            }
        }
        
        //put pivot into its final place (currently marked by left index)
        temp = S[left];
        S[left] = S[b];
        S[b] = temp;
        //make recursive calls
        quickSortInPlace(S, comp, a, left-1);
        quickSortInPlace(S, comp, left+1, b);
        
        
    }
    
    
    
     public static void main(String... args) {         
        Integer[] s = {0, 5, 12, 4, 9, 3, 125, 14, 75, 9};
        Queue<Integer> q = new LinkedQueue<>();
        q.enqueue(0);
        q.enqueue(5);
        q.enqueue(12);
        q.enqueue(4);
        q.enqueue(9);
        q.enqueue(3);
        q.enqueue(125);
        q.enqueue(14);
        q.enqueue(75);
        q.enqueue(9);
        quickSortInPlace(s, Comparator.naturalOrder(),0,s.length-1);
        /*quickSort(q, Comparator.naturalOrder());

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }*/
        for (Integer i : s) {
         System.out.println(i);
         }
    }

}
