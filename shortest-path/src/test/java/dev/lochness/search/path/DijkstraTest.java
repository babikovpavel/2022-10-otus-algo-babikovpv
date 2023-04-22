package dev.lochness.search.path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DijkstraTest {

    private Dijkstra dijkstra;

    private static final Integer[][] GRAPH = {
            {1, 2, 2, 3, 3, 6},
            {0, 2, 2, 4, 4, 9},
            {0, 3, 1, 4, 3, 1, 4, 7, 5, 6},
            {0, 6, 2, 1, 5, 4},
            {1, 9, 2, 7, 5, 1, 6, 5},
            {2, 6, 3, 4, 4, 1, 6, 8},
            {4, 5, 5, 8}
    };

    @BeforeEach
    void setUp() {
        dijkstra = new Dijkstra();
    }

    @Test
    void calcWeight() {
        Edge[] expected = {
                new Edge(6, 0, 14),
                new Edge(6, 1, 14),
                new Edge(6, 2, 11),
                new Edge(6, 3, 10),
                new Edge(6, 4, 5),
                new Edge(6, 5, 6),
                new Edge(6, 6, 0)
        };
        Edge[] actual = dijkstra.calcWeight(GRAPH, 6);
        assertArrayEquals(expected, actual);
    }
}