class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            int j = 1;
            while (j < strs.length) {
                if (!(i < strs[j].length() && ch == strs[j].charAt(i))) {
                    return sb.toString();
                }
                j++;
            }
            
                sb.append(ch);
        }
        return sb.toString();
    }
}