/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.queue;

import queues.CircularQueue;
import queues.LinkedCircularQueue;

/**
 *
 * @author tsukanomon
 */
public class JosephusProblem {

    public static <E> E josephusSolver(CircularQueue<E> queue, int k) {
        if (queue.isEmpty()) {
            return null;
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.rotate();
            }
            E e = queue.dequeue();
            System.out.println(e + " is out!");
        }
        return queue.dequeue();
    }

    public static <E> CircularQueue<E> buildQueue(String[] array) {
        CircularQueue queue = new LinkedCircularQueue();
        for (String name : array) {
            queue.enqueue(name);
        }
        return queue;
    }

    public static void main(String... arg) {
        String[] ai = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        System.out.println("The first winner is: " + josephusSolver(buildQueue(ai), 3));
    }

}
