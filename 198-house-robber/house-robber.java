class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n-1,nums,dp);
    }
    public int helper(int n,int []nums,int []dp){
        if(n==0){
            return nums[0];
        }
        if(n==1){
            return Math.max(nums[0],nums[1]);
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int pick=nums[n]+helper(n-2,nums,dp);
        int np=0+helper(n-1,nums,dp);
        return dp[n]=Math.max(pick,np);
    }
}