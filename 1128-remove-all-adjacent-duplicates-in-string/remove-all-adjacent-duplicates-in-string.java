class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(result.length()>0&&s.charAt(i)==result.charAt(result.length()-1)){
                result.deleteCharAt(result.length()-1);
                continue;
            }
            result.append(s.charAt(i));
        }
        String r=result.toString();
        return r;
    }
}