class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

         int ans[] = new int[nums.length - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        int i =0;
        int j=0;
        int n = nums.length;

        while(j< n){
        if(dq.size()==0){
            dq.add(nums[i]);
        }

        else{
            while(dq.size()>0 && dq.peekLast()< nums[j]){
                dq.removeLast();
            }

            dq.add(nums[j]);
        }

       
       if(j-i+1<k){
        j++;
       }

       else if(j-i+1==k){
        ans[i] = dq.peek();
        //Silde the window
        // calculation

        if(nums[i]==dq.peek()){
            dq.removeFirst();
        }

        i++;
        j++;
       }

        
    }

    return ans;
}
}