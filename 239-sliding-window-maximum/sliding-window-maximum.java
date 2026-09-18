class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[]result = new int[n-k+1];

        Deque<Integer> deq = new LinkedList<>();

        int i=0;
        int j=0;

        int indx=0;


        while(j<n){

            while(!deq.isEmpty() && nums[deq.peekLast()]<= nums[j]){
                deq.pollLast();
            }

            deq.addLast(j);


            if(j-i+1<k){
                j++;
            }

            else{

                if(deq.peekFirst()<i ){
                    deq.pollFirst();
                }



                result[indx]= nums[deq.peekFirst()];
                indx++;


                i++;
                j++;

            }
        }


        
        return result;
    }
}