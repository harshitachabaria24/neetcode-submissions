class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // If destination is blocked
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        // Destination
        dp[m - 1][n - 1] = 1;

        // Fill from bottom-right
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                // Skip destination
                if (i == m - 1 && j == n - 1)
                    continue;

                // ⭐ New Part
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                int right = 0;
                int down = 0;

                if (j + 1 < n)
                    right = dp[i][j + 1];

                if (i + 1 < m)
                    down = dp[i + 1][j];

                dp[i][j] = right + down;
            }
        }

        return dp[0][0];
    }
}