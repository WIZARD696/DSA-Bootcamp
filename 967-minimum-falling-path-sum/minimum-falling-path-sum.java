class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int u = Integer.MAX_VALUE;
                int l = Integer.MAX_VALUE;
                int r = Integer.MAX_VALUE;
                u = matrix[i][j] + dp[i - 1][j];
                if (j > 0) {
                    l = matrix[i][j] + dp[i - 1][j - 1];
                }
                if (j < matrix[0].length - 1) {
                    r = matrix[i][j] + dp[i - 1][j + 1];
                }

                dp[i][j] = Math.min(r, Math.min(u, l));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m - 1][j]);
        }
        return min;
    }
    //Memoization
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int ans = Integer.MAX_VALUE;
    //     int[][]dp=new int [m][n];
    //     for(int []arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     for (int j = 0; j < n; j++) {
    //         ans = Math.min(ans, helper(m - 1, j, matrix,dp));
    //     }
    //     return ans;
    // }

    // public int helper(int i, int j, int[][] matrix,int [][]dp) {
    //     if (j < 0 || j > matrix[0].length - 1) {
    //         return Integer.MAX_VALUE;
    //     }
    //     if (i == 0) {
    //         return matrix[i][j];
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int u=Integer.MAX_VALUE;
    //     int l=Integer.MAX_VALUE;
    //     int r=Integer.MAX_VALUE;
    //     if (i > 0) {
    //          u = matrix[i][j] + helper(i - 1, j, matrix,dp);
    //         if (j > 0) {
    //              l = matrix[i][j] + helper(i - 1, j - 1, matrix,dp);
    //         }
    //         if (j < matrix[0].length - 1) {
    //              r = matrix[i][j] + helper(i - 1, j + 1, matrix,dp);
    //         }
    //     }

    //     return dp[i][j]=Math.min(r, Math.min(u, l));

    // }
}