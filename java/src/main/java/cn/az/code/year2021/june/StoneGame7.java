package cn.az.code.year2021.june;

/**
 * @author az
 * @since 2021-06-11
 */
public class StoneGame7 {

    int[] preSum;
    Integer[][][] memo;

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        preSum = new int[n + 1];
        memo = new Integer[n][n][2];
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + stones[i];
        return dp(0, n - 1, 1);
    }

    int getSum(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    int dp(int left, int right, int isAlice) {
        if (left > right)
            return 0;
        if (memo[left][right][isAlice] != null)
            return memo[left][right][isAlice];
        if (isAlice == 1) {
            int a = dp(left + 1, right, 1 - isAlice) + getSum(left + 1, right); // Take leftmost
            int b = dp(left, right - 1, 1 - isAlice) + getSum(left, right - 1); // Take rightmost
            return memo[left][right][isAlice] = Math.max(a, b);
        } else {
            int a = dp(left + 1, right, 1 - isAlice) - getSum(left + 1, right); // Take leftmost
            int b = dp(left, right - 1, 1 - isAlice) - getSum(left, right - 1); // Take rightmost
            return memo[left][right][isAlice] = Math.min(a, b);
        }
    }
}
