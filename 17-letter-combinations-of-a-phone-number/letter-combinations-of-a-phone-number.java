class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return helper("", digits);
    }

    //we have different mapping of characters here in this question instead of the case in the lecture
    private String[] mapping = {
            "", //represents 0
            "", //represents 1 
            "abc", //represents 2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno", //6
            "pqrs", //represents 7
            "tuv", //8
            "wxyz"//9
    };

    public List<String> helper(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digits = up.charAt(0) - '0';
        String letter = mapping[digits];//this will give us that particular string space
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < letter.length(); i++) {
            char ch = letter.charAt(i);
            ans.addAll(helper(p + ch, up.substring(1)));
        }
        return ans;
    }
}