package dev.lochness.btree;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RandomTreeNode {

    private int key;
    private RandomTreeNode parent;
    private RandomTreeNode left;
    private RandomTreeNode right;
}
