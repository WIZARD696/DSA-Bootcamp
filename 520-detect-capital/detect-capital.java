class Solution {
    public boolean detectCapitalUse(String word) {
        //we first initialise an uppercase variable
        int uppercase=0;
        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))){
                uppercase++;
            }
        }
        if(uppercase==0){
            return true;
        }
        if(uppercase==1&&Character.isUpperCase(word.charAt(0))){
            return true;
        }
        if(uppercase==word.length()){
            return true;
        }
        return false;
    }
}