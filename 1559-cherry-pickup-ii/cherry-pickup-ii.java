// class Solution {
//     public int cherryPickup(int[][] grid) {
//         return helper(0,0,grid[0].length-1,grid.length,grid[0].length,grid);
//     }

//     public int helper(int i,int j1,int j2,int r,int c,int [][]grid){
//         if(j1<0||j2<0||j1>c-1||j2>c-1){
//             return Integer.MIN_VALUE;
//         }
//         //suppose we reach a destination then
//         if(i==r-1){
//             if(j1==j2) return grid[i][j1];
//             else return grid[i][j1]+grid[i][j2];
//         }
//         //now let us find the rest of the cases
//         int maxi=Integer.MIN_VALUE;
//         for(int dj1=-1;dj1<=+1;dj1++){
//             for(int dj2=-1;dj2<=+1;dj2++){
//                 int value=0;
//                 if(j1==j2) value=grid[i][j1];
//                 else value=grid[i][j1]+grid[i][j2];
//                 value+=helper(i+1,j1+dj1,j2+dj2,r,c,grid);
//                 maxi=Math.max(maxi,value);
//             }
//         }
//         return maxi;
//     }
// }

//Now as we know we will get TLE with the recursive solution due to overlapping subproblems
//Therefore below is the memoization Approach
// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
//         for (int[][] arr : dp) {
//             for (int[] arr1 : arr) {
//                 Arrays.fill(arr1, -1);
//             }
//         }
//         return helper(0, 0, grid[0].length - 1, grid.length, grid[0].length, grid, dp);
//     }

//     public int helper(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
//         if (j1 < 0 || j2 < 0 || j1 > c - 1 || j2 > c - 1) {
//             return Integer.MIN_VALUE;
//         }
//         if (dp[i][j1][j2] != -1) {
//             return dp[i][j1][j2];
//         }
//         //suppose we reach a destination then
//         if (i == r - 1) {
//             if (j1 == j2)
//                 return grid[i][j1];
//             else
//                 return grid[i][j1] + grid[i][j2];
//         }
//         //now let us find the rest of the cases
//         int maxi = Integer.MIN_VALUE;
//         for (int dj1 = -1; dj1 <= +1; dj1++) {
//             for (int dj2 = -1; dj2 <= +1; dj2++) {
//                 int value = 0;
//                 if (j1 == j2)
//                     value = grid[i][j1];
//                 else
//                     value = grid[i][j1] + grid[i][j2];
//                 value += helper(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
//                 maxi = Math.max(maxi, value);
//             }
//         }
//         return dp[i][j1][j2] = maxi;
//     }
//Tabulation method
// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
//         for (int j1 = 0; j1 < grid[0].length; j1++) {
//             for (int j2 = 0; j2 < grid[0].length; j2++) {
//                 if (j1 == j2)
//                     dp[grid.length - 1][j1][j2] = grid[grid.length - 1][j1];
//                 else
//                     dp[grid.length - 1][j1][j2] = grid[grid.length - 1][j1] + grid[grid.length - 1][j2];
//             }
//         }
//         for (int i = grid.length - 2; i >= 0; i--) {
//             for (int j1 = 0; j1 < grid[0].length; j1++) {
//                 for (int j2 = 0; j2 < grid[0].length; j2++) {
//                     int maxi = Integer.MIN_VALUE;
//                     for (int dj1 = -1; dj1 <= +1; dj1++) {
//                         for (int dj2 = -1; dj2 <= +1; dj2++) {
//                             int value = 0;
//                             if (j1 == j2)
//                                 value = grid[i][j1];
//                             else
//                                 value = grid[i][j1] + grid[i][j2];

//                             if (j1 + dj1 >= 0 && j2 + dj2 >= 0 && j1 + dj1 < grid[0].length
//                                     && j2 + dj2 < grid[0].length) {
//                                 value += dp[i + 1][j1 + dj1][j2 + dj2];
//                             }
//                             maxi = Math.max(maxi, value);
//                         }
//                     }
//                     dp[i][j1][j2]=maxi;
//                 }
//             }
//         }
//         return dp[0][0][grid[0].length - 1];
//     }
// }

//Space-Optimisation Technique
class Solution {
    public int cherryPickup(int[][] grid) {
        int[][] front = new int[grid[0].length][grid[0].length];//this is for the j1 j2 variables 
        for (int j1 = 0; j1 < grid[0].length; j1++) {
            for (int j2 = 0; j2 < grid[0].length; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[grid.length - 1][j1];
                else
                    front[j1][j2] = grid[grid.length - 1][j1] + grid[grid.length - 1][j2];
            }
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            int[][] curr = new int[grid[0].length][grid[0].length];
            for (int j1 = 0; j1 < grid[0].length; j1++) {
                for (int j2 = 0; j2 < grid[0].length; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= +1; dj1++) {
                        for (int dj2 = -1; dj2 <= +1; dj2++) {
                            int value = 0;
                            if (j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];

                            if (j1 + dj1 >= 0 && j2 + dj2 >= 0 && j1 + dj1 < grid[0].length
                                    && j2 + dj2 < grid[0].length) {
                                value += front[j1 + dj1][j2 + dj2];
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            front = curr;
        }
        return front[0][grid[0].length - 1];
    }
}