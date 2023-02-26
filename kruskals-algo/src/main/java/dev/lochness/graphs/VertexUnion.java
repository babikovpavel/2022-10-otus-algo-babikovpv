package dev.lochness.graphs;

import java.util.Objects;

public class VertexUnion {

    private final Integer[] parent;

    public VertexUnion(int size) {
        this.parent = new Integer[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public Integer findRoot(Integer child) {
        if (Objects.equals(parent[child], child)) {
            return child;
        }
        parent[child] = findRoot(parent[child]);
        return parent[child];
    }

    public void union(Integer v1, Integer v2) {
        var rootV1 = findRoot(v1);
        var rootV2 = findRoot(v2);
        if (!Objects.equals(rootV1, rootV2)) {
            parent[rootV1] = rootV2;
        }
    }
}
