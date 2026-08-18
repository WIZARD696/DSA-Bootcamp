class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1=cost[0];
        int prev2=cost[1];
        int current=0;
        for(int i=2;i<cost.length;i++){
            current=cost[i]+Math.min(prev1,prev2);
            prev1=prev2;
            prev2=current;
        }
        return Math.min(prev1,prev2);
    }
}