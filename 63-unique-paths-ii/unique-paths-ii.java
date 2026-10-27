class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //tabulation
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;//moving on after we reach a block
                }
                if(i==0&&j==0){
                    dp[i][j]=1;
                }
                else{
                
                dp[i][j]=((i>0)?dp[i-1][j]:0)+((j>0)?dp[i][j-1]:0);
                }
            }
        }
        return dp[m-1][n-1];

    }
}
    //     for(int []arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     return helper(m-1,n-1,obstacleGrid,dp);
    // }
    // public int helper(int i,int j,int[][]mat,int [][]dp){
    //     if(i>=0&&j>=0&&mat[i][j]==1){
    //         return 0;
    //     }
    //     if(i==0&&j==0){
    //         return 1;
    //     }
    //     if(i<0||j<0){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     return dp[i][j]=helper(i-1,j,mat,dp)+helper(i,j-1,mat,dp);
    // }
