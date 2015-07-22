/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;
import java.util.Comparator;
import queues.LinkedQueue;
import queues.Queue;

/**
 *
 * @author tsukanomon
 */
public class MergeSort {

    /*
     * Merge contents of arrays S1 and S2 into a properly sized array S     
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }
    }

    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n >= 2) {
            //divide
            int mid = n / 2;
            K[] S1 = Arrays.copyOfRange(S, 0, mid);
            K[] S2 = Arrays.copyOfRange(S, mid, n);

            //conquer(with recursion)
            mergeSort(S1, comp);
            mergeSort(S2, comp);

            //merge results
            merge(S1, S2, S, comp);
        }

    }

    /*
     * Merge contents of sorted queues S1 and S2 into empty queue S
     */
    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp) {
        while (!S1.isEmpty() && !S2.isEmpty()) {
            if (comp.compare(S1.first(), S2.first()) < 0) {
                S.enqueue(S1.dequeue()); // take next element from S1
            } else {
                S.enqueue(S2.dequeue()); // take next element from S2
            }
        }
        while (!S1.isEmpty()) {
            S.enqueue(S1.dequeue());
        }
        while (!S2.isEmpty()) {
            S.enqueue(S2.dequeue());
        }
    }

    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size() / 2;
        if (n >= 2) {
            //divide
            Queue<K> S1 = new LinkedQueue<>();
            Queue<K> S2 = new LinkedQueue<>();
            while (S1.size() < n / 2) {
                S1.enqueue(S.dequeue());
            }
            while (!S.isEmpty()) {
                S2.enqueue(S.dequeue());
            }
            //conquer
            mergeSort(S1, comp);
            mergeSort(S2, comp);

            //merge results
            merge(S1, S2, S, comp);
        }
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
        mergeSort(s, Comparator.naturalOrder());
        mergeSort(q, Comparator.naturalOrder());

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
        /*for (Integer i : s) {
         System.out.println(i);
         }*/
    }

}
