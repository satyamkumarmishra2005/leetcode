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
        if(nums2[i]<st.peek()){

            map.put(nums2[i], st.peek());
            st.push(nums2[i]);
            
            continue;
        }

        while(!st.isEmpty() && nums2[i]> st.peek()){
            st.pop();
        }

        if(st.isEmpty()){
            st.push(nums2[i]);
            map.put(nums2[i], -1);
        }

        else{
            map.put(nums2[i], st.peek());
            st.push(nums2[i]);
            
        }
    }


    for(int i =0 ; i< nums1.length; i++){
        nums1[i] = map.get(nums1[i]);
    }


return nums1;
        
    }
}