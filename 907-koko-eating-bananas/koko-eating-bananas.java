class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    
    int max = 0;
     int left = 1;
    

     for(int pile: piles){
        max = Math.max(max , pile);
     }

     int right = max;
     int res = max;

     while(left<= right){
        int mid = left + (right-left)/2;

        long totaltime = eatingtime(piles, mid , h);


        if(totaltime> h){

            left =  mid +1 ;

        }

        else{
            res = mid;
            right = mid -1;
        }
     }

     return res;
    
        
    }


    public long eatingtime(int[]piles , int k , int h){
       long hours = 0;

       for(int i =0 ; i< piles.length ; i++){
        hours = hours + piles[i] / k;

        if(piles[i]%k!=0){
            hours++;

        }
       }

       return hours;

    }
}