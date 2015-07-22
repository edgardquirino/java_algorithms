/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.ArrayList;
import java.util.Map.Entry;

/**
 *
 * @author tsukanomon
 */
public class ProbeHashMap<K,V> extends AbstractHashMap<K, V> {

    private MapEntry<K,V>[] table; //a fixed array of entries ( all initially null)
    private MapEntry<K,V> DEFUNCT  = new MapEntry<>(null,null); //sentinel

    public ProbeHashMap(int cap, int p) {
        super(cap, p);
    }

    public ProbeHashMap(int cap) {
        super(cap);
    }

    public ProbeHashMap() {
        super();
    }
    
    /** Creates an empty table having length equals to the current capacity*/
    @Override
    protected void createTable() {
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }
    
    private boolean isAvailable(int j){
        return (table[j] == null || table[j] == DEFUNCT);
    }
    
    private int findSlot(int h, K k){
        int avail = -1;
        int j = h;
        do{
            if(isAvailable(j)){
                if(avail == -1) avail = j; //the first available slot
                if(table[j] == null) break; //if empty, the search fails immediately
            }else if(table[j].getKey().equals(k)) return j; //successful match                
            j=(j+1)%capacity;
          }while(j != h); //stop when returning to start point
        return -(avail+1); //search has failed
    }

    @Override
    protected V bucketGet(int h, K k) {
        int j = findSlot(h, k);
        if(j <0) return null;
        return table[j].getValue();
    }

    @Override
    protected V bucketPut(int h, K k, V v) {
        int j = findSlot(h, k);
        if(j >= 0) return table[j].setValue(v);
        table[-(j+1)] = new MapEntry<>(k,v);
        n++;
        return null;
    }

    @Override
    protected V bucketRemove(int h, K k) {
        int j = findSlot(h, k);
        if( j < 0) return null;
        V answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return answer;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for(int h = 0; h< capacity;h++){
            if(!isAvailable(h)) buffer.add(table[h]);            
        }
        return buffer;
    }
    
    public static void main(String... args){
        ProbeHashMap<Integer,Integer> teste = new ProbeHashMap<>(8);
        teste.put(1, 2);
        teste.put(3, 4);
        teste.put(5, 6);
        for( Entry<Integer,Integer> e:teste.entrySet()){
            System.out.println(e.getKey() +" "+e.getValue());
        }
        teste.put(7, 8);
        teste.put(9, 10);
        teste.put(11, 12);
        teste.put(13, 14);
        teste.put(15, 16);
        teste.put(17, 18);
        for( Entry<Integer,Integer> e:teste.entrySet()){
            System.out.println(e.getKey() +" "+e.getValue());
        }
                
        System.out.println("Removido "+teste.remove(11));
        for( Entry<Integer,Integer> e:teste.entrySet()){
            System.out.println(e.getKey() +" "+e.getValue());
        }
    }
    
}
