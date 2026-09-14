class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(String ch:operations){
            if(ch.equals("C")){//''-->single quotes represent a Character in java and " "--> represents a String in java 
                stack.pop();
            }
            else if(ch.equals("D")){
                stack.push(2*stack.peek());
            }
            else if(ch.equals("+")){
                stack.push(stack.peek()+stack.get(stack.size()-2));//second last element
            }
            else{
                stack.push(Integer.parseInt(ch));
            }
        }
        int total=0;
        while(!stack.isEmpty()){
            total+=stack.pop();
        }
        return total;
    }
}