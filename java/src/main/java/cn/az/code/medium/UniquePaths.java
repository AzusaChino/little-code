package cn.az.code.medium;

/**
 * 63. Unique Paths II
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 *
 * @author Liz
 * @date 1/9/2020
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        int[][] ints = new int[5][6];
        ints[2][3] = 1;
        System.out.println(u.uniquePathsWithObstacles2(ints));
    }

    public int uniquePathsWithObstacles2(int[][] grid) {
        int width = grid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : grid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }

    /**
     * Idea: grid[i][j] has to be set to zero if obstacleGrid[i][j] == 1, otherwise, we can get
     * dp[i][j] from its top and left dp.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < height; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < width; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int paths = 0;
                    if (obstacleGrid[i - 1][j] == 0) {
                        paths += dp[i - 1][j];
                    }
                    if (obstacleGrid[i][j - 1] == 0) {
                        paths += dp[i][j - 1];
                    }
                    dp[i][j] = paths;
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}
