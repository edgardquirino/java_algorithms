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
public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            next = n;
            prev = p;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }
        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> node) {
            next = node;
        }
        
        public void setPrev(Node<E> node) {
            prev = node;
        }
    }
    
    private Node<E> header ;
    private Node<E> trailer;
    private int size = 0;
    
    public DoublyLinkedList(){
        header = new Node(null, null, null);
        trailer = new Node(null,header, null);
        header.setNext(trailer);
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    
    public E first(){
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    
    public void addFirst(E e){        
        addBetween(e,header ,header.getNext());
    }
    
    public void addLast(E e){       
        addBetween(e, trailer.getPrev(),trailer);        
    }
    
    private void addBetween(E e, Node<E> prev, Node<E> next){        
        Node<E> newest = new Node(e, prev, next);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
    }
    
    public E removeFirst(){
        if(isEmpty()) return null;        
        return remove(header.getNext());        
    }
    
    public E removeLast(){
        if(isEmpty()) return null;        
        return remove(trailer.getPrev());        
    }
    
    private E remove(Node<E> node){
        Node<E> prevNode = node.getPrev();
        Node<E> nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
        return node.getElement();
    }
    @Override
    public String toString() {
        String values = "";
        Node<E> aux = header.getNext();
        while (aux != trailer) {
            values += aux.getElement() + " ";
            aux = aux.getNext();
        }
        return values;
    }
    
}
