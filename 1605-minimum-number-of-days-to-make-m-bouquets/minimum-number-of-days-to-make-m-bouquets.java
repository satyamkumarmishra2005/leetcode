class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int left = 1;

        int max = 0;

        int minday = -1;

        for(int bloom: bloomDay){
            max = Math.max(max , bloom);
        }

        int right = max;


        while(left<= right){
            int mid = left + (right-left)/2;

            if(canMakebouque(bloomDay, m , k , mid) >= m){
                minday =  mid ; // possible answer
                right = mid -1; // look for more min day
            }

            else{
                left = mid +1;// this day is not sufficent for flowers to bloom pick a larger day

            }
        }
        return minday;
    }

    public long canMakebouque(int[] bloomDay, int m, int k, int day) {

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