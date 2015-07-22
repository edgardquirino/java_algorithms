/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author tsukanomon
 * @param <K>
 * @param <V>
 */
public abstract class AbstractMap<K,V> implements Map<K, V> {
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }
    
    /*
     * Nested MapEntry Class
     */
    
    protected static class MapEntry<K,V> implements Entry<K,V>{

        private K k;
        private V v;
        public MapEntry(K key, V value){
            k= key;
            v = value;
        }
        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
        protected void setKey(K key){
            k = key;
        }
        
    }
    /*End Nested MapEntry Class */
    
    //Support for public keySet method
    private class KeyIterator implements Iterator<K>{
        private Iterator<Entry<K,V>> entries = entrySet().iterator();
        
        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }
        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }        
    }
    
    private class keyIterable implements Iterable<K>{        
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }        
    }
    
    @Override
    public Iterable<K> keySet(){
        return new keyIterable();
    }
    
    //Support for public values method
    private class ValueIterator implements Iterator<V>{
        private Iterator<Entry<K,V>> entries = entrySet().iterator();        
        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }  
    }
    
    private class ValueIterable implements Iterable<V>{

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }     
    }
    
    @Override
    public Iterable<V> values(){
        return new ValueIterable();
    }
}
