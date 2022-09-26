package dev.lochness.bst;

import lombok.Data;

@Data
public class BinarySearchTree {

    private int key;
    private BinarySearchTree left;
    private BinarySearchTree right;
    private BinarySearchTree parent;

    public BinarySearchTree(int x) {
        this.key = x;
    }

    public BinarySearchTree(int x, BinarySearchTree parent) {
        this.key = x;
        this.parent = parent;
    }

    public void insert(int x) {
        if (x == key)
            return;
        if (x < key) {
            if (left == null) {
                left = new BinarySearchTree(x, this);
                return;
            }
            left.insert(x);
        } else {
            if (right == null) {
                right = new BinarySearchTree(x, this);
                return;
            }
            right.insert(x);
        }
    }

    public boolean search(int x) {
        if (x == key) {
            return true;
        } else if (x < key) {
            return left != null && left.search(x);
        } else {
            return right != null && right.search(x);
        }
    }

    public void remove(int x) {
        if (x == key) {
            BinarySearchTree swapTree = null;
            //has 1 node to the left
            if (left != null && right == null) {
                swapTree = left;
                left.parent = this.parent;
            }
            //has 1 node to the right
            if (right != null && left == null) {
                swapTree = right;
                right.parent = this.parent;
            }
            //has 2 nodes
            if (left != null && right != null) {
                swapTree = right;
                //lookup for lowest leaf
                while (swapTree.left != null) {
                    swapTree = swapTree.left;
                }
                //replace removed element
                swapTree.left = left;
                swapTree.parent = parent;
                swapTree.parent.right = swapTree;
                if (right != swapTree) {
                    swapTree.right = right;
                }
            }
            //unset all links for GC to collect
            left = null;
            right = null;
            if (this.parent != null) {
                if (parent.left == this)
                    parent.left = swapTree;
                if (parent.right == this)
                    parent.right = swapTree;
                this.parent = null;
            }
        }
        if (x > key) {
            if(right != null)
                right.remove(x);
        }
        if (x < key) {
            if(left != null)
                left.remove(x);
        }
    }

    public void sort() {
        if (left != null) {
            left.sort();
        }
        System.out.printf("[%d] ", key);
        if (right != null) {
            right.sort();
        }
    }
}
