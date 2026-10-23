class Solution {
    public boolean isVowel(char c){
        return "aeiou".indexOf(c)>=0;//this is used to check for vowel remember it is a great shortcut function
    }
    public int maxVowels(String s, int k) {
        int vowel=0;
        int max=0;
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i))){
                vowel++;
            }
        }
        max=Math.max(max,vowel);
        for(int i=k;i<s.length();i++){
            if(isVowel(s.charAt(i-k))){//this i-k makes it a fixed sliding window approach
                vowel--;
            }
            if(isVowel(s.charAt(i))){
                vowel++;
            }
            max=Math.max(max,vowel);
        }
        return max;
    }
}