class Solution {
    public int totalNumbers(int[] digits) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int digit:digits){
            map.put(digit,map.getOrDefault(digit,0)+1);
        }

        int count=0;
        //this loop is for ones place that only has even numbers
        for(int one=0;one<=8;one+=2){
            if(!map.containsKey(one)||map.get(one)==0){
                continue;
            }
            //we concume this digit by 
            map.put(one,map.get(one)-1);

            //loop for tens digit
            for(int ten=0;ten<=9;ten++){
                if(!map.containsKey(ten)||map.get(ten)==0){//these are for the combinations that would have been used before
                    continue;//so we skip this iterattion
                }
                //consuming the tens digit
                map.put(ten,map.get(ten)-1);
                //loop for hundredth digit
                for(int hundred=1;hundred<=9;hundred++){
                    if(map.containsKey(hundred)&&map.get(hundred)>0){
                        count++;//at this point we have a single combination of a number 
                    }
                }
                //now after the combination reviving the digits
                map.put(ten,map.get(ten)+1);
            }
            map.put(one,map.get(one)+1);
        }
        return count;
    }
}