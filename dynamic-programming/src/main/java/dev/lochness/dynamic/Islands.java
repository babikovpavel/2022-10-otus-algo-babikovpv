package dev.lochness.dynamic;

// задача "Острова"
public class Islands {

    public int solve(int[][] map) {
        int islandsCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    islandsCount++;
                    floodIsland(i, j, map);
                }
            }
        }
        return islandsCount;
    }

    private void floodIsland(int i, int j, int[][] map) {
        if (i < 0 || j < 0 || i >= map.length || j >= map[i].length) {
            return;
        }
        if (map[i][j] == 1) {
            map[i][j] = 0;
            floodIsland(i - 1, j, map);
            floodIsland(i + 1, j, map);
            floodIsland(i, j - 1, map);
            floodIsland(i, j + 1, map);
        }
    }
}
