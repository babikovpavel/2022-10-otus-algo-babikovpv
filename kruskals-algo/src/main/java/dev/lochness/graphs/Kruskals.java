package dev.lochness.graphs;

import java.util.Arrays;
import java.util.Objects;

import static dev.lochness.graphs.Printer.printArray;
import static dev.lochness.graphs.Printer.printMatrix;

public class Kruskals {

    //каждые 2 элемента обозначают смежную вершину и вес ребра
    private static final Integer[][] GRAPH = {
            {1, 9, 8, 3, 3, 10},
            {0, 9, 2, 4, 8, 16, 4, 8},
            {1, 4, 4, 14, 5, 1},
            {0, 10, 6, 13, 7, 5, 8, 11, 4, 7},
            {1, 8, 2, 14, 5, 12, 6, 15, 3, 7},
            {2, 1, 4, 12, 6, 2},
            {5, 2, 4, 15, 3, 13, 7, 6},
            {6, 6, 3, 5},
            {0, 3, 1, 16, 3, 11}
    };

    public static void main(String[] args) {
        printMatrix("Source graph: ", GRAPH);

        //получаем массив ребер из исходного вектора смежности и сортируем по стоимости
        var sourceEdges = parseEdges(GRAPH);
        Arrays.sort(sourceEdges);
        printArray("Source graph edges: ", sourceEdges);

        var vertexUnion = new VertexUnion(GRAPH.length);

        //проходимся по ребрам и проверяем можем ли мы добавить его
        int finalEdgesCount = 0;
        var finalEdges = new Edge[GRAPH.length - 1];
        for (int i = 0; i < sourceEdges.length; i++) {
            //если уже добавили необходимое кол-во ребер - выходим из цикла
            if (finalEdgesCount == GRAPH.length - 1) {
                break;
            }
            var edge = sourceEdges[i];
            var rootV1 = vertexUnion.findRoot(edge.getV1());
            var rootV2 = vertexUnion.findRoot(edge.getV2());
            //если нет цикла, вершины не принадлежат одному множеству
            if (!Objects.equals(rootV1, rootV2)) {
                vertexUnion.union(rootV1, rootV2);
                finalEdges[finalEdgesCount++] = edge;
            }
        }

        //возвращаем массив ребер минимального остовного дерева
        printArray("Final minimal tree edges: ", finalEdges);
    }

    private static Edge[] parseEdges(Integer[][] graph) {
        var edgesCount = getEdgesCount(graph);
        var edges = new Edge[edgesCount];
        var idx = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j = j + 2) {
                var v2 = graph[i][j];
                if (v2 == null) {
                    break;
                }
                var cost = graph[i][j + 1];
                edges[idx++] = new Edge(i, v2, cost);
            }
        }
        return edges;
    }

    private static int getEdgesCount(Integer[][] graph) {
        int edgesCount = 0;
        for (int i = 0; i < graph.length; i++) {
            edgesCount += graph[i].length;
        }
        return edgesCount / 2;
    }

}
