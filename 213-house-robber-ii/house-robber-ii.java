class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int []dp1=new int[n+1];
        int []dp2=new int[n+1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int [] temp1=new int[n-1];//dynamic arrays
        int [] temp2=new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0){
                temp1[i-1]=nums[i];
            }
            if(i!=n-1){
                temp2[i]=nums[i];
            }
        }
        return Math.max(helper(n-2,temp1,dp1),helper(n-2,temp2,dp2));
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