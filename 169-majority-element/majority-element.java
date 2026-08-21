class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            } else {
                m.put(nums[i], 1);
            }
        }
        int majorElem = 0;
        int max=0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            majorElem = Math.max(majorElem, entry.getValue());
            if(majorElem==entry.getValue()){
                max=entry.getKey();
            }
        }
        return max;
    }
}