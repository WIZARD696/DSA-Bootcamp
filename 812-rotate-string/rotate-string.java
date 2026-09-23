class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String doubled = s + s;

        return doubled.contains(goal);//simple and easy approach

        //this was my bruteforce thinking but it had a linear thinking and we were unable to solve cases like "abab" and shifted to "baba"
        // StringBuilder sb=new StringBuilder();
        // int i=0;
        // int j=0;
        // if(s.length()!=goal.length()){
        //     return false;
        // }
        // if(s.length()==1&&goal.length()==1&&s.charAt(0)!=goal.charAt(0)){
        //     return false;
        // }
        // while(i<s.length()&&j<goal.length()){
        //     if(s.charAt(i)==goal.charAt(j)){
        //         i++;
        //         j++;
        //     }
        //     else{
        //         sb.append(s.charAt(i));
        //         i++;
        //     }
        // }
        // for(int k=0;k<sb.length();k++){
        //     if(sb.charAt(k)==goal.charAt(j)){
        //         j++;
        //     }
        //     else{
        //         return false;
        //     }
        // }
        // return true;
    }
}