class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
    if (nums2.length == 0 || nums1.length == 0)
      return new int[0];
       Map<Integer, Integer> numberNGE = new HashMap<>();

       Stack<Integer> helperstack = new Stack<>();
       helperstack.push(nums2[nums2.length-1]);
    numberNGE.put(nums2[nums2.length-1],-1);

    for(int i = nums2.length-2 ; i>= 0 ; i--){
        if(nums2[i]<helperstack.peek()){
            numberNGE.put(nums2[i],helperstack.peek());
            helperstack.push(nums2[i]);
            continue;
        }


        while(!helperstack.isEmpty() && helperstack.peek()<nums2[i])
        helperstack.pop();

        if(helperstack.isEmpty()){
            helperstack.push(nums2[i]);
            numberNGE.put(nums2[i],-1);
        }

        else{
            numberNGE.put(nums2[i],helperstack.peek());
            helperstack.push(nums2[i]);
        }
    }
     for (int i = 0; i < nums1.length; i++)
      nums1[i] = numberNGE.get(nums1[i]);

    return nums1;
  }
   
    }
