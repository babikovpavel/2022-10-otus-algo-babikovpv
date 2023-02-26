package dev.lochness.graphs;

public class Trie {

    private static final int ALPHABET_LENGTH = 128;

    private final Node root = new Node();

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.getNext(word.charAt(i));
        }
        node.setIsEnd(true);
    }

    public boolean search(String word) {
        Node node = find(word);
        if (node == null) {
            return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.contains(c)) {
                node = node.getNext(word.charAt(i));
            } else {
                return null;
            }
        }
        return node;
    }

    private static class Node {
        private final Node[] child;
        private boolean isEnd;

        public Node() {
            child = new Node[ALPHABET_LENGTH];
            this.isEnd = false;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public Node getNext(char c) {
            if (!contains(c)) {
                child[c] = new Node();
            }
            return child[c];
        }

        public boolean contains(char c) {
            return child[c] != null;
        }
    }
}
