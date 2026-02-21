class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int left = 1;

        int max = 0;

        int ans = -1;

        for(int bloom: bloomDay){
            max = Math.max(max , bloom);
        }

        int right = max;


        while(left<= right){
            int mid = left + (right-left)/2;

            if(possibleDay(bloomDay, m , k , mid) >= m){
                ans =  mid ;
                right = mid -1;
            }

            else{
                left = mid +1;

            }
        }
        return ans;
    }

    public long possibleDay(int[] bloomDay, int m, int k, int day) {

        long flower = 0;
        long buoqcount = 0;

        for(int i =0 ; i< bloomDay.length ; i++){

            if(bloomDay[i]<=day){
                flower ++;
            }

            else{
                flower = 0;
            }


            if(flower == k){
                buoqcount ++;
                flower = 0;
            }
        }


        return buoqcount;

    }

}