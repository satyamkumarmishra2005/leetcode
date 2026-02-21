class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;  // the min she can take 1 hours to eat 
        int max = 0;
        for(int pile: piles){
            max = Math.max(max,pile);
        }

        int right = max;

        int res = max;


        while(left<= right){

            int mid = left + (right-left)/2;

            long totaltime = eatingtime(piles, mid , h);

            if(totaltime> h){ 

                left = mid +1; // because if the speed increases the time will decrease 

            }

            else{  // the totaltime is less than h 
             res = mid; // possible answer
             right = mid-1; // for finding the minimum speed in which she can eat all bananna wihout geeting caught by guard
            }

        }

        return res;

        
    }

    public long eatingtime(int[]piles , int k , int h ){
        long hours = 0;

        for(int i =0 ; i< piles.length; i++){
            hours = hours + piles[i] / k ;

            if(piles[i]% k != 0){ // if the remainder is not zero than we will increase 1 hour
                hours ++;
            }
        }

        return hours;
    }
}