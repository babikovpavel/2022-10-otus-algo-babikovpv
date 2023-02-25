package dev.lochness.graphs;

import static dev.lochness.graphs.Printer.printArray;
import static dev.lochness.graphs.Printer.printMatrix;

public class Demukron {

    private static final Integer[][] GRAPH = {
            {1, null, null, null},
            {4, null, null, null},
            {3, null, null, null},
            {0, 1, 4, 5},
            {6, null, null, null},
            {4, 7, null, null},
            {7, null, null, null},
            {null, null, null, null}
    };

    public static void main(String[] args) {
        printMatrix("Source graph: ", GRAPH);

        //составляем матрицу смежности
        Integer[][] adjacencyMatrix = buildAdjacencyMatrix(GRAPH);
        printMatrix("Adjancency matrix: ", adjacencyMatrix);

        //считаем степень вхождений
        Integer[] inputDegree = calcInputDegree(adjacencyMatrix);
        printArray("Input degree: ", inputDegree);

        int level = 0;
        var levels = new Integer[GRAPH.length][GRAPH.length];
        Integer[] nextLevel;
        while (true) {
            //находим вершины с нулевой полустепенью входа
            nextLevel = getZeroDegrees(inputDegree);
            //если вершины не найдены - выходим из цикла
            if (nextLevel[0] == null) {
                break;
            }
            levels[level++] = nextLevel;
            printArray(String.format("New level %d:", level), nextLevel);
            for (Integer row : nextLevel) {
                if (row == null) {
                    break;
                }
                //вычитаем из массива степеней вхождений соответствующий ряд матрицы смежности
                levelSubtract(inputDegree, adjacencyMatrix[row], row);
            }
        }
        printMatrix("Levels: ", levels);
    }

    private static void levelSubtract(Integer[] inputDegree,
                                      Integer[] matrixRow,
                                      Integer rowNum) {
        inputDegree[rowNum] = null;
        for (int i = 0; i < matrixRow.length; i++) {
            var value = matrixRow[i];
            if (value != null) {
                inputDegree[i] = inputDegree[i] - value;
            }
        }
    }

    private static Integer[] getZeroDegrees(Integer[] inputDegree) {
        var zeroDegreeVertexes = new Integer[inputDegree.length];
        int j = 0;
        for (int i = 0; i < inputDegree.length; i++) {
            var value = inputDegree[i];
            if (value != null && value == 0) {
                zeroDegreeVertexes[j++] = i;
            }
        }
        return zeroDegreeVertexes;
    }

    private static Integer[] calcInputDegree(Integer[][] adjacencyMatrix) {
        var inputDegree = new Integer[adjacencyMatrix.length];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                var value = adjacencyMatrix[j][i];
                if (value != null) {
                    sum += value;
                }
            }
            inputDegree[i] = sum;
        }
        return inputDegree;
    }

    private static Integer[][] buildAdjacencyMatrix(Integer[][] source) {
        var matrix = new Integer[source.length][source.length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                var value = source[i][j];
                if (value != null) {
                    increase(matrix, i, value);
                }
            }
        }
        return matrix;
    }

    private static void increase(Integer[][] arr, int row, int column) {
        var value = arr[row][column];
        if (value == null) {
            arr[row][column] = 1;
        } else {
            arr[row][column] = value + 1;
        }
    }

}
