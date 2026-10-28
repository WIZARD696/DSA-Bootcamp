class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int j = 0; j < triangle.size(); j++) {
            dp[triangle.size() - 1][j] = triangle.get(triangle.size() - 1).get(j);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int d = triangle.get(i).get(j) + dp[i + 1][j];
                int dg = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(d, dg);
            }
        }
        return dp[0][0];
        //memoization Approach
        // for (int[] arr : dp) {
        //     Arrays.fill(arr, -1);
        // }
        // return helper(0, 0, triangle, dp);
    }

    // public int helper(int i, int j, List<List<Integer>> triangle, int[][] dp) {
    //     if (i == triangle.size() - 1) {
    //         return triangle.get(i).get(j);
    //     }
    //     if (dp[i][j] != -1) {
    //         return dp[i][j];
    //     }

    //     int d = triangle.get(i).get(j) + helper(i + 1, j, triangle, dp);
    //     int dg = triangle.get(i).get(j) + helper(i + 1, j + 1, triangle, dp);
    //     return dp[i][j] = Math.min(d, dg);
    // }
}