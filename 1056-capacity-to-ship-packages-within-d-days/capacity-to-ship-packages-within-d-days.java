class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int max = 0;
        int right = 0;

        for(int w : weights){
            left = Math.max(left , w);
            right = right + w;
        }


        int res = 0;

        while(left<= right){
            int mid = left + (right-left)/2;

            if(possibletoship(weights, days , mid)){
                res = mid ;
                right = mid -1;
            }

            else{
                left = mid +1;
            }



        }

       return res;
        




        
    }

   public boolean possibletoship(int[] weights, int days, int capacity) {

    int day = 1;
    int sum = 0;

    for(int w : weights){
        if(sum + w > capacity){
            day++;
            sum = 0;
        }
        sum += w;
    }

    return day <= days;
}
}