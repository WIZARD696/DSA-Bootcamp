class Solution {
    public int firstUniqChar(String s) {
        //this is my previous approach that used initially:
        
        // HashMap<Character,Integer> map=new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     if(map.containsKey(s.charAt(i))){
        //         map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        //     }
        //     else{
        //         map.put(s.charAt(i),1);
        //     }
        // }
        // for(int i=0;i<s.length();i++){
        //     if(map.get(s.charAt(i))==1){
        //         return i;
        //     }
        // }
        // return -1;

        //this is the optimised approach I used later
        int []count=new int[26];
        //creating a frequency array..this approach is more optimised
        for(char c:s.toCharArray()){//remember this function is used to convert the given string into a character array as clear from the name
            count[c-'a']++;//this will convert the character to the index value of the count array ..you must know it
        }
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;

    }
}
