class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int num = x;
        while (num > 0) {
            int temp = num % 10;
            sum += temp;
            num = num / 10;
        }
        if(x%sum==0){
            return sum;
        }
        return -1;
    }
}