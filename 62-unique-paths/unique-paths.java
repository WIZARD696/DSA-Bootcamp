class Solution {

    public int uniquePaths(int m,int n){
        int [][]dp=new int[m][n];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<n;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){ 
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    // public int uniquePaths(int m,int n){
    //     int [][]dp=new int[m+1][n+1];
    //     for(int []arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     return helper(m-1,n-1,dp);
    // }
    //Recursion approach but this will lead to TLE
    // public int helper(int i, int j) {
    //     if(i==0||j==0){
    //         return 1;
    //     }
    //     if(i<0||j<0){
    //         return 0;
    //     }
    //     return helper(i-1,j)+helper(i,j-1);
    // }
    //Memoization
    // public int helper(int i, int j,int [][]dp) {
    //     if(i==0||j==0){
    //         return 1;
    //     }
    //     if(i<0||j<0){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     return dp[i][j]=helper(i-1,j,dp)+helper(i,j-1,dp);
    // }
}