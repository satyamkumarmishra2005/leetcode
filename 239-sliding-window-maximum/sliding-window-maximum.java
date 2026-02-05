class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k +1];

        int i =0;
        int j =0;

        Deque<Integer> dq = new LinkedList<>();

        while(j< nums.length){
            if(dq.size()==0){
                dq.add(nums[i]);
            }

            else{
                while(dq.size()>0 && dq.peekLast() < nums[j] ){
                    dq.removeLast();
                }

                dq.add(nums[j]);
            }

            if(j-i+1 < k){
                j++;
            }

            else if (j-i+1 == k){
                ans[i] = dq.peek();

                if(nums[i]== dq.peek()){
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
    return ans;

    }
}