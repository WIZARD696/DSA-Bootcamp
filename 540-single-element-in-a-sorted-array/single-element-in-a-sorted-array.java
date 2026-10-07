class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(mid%2==1){
                mid--;//this makes sure that we are always at the first position of the pair
            }
            //for the even index either
            if(nums[mid]==nums[mid+1]){
                //meaning the pairing is right we move to the right;
                low=mid+2;//mid and mid+1 are both valid pairs so simply discard them
            }
            else{//if the pairing is not right we move left meaning ya to mid hi single element h ya fir left me h 
                high=mid;//mid could also be the answer
            }
        }
        return nums[low];
    }
}