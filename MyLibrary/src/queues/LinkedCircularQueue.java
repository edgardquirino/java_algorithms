/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

import list.CircularlyLinkedList;

/**
 *
 * @author tsukanomon
 */
public class LinkedCircularQueue<E> implements CircularQueue<E>{
    private CircularlyLinkedList list = new CircularlyLinkedList();
    @Override
    public void rotate() {
        list.rotate();
    }

    @Override
    public int size() {
       return list.size();
    }

    @Override
    public boolean isEmpty() {
       return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return (E) list.first();
    }

    @Override
    public E dequeue() {
           return (E) list.removeFirst();
    }
    
}
