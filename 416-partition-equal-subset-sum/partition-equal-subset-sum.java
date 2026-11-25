class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        if(nums.length==0) return true;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        return helper(nums,sum/2);
    }

    public boolean helper(int []arr,int target){
        boolean []curr=new boolean [target+1];
        curr[0]=true;
        if(arr[0]<=target){
            curr[arr[0]]=true;
        }
        for(int ind=1;ind<arr.length;ind++){
            boolean []prev=new boolean [target+1];
            prev[0]=true;
            for(int sum=1;sum<=target;sum++){
                boolean notTake=curr[sum];
                boolean take=false;
                if(arr[ind]<=sum){
                    take=curr[sum-arr[ind]];
                }
                prev[sum]=take||notTake;
            }
            curr=prev;
        }
        return curr[target];
    }
}