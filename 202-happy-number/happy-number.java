class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while(fast!= 1 && fast!= slow){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }


        if(fast==1){
            return true;
        }
        return false;
    }

    public int getNext(int n ){
        int totalsum = 0;
        while(n>0){
            int d = n%10;
            n = n/10;
            totalsum+= d*d;
        }

        return totalsum;
    }
}