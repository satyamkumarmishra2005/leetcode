class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int [] index = new int [2];

        int i = 0;
        int j = numbers.length-1;

        while(i< j){

            if(numbers[i] + numbers[j] > target){
                j--;
            }

            else if (numbers[i] + numbers[j] < target){
                i++;
            }
            
          else{
            index[0] = i+1 ;
            index[1] = j+1;

            return index ;

          
          }
            
    
        
        }
      
       
      return index;
    
        
    }
}