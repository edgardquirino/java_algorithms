/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

import list.SinglyLinkedList;

/**
 *
 * @author tsukanomon
 */
public class LinkedStack<E> implements Stack<E>{
//This implementation uses the Adapter design pattern
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedStack(){}
    
    
    
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
       list.addFirst(e);
    }

    @Override
    public E peak() {
       return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    
    
    
}
