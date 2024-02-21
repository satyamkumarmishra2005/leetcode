class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index[] = new int[2];
        int start = 0;
        int end = numbers.length-1;

        while(start<end){
            int sum = numbers[start] + numbers[end];
            if(sum==target){
          index[0] = start + 1;
          index[1] = end+1;
          return index;
            }
            else if(target<sum){
                end--;
            }
            else{
                start++;
            }
        }
        return index;
    }
}