package dev.lochness.btree;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SplayTreeNode {

    private int key;
    private SplayTreeNode parent;
    private SplayTreeNode left;
    private SplayTreeNode right;
}