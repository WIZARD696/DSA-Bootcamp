class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                max=getMax(heights,stack,max,i);
            }
            stack.push(i);
        }

        int i=heights.length;
        while(!stack.isEmpty()){
            max=getMax(heights,stack,max,i);
        }
        return max;
    }

    public int getMax(int[] heights,Stack<Integer> stack,int max,int i){
        int area=0;
        int popped=stack.pop();
        if(stack.isEmpty()){
            area=heights[popped]*i;
        }
        else{
            area=heights[popped]*(i-1-stack.peek()) ;
        }
        return Math.max(max,area);
    }

}