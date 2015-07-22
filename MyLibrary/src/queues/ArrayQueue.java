/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

/**
 *
 * @author tsukanomon
 * This class uses the idea of an Array Circularly
 * by implementing it with arithmetic modular
 */
public class ArrayQueue<E> implements Queue<E> {

    E[] data;
    int f = 0;
    int sz = 0;
    private static final int CAPACITY = 1000;
    public ArrayQueue(){this(CAPACITY);}
    
    public ArrayQueue(int capacity){
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public int size() {
     return sz;     
    }

    @Override
    public void enqueue(E e) throws IllegalStateException {
     if(sz == data.length){
        throw new IllegalStateException("Queue is full");
     }
     int availPos = (f+sz)%data.length;
     data[availPos] = e;
     sz++;
  
    }

    @Override
    public E first() {
        if(isEmpty()) return null;
        return data[f];
    }

    @Override
    public E dequeue() {
        if(isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f+1)%data.length;
        sz--;
        return answer;
    }
    

    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }
}
