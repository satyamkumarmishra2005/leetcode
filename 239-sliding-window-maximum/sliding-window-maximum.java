class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int [] ans = new int[nums.length-k+1];

        int i =0;
        int j =0;


        Deque<Integer> dq = new LinkedList<>();
     
      while(j< nums.length){

        while(!dq.isEmpty() && dq.peekLast()< nums[j]){
            dq.removeLast();
        }

        dq.add(nums[j]);

        if(j-i+1 < k){
            j++;
        }
        else{
            ans[i] = dq.peekFirst();

            if(nums[i]== dq.peekFirst()){  // while sliding the window  remove the max element 
                dq.removeFirst();
            }
            i++;  // here we are moving both i and j together so the window size remains constant always k 
            j++;
        }
      }

      return ans;
        
    }
}