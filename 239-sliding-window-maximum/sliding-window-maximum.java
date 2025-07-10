class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int ans[] = new int[nums.length-k+1];

        Deque<Integer> dq = new LinkedList<>();


        int n = nums.length;

        int i =0;
        int j =0;

        while(j<n){

            if(dq.size()==0){  // If the dq is empty then add the elements of the array nums
                dq.add(nums[i]);
            }

            else{
                while(dq.size()>0 && dq.peekLast()< nums[j]){  // If the elemnts present in the dequeare smaller then the current element then remove those elements from the deque
                    dq.removeLast();
                }

                dq.add(nums[j]);// add the largest element in the dequeue
            }


            if(j-i+1<k){
                j++;
            }
            
            else if(j-i+1==k){    
                ans[i] = dq.peek(); // add the max element in the ans array

                if(nums[i]==dq.peek()){  // if the current element and the elemnt present tin the front is same then remove the elemnt for sliding the window
                    dq.removeFirst();
                }

                i++;
                j++;
            }

        }

        return ans;
        
    }
}