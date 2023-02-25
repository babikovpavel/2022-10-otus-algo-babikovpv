package dev.lochness.graphs;

import static dev.lochness.graphs.ArrayUtils.*;
import static dev.lochness.graphs.Printer.printArray;
import static dev.lochness.graphs.Printer.printMatrix;

public class Kosaraju {

    private static final Integer[][] GRAPH = {
            {1, null, null},
            {2, 4, 5},
            {3, 6, null},
            {2, 7, null},
            {0, 5, null},
            {6, null, null},
            {5, null, null},
            {3, 6, null}
    };

    public static void main(String[] args) {
        printMatrix("Source graph: ", GRAPH);

        //инвертируем дуги графа
        var inverted = invertArcs(GRAPH);
        printMatrix("Inverted graph: ", inverted);

        //осуществляем поиск в глубину
        var visited = new Integer[GRAPH.length];
        var complete = new Integer[GRAPH.length];
        for (int i = 0; i < inverted.length; i++) {
            if (!contains(complete, i)) {
                dfs(inverted, i, visited, complete);
            }
        }
        printArray("DFS1: ", complete);

        //инвертируем полученный результат
        complete = invert(complete);
        printArray("Inverted dfs result: ", complete);

        //осуществляем поиск в глубину по исходному массиву в заданном порядке
        visited = new Integer[GRAPH.length];
        for (Integer next : complete) {
            Integer[] coupled = new Integer[GRAPH.length];
            if (!contains(visited, next)) {
                dfs(GRAPH, next, visited, coupled);
                printArray("Found coupled components: ", coupled);
            }
        }
    }

    private static Integer[][] invertArcs(Integer[][] source) {
        Integer[][] inverted = new Integer[source.length][source[0].length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                Integer value = source[i][j];
                if (value == null) {
                    break;
                }
                add(inverted[value], i);
            }
        }
        return inverted;
    }

    private static void dfs(Integer[][] graph, int vertex, Integer[] visited, Integer[] complete) {
        System.out.println("Mark visited: " + vertex);
        add(visited, vertex);
        for (int i = 0; i < graph[vertex].length; i++) {
            Integer next = graph[vertex][i];
            if (next != null && !contains(visited, next)) {
                dfs(graph, next, visited, complete);
            }
        }
        System.out.println("Mark complete: " + vertex);
        add(complete, vertex);
    }

}
