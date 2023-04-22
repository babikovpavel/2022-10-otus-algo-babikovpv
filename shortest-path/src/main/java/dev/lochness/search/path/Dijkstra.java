package dev.lochness.search.path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {

    //на выход получаем минимальную стоимость до каждой вершины из стартовой
    public Edge[] calcWeight(Integer[][] graph, int startVertex) {

        Edge[] edges = parseEdges(graph);

        int[] weights = new int[graph.length];
        int[] visited = new int[graph.length];
        Arrays.fill(weights, -1);
        Arrays.fill(visited, 0);

        //из вершины в нее же мы попадем за 0
        weights[startVertex] = 0;

        //фильтруем ребра смежные выбранной вершине
        var adjancentEdges = filterAdjancentToVertexEdges(startVertex, edges, visited);

        //сохраняем стоимость смежных стартовой вершине вершин
        for (Edge edge : adjancentEdges) {
            weights[edge.getV2()] = edge.getCost();
        }

        //помечаем стартовую вершину как посещенную
        visited[startVertex] = 1;

        var lowestPriceVertex = findLowestPriceVertex(weights, visited);
        while (lowestPriceVertex != -1) {
            //найти смежные вершины (не посещенные)
            adjancentEdges = filterAdjancentToVertexEdges(lowestPriceVertex, edges, visited);
            //обновить вес для всех смежных вершин, если путь короче
            for (Edge edge : adjancentEdges) {
                int newWeight = weights[lowestPriceVertex] + edge.getCost();
                if (weights[edge.getV2()] == -1 || newWeight < weights[edge.getV2()])
                    weights[edge.getV2()] = newWeight;
            }
            visited[lowestPriceVertex] = 1;
            lowestPriceVertex = findLowestPriceVertex(weights, visited);
        }

        //заполняем итоговый массив весов
        var result = new Edge[graph.length];
        for (int i = 0; i < weights.length; i++) {
            result[i] = new Edge(startVertex, i, weights[i]);
        }
        return result;
    }

    private static int findLowestPriceVertex(int[] weights, int[] visited) {
        int minVertex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] >= 0 && weights[i] < min && visited[i] == 0) {
                min = weights[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

    private static List<Edge> filterAdjancentToVertexEdges(int vertex, Edge[] edges, int[] visited) {
        List<Edge> adjancentEdges = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getV1() == vertex && visited[edge.getV2()] == 0) {
                adjancentEdges.add(edge);
            }
        }
        return adjancentEdges;
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
