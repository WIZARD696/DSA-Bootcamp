class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean [] exist=new boolean[101];//this is the array for the multiples existence 
        for(int num:nums){
            exist[num]=true;//this makes the elements present in the array true in the existence array 
        }
        int num=k;
        while(num<101){//check the constraints
            if(!exist[num]){
                return num;
            }
            num+=k;//this will increment it and check for further multiples
        }
        return num;
    }
}