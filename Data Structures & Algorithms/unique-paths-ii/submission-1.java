
class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, obstacleGrid, dp);
    }

    public int solve(int i, int j, int[][] grid, int[][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        // Outside Grid
        if (i >= m || j >= n)
            return 0;

        // NEW BASE CASE
        if (grid[i][j] == 1)
            return 0;

        // Destination
        if (i == m - 1 && j == n - 1)
            return 1;

        // Already Solved
        if (dp[i][j] != -1)
            return dp[i][j];

        int right = solve(i, j + 1, grid, dp);

        int down = solve(i + 1, j, grid, dp);

        dp[i][j] = right + down;

        return dp[i][j];
    }
}