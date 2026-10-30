class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        int [][]dp=new int[m+1][n+1];//remember 1 based indexing
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=1;j<=n;j++){//isse pattern uthaliya
            boolean flag=true;
            for(int k=1;k<=j;k++){//iise pattern ke characters utha liye
                if(p.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }
            }
            if(flag){
                dp[0][j]=1;
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){//java Strings follow 1-based indexing
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]|dp[i][j-1];
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[m][n]==1;

        
        // for(int []arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        // return helper(s.length()-1,p.length()-1,s,p,dp)==1;
    }

    // public int helper(int i,int j,String s,String p,int [][]dp){
    //     if(i<0&&j<0){
    //         return 1;
    //     }
    //     if(i>=0&&j<0){
    //         return 0;
    //     }
    //     if(i<0&&j>=0){
    //         for(int k=0;k<j;k++){
    //             if(p.charAt(k)!='*'){
    //                 return 0;
    //             }
    //         }
    //         return 1;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
    //         return dp[i][j]=helper(i-1,j-1,s,p,dp);
    //     }
    //     else if(p.charAt(j)=='*'){
    //         return dp[i][j]=helper(i-1,j,s,p,dp)|helper(i,j-1,s,p,dp);
    //     }
    //     else{
    //         return 0;
    //     }
    // }
}