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
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        //SinglyLinkedList
        System.out.println("SinglyLinked List");
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();
        myList.addFirst(12);
        myList.addFirst(14);
        myList.addFirst(10);
        myList.addLast(55);
        System.out.println(myList.toString());
        myList.removeFirst();
        System.out.println(myList.toString());
        
        //CircularlyLinkedList
        System.out.println("Circular Linked List");
        CircularlyLinkedList<Integer> myCircularList = new CircularlyLinkedList<>();
        myCircularList.addFirst(12);
        myCircularList.addFirst(14);
        myCircularList.addFirst(10);
        myCircularList.addLast(55);
        System.out.println(myCircularList.toString());
        myCircularList.removeFirst();
        System.out.println(myCircularList.toString());
        
        //CircularlyLinkedList
        System.out.println("Doubly Linked List");
        DoublyLinkedList<Integer> myDoublyList = new DoublyLinkedList<>();
        myDoublyList.addFirst(12);
        myDoublyList.addFirst(14);
        myDoublyList.addFirst(10);
        myDoublyList.addLast(55);
        System.out.println(myDoublyList.toString());
        myDoublyList.removeFirst();
        System.out.println(myDoublyList.toString());
        
    }
    
}
