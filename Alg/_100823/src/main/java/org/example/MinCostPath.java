package org.example;

public class MinCostPath {
    public int minPathCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];

        // Заполняем первую строку
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Заполняем первый столбец
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Заполняем остальные клетки
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1]; // Минимальная стоимость пути до правого нижнего угла
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        MinCostPath solver = new MinCostPath();
        int minCost = solver.minPathCost(grid);
        System.out.println("Минимальная стоимость пути: " + minCost);
    }
}
