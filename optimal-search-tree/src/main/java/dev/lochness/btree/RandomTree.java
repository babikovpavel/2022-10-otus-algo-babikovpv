package dev.lochness.btree;

import lombok.Data;

import java.util.Random;

@Data
public class RandomTree {

    private RandomTreeNode root;
    private int nodesCount;

    public void insert(int key) {
        if (root == null) {
            root = RandomTreeNode.builder()
                    .key(key)
                    .build();
            return;
        }
        RandomTreeNode newNode = insert(root, key);
        if (newNode != null)
            splay(newNode);
        nodesCount++;
    }

    public void splay(RandomTreeNode node) {
        if (isSplayRequired()) {
            while (node.getParent() != null)
                swapUp(node, node.getParent());
            root = node;
        }
    }

    private void swapUp(RandomTreeNode node, RandomTreeNode parent) {
        RandomTreeNode grandParent = parent.getParent();
        node.setParent(grandParent);
        if (grandParent != null) {
            if (grandParent.getRight() == parent)
                grandParent.setRight(node);
            else
                grandParent.setLeft(node);
        }
        //turn left
        if (parent.getKey() < node.getKey()) {
            if (node.getLeft() != null)
                node.getLeft().setParent(parent);
            parent.setRight(node.getLeft());
            node.setLeft(parent);
        }
        //turn right
        if (parent.getKey() > node.getKey()) {
            if (node.getRight() != null)
                node.getRight().setParent(parent);
            parent.setLeft(node.getRight());
            node.setRight(parent);
        }
        parent.setParent(node);
    }

    public boolean search(int key) {
        RandomTreeNode node = findNode(root, key);
        if (node != null) {
            splay(node);
            return true;
        }
        return false;
    }

    private RandomTreeNode findNode(RandomTreeNode node, int key) {
        if (node.getKey() == key) {
            return node;
        } else if (node.getKey() > key)
            return node.getLeft() == null ? null : findNode(node.getLeft(), key);
        else return node.getRight() == null ? null : findNode(node.getRight(), key);
    }

    public void remove(int key) {
        RandomTreeNode node = findNode(root, key);
        if (node == null)
            return;
        splay(node);
        RandomTreeNode newRoot;
        if (root.getLeft() != null) {
            newRoot = root.getLeft();
            while (newRoot.getRight() != null) {
                newRoot = newRoot.getRight();
            }
            if (newRoot != root.getLeft()) {
                newRoot.getParent().setRight(null);
                root.getLeft().setParent(newRoot);
                newRoot.setLeft(root.getLeft());
            }
            if (root.getRight() != null)
                root.getRight().setParent(newRoot);
            newRoot.setRight(root.getRight());
        } else if (root.getRight() != null) {
            newRoot = root.getRight();
        } else {
            newRoot = null;
        }
        if (newRoot != null)
            newRoot.setParent(null);
        root = newRoot;
        nodesCount--;
    }

    public int getSize() {
        return nodesCount;
    }

    private RandomTreeNode insert(RandomTreeNode node, int key) {
        RandomTreeNode newNode = null;
        if (key < node.getKey()) {
            if (node.getLeft() == null) {
                newNode = RandomTreeNode.builder()
                        .key(key)
                        .parent(node)
                        .build();
                node.setLeft(newNode);
            } else {
                newNode = insert(node.getLeft(), key);
            }
        }
        if (key > node.getKey()) {
            if (node.getRight() == null) {
                newNode = RandomTreeNode.builder()
                        .key(key)
                        .parent(node)
                        .build();
                node.setRight(newNode);
            } else {
                newNode = insert(node.getRight(), key);
            }
        }
        return newNode;
    }

    private boolean isSplayRequired() {
        return nodesCount > 99 || new Random().nextInt(100 / (nodesCount + 1)) == 0;
    }
}
