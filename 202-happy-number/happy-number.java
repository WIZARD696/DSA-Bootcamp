class Solution {
    public boolean isHappy(int n) {
        //now after learning linkedlist detecting a cycle type questions from lecture no. 45
        int slow=n;
        int fast=n;
        do{
            slow=square(slow);//similar to the cycle thought process where we move slow=slow.next
            fast=square(square(fast));//similar to fast=fast.next.next;

        }while(slow!=fast);

        if(slow==1){
            return true;
        }
        return false;
    }
    public int square(int number){
        int ans=0;
        while(number>0){
            int rem=number%10;
            ans+=rem*rem;
            number=number/10;
        }
        return ans;
    }
}