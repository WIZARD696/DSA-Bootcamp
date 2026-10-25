class Solution {
    //to solve with memoization we have to change it enormously!!
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(s, p, s.length() - 1, p.length() - 1, dp)==1;
    }

    public int helper(String s, String p,int i,int j,int [][]dp){
        if(i<0&&j<0){//if both of the strings are exhausted we simply return true
            return 1;
        }
        if(i>=0&&j<0){//if our pattern is empty then we have to return false
            return 0;
        }
        if(i<0&&j>=0){//if the first string is empty then we have to check if the pattern only has * in it as it can represent empty string anything else and we return false
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*'){
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
            return dp[i][j]=helper(s,p,i-1,j-1,dp);
        }
        else if(p.charAt(j)=='*'){
            return dp[i][j]=helper(s,p,i,j-1,dp)|helper(s,p,i-1,j,dp);
        }
        return dp[i][j]=0;//this is for the case when simply the character don't match
    }
}