class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if(nums2.length==0 || nums1.length==0 ){
            return new int[0];
        }
    int n = nums2.length;

    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> st = new Stack<>();

    st.push(nums2[n-1]); // push the last elemnt in stack
    map.put(nums2[n-1],-1); // the next greater elemnt of the last elemnt will be -1

    for(int i = n-2 ; i>=0; i--){


        while(!st.isEmpty() && nums2[i]>= st.peek()){
            st.pop();
        }

        map.put(nums2[i], st.isEmpty()?-1 : st.peek());
        st.push(nums2[i]);

        

       
    }


    for(int i =0 ; i< nums1.length; i++){
        nums1[i] = map.get(nums1[i]);
    }


return nums1;
        
    }
}