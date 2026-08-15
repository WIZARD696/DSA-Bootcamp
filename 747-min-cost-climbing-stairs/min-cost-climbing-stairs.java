class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1=cost[1];
        int prev2=cost[0];
        int current=0;
        for(int i=2;i<cost.length;i++){
            current=cost[i]+Math.min(prev1,prev2);
            prev2=prev1;
            prev1=current;
        }
        return Math.min(prev1,prev2);//at this point wee are at n-1 steps and n-2 steps so we find the minimum
    }
}