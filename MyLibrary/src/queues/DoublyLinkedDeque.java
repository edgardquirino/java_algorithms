/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

import list.DoublyLinkedList;

/**
 *
 * @author tsukanomon
 * Exactly the same as the DoublyLinkedList
 */
public class DoublyLinkedDeque<E> implements Deque<E>{
    DoublyLinkedList<E> list = new DoublyLinkedList<>();
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E last() {
        return list.last();
    }

    @Override
    public void addFirst(E e) {
       list.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    @Override
    public E removeFirst() {
       return list.removeFirst();
    }

    @Override
    public E removeLast() {
       return list.removeLast();
    }
    
}
