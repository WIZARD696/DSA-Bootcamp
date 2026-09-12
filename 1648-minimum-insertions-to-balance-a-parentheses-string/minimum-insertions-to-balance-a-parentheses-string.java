class Solution {
    public int minInsertions(String s) {
        int open=0;
        int insertions=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                open++;
            }
            else if(ch==')'&&i+1<s.length()&&s.charAt(i+1)==')'){
                if(open>0){
                    open--;
                }
                else{
                    insertions+=1;
                }
                i++;
            }
            else{
                if(open>0){
                    open--;
                    insertions+=1;
                }
                else{
                    insertions+=2;
                }
            }
        }
        return insertions+open*2;
    }
}