class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> first=new Stack<>();
        Stack<Character> second=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='#'){
                if(first.isEmpty()){
                    continue;
                }
                else{
                    first.pop();
                }
            }
            else{
                first.push(ch);
            }
        }
        for(char ch:t.toCharArray()){
            if(ch=='#'){
                if(second.isEmpty()){
                    continue;
                }
                else{
                    second.pop();
                }
            }
            else{
                second.push(ch);
            }
        }
        while(!first.isEmpty()&&!second.isEmpty()){
            if(first.pop()!=second.pop()){
                return false;
            }
        }
        return first.isEmpty()&&second.isEmpty();
    }
}