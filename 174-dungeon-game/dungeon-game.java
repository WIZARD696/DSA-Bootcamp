class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
     int m=dungeon.length;
     int n=dungeon[0].length;
     int [][]dp=new int [m][n];

     for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(i==m-1&&j==n-1){
                dp[i][j]=(dungeon[i][j])>0?1:Math.abs(dungeon[i][j])+1;
            }
            else{
                int right=(j+1>=n)?Integer.MAX_VALUE:dp[i][j+1];
                int down=(i+1>=m)?Integer.MAX_VALUE:dp[i+1][j];
                int temp=Math.min(right,down)-dungeon[i][j];
                dp[i][j]=temp>0?temp:1;
            }
        }
     }
     return dp[0][0];
    }
    
    //Memoization
    //     int m=dungeon.length;
    //     int n=dungeon[0].length;
    //     int [][]dp=new int[m][n];
    //     for(int []arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     return helper(0,0,dungeon,m,n,dp);
    // }
    // public int helper(int i,int j,int[][]dungeon,int m,int n,int [][]dp){
    //     if(i>=m||j>=n){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(i==m-1&&j==n-1){
    //         if(dungeon[i][j]>0){
    //             return 1;
    //         }
    //         else{
    //             return Math.abs(dungeon[i][j])+1;
    //         }
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     int right=helper(i,j+1,dungeon,m,n,dp);
    //     int down=helper(i+1,j,dungeon,m,n,dp);

    //     int min=Math.min(right,down);
    //     int temp=min-dungeon[i][j];
    //     return dp[i][j]=temp<=0?1:temp;
    // }
}