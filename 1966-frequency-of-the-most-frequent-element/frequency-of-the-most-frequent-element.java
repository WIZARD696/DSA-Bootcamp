class Solution {
    public int maxFrequency(int[] nums, int k) {
        //sliding window
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int maxF=1;
        long sum=0;
        while(j<nums.length){
            sum+=nums[j];
            long cost=(long)nums[j]*(j-i+1)-sum;
            //invalid window
            while(cost>k){
                //shrinking window
                sum-=nums[i];
                i++;
                cost=(long)nums[j]*(j-i+1)-sum;
            }
            maxF=Math.max(maxF,j-i+1);
            //expanding window
            j++;
        }
        return maxF;

    }
}