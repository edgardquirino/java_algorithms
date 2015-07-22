/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

/**
 *
 * @author tsukanomon
 */
public interface Queue<E> {
    
    int size();
    boolean isEmpty();
    void enqueue(E e);
    E first();
    E dequeue();
    
    
}
