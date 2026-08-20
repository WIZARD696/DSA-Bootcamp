class Solution {
    public void rotate(int[] nums, int k) {
            int n=nums.length;
            reverse(nums,0,n-1);
            k=k%n;
            reverse(nums,0,k-1);
            reverse(nums,k,n-1);
        }
        public void reverse(int []nums,int s,int e){
            while(s<=e){
                //swap
                int temp=nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }
        }
    }