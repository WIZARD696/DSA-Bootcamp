class Solution {
    public boolean canJump(int[] nums) {
        int reachable=0;
        for(int i=0;i<nums.length;i++){
            if(reachable<i){
                return false;
            }
            else{
                reachable=Math.max(reachable,i+nums[i]);//i+nums[i]-->will provide us with the index at which we are going to jump next(the maximum one)
            }
        }
        return true;
    }
}