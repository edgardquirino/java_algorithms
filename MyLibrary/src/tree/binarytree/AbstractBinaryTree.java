/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import tree.AbstractTree;
import tree.Position;

/**
 *
 * @author tsukanomon
 */
public class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E>{

    
        
    @Override
    public int numChildren(Position<E> p){
        int count = 0;
        if( left(p) != null){
            count++;
        }
        if(right(p) != null){
            count++;
        }
        return count;
    }
    
    @Override
    public Iterable<Position<E>> children(Position<E> p){
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p) != null){
            snapshot.add(left(p));
        }
        if(right(p) != null){
            snapshot.add(right(p));
        }
        return snapshot;
    }
    
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if(parent == null){
            return null;
        }
        if(p == left(parent)){
            return right(parent);
        }else{
            return left(parent);
        }
    }
    
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
       if(left(p)!= null){
           inorderSubtree(left(p), snapshot);
       }
       snapshot.add(p);
       if(right(p)!= null){
           inorderSubtree(right(p), snapshot);
       }
    }

    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot);
        }
        return snapshot;
    }
    
    @Override
    public Iterable<Position<E>> positions(){
        return inorder();
    }
    
    
}
