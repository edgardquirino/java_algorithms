/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author tsukanomon
 */
public class ArrayList<E> implements List<E> {

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    
    public ArrayList(){
        this(CAPACITY);
    }
    public ArrayList(int capacity){
        data = (E[]) new Object[capacity];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i,size);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i,size);
        E temp =data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i,size+1);
        if(size == data.length){
            resize(2*data.length);
        }
        for(int k = size -1;k>=i;k--){
            data[k+1]=data[k];
        }
        data[i]=e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i,size);
        E temp = data[i];
        for(int k =i;k<size-1;k++){
            data[k] = data[k+1];
        }
        //Null here helps the garbage collector
        data[size-1] = null;
        size--;
        return temp;
    }
    
    protected void checkIndex(int i, int n){
        if( i<0 || i>=n){
            throw new IndexOutOfBoundsException("Illegal Index: "+i);
        }
    }
   protected void resize(int capacity){
       E[] temp = (E[]) new Object[capacity];
       for(int i = 0; i< size;i++){
           temp[i] = data[i];
       }
       data = temp;
   } 
}
