package dev.lochness.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrieTest {

    private Trie trie;

    @BeforeEach
    public void init() {
        trie = new Trie();
    }

    @Test
    void trieInsertAndSearchTest() {
        trie.insert("apple");
        boolean actual = trie.search("apple");
        Assertions.assertTrue(actual, "should find apple");
    }

    @Test
    void trieInsertAndSearchPartialTest() {
        trie.insert("apple");
        boolean actual = trie.search("app");
        Assertions.assertFalse(actual, "contains apple not app");
    }

    @Test
    void triePrefixSearch() {
        trie.insert("apple");
        boolean actual = trie.startsWith("app");
        Assertions.assertTrue(actual, "apple starts with app");
    }
}