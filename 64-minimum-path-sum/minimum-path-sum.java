class Solution {
    public int minPathSum(int[][] grid) {
        //Space Optimization Approach
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int []curr=new int [n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j]= grid[0][0];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0){
                 up=grid[i][j]+prev[j];
                }
                if (j > 0) {
                    left = grid[i][j] + curr[j - 1];
                }
                curr[j] = Math.min(up, left);
            }
            prev=curr;
        }
        return prev[n - 1];
    }

    //Memoization DP approach
    // public int minPathSum(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][] dp=new int [m][n];
    //     for(int []arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     return helper(m - 1, n - 1, grid,dp);
    // }

    // public int helper(int i, int j, int[][] grid,int [][]dp) {
    //     if (i == 0 && j == 0) {
    //         return grid[0][0];
    //     }
    //     if (i < 0 || j < 0) {
    //         return Integer.MAX_VALUE;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int up=Integer.MAX_VALUE;
    //     int left=Integer.MAX_VALUE;
    //     if (i > 0) {
    //          up = grid[i][j] + helper(i - 1, j, grid,dp);
    //     }
    //     if (j > 0) {
    //          left = grid[i][j] + helper(i, j - 1, grid,dp);
    //     }

    //     return dp[i][j]=Math.min(up, left);
    // }
}