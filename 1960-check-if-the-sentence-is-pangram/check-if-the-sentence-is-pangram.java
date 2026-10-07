class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] result= new boolean[26];
        for(char c:sentence.toCharArray()){
            result[c-'a']=true;
        }
        for(boolean b:result){
            if(!b){
                return false;
            }
        }
        return true;
    }
}