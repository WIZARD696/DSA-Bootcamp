class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty()){
                if(ch=='*'){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
            else{
                stack.push(ch);
            }
        }
        //this lets us get the original string not the reverse string from stack
        StringBuilder sb=new StringBuilder();
        for(char ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}