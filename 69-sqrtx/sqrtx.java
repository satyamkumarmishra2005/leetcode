class Solution {
    public int mySqrt(int x) {

        int left = 1;
        int right = x/2;

        if(x<2){
            return x;
        }

        while(left<= right){
            int mid = left + (right-left)/2;

            long square = (long) mid * mid ;


            if(square<x){
                left = mid +1;
            }

            else if (square== x){
                return mid;

            }

            else{
                right = mid-1;
            }
        }


        return right;
        
    }
}