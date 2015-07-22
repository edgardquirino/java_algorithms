/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree.binarytree;

import tree.Position;
import tree.Tree;

/**
 *
 * @author tsukanomon
 */
public interface BinaryTree<E> extends Tree<E> {
    
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
    
}
