class Solution {
    public boolean judgeSquareSum(int c) {
        //performing two pointers
        long i=0;
        long j=(long)Math.sqrt(c);
        while(i<=j){
            long sum=(i*i)+(j*j);
            if(sum==(long)c){
                return true;
            }
            else if(sum<(long)c){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}