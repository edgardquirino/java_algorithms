/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;

/**
 *
 * @author tsukanomon
 * @param <K>
 * @param <V>
 */
public abstract class AbstractSortedMap<K,V> extends AbstractMap<K, V> implements SortedMap<K, V>{
 // instance variable for an AbstractSortedMap
  /** The comparator defining the ordering of keys in the map. */
  private Comparator<K> comp;

  /**
   * Initializes the comparator for the map.
   * @param c comparator defining the order of keys in the map
   */
  protected AbstractSortedMap(Comparator<K> c) {
    comp = c;
  }
  
  /** Initializes the map with a default comparator. */
  protected AbstractSortedMap() {
    this(new Comparator<K>() {
        @Override
        public int compare(K o1, K o2) {
            return (o1 == null || o2 == null) ? -1 : o1.toString().compareTo(o2.toString());            
        }
    });    // default comparator uses natural ordering
  }

  
    @Override
    public Comparator<? super K> comparator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public K firstKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public K lastKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
