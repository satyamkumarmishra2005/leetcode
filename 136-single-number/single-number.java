class Solution {
    public int singleNumber(int[] arr) {
        int n = arr.length ;
        
        
        for(int i =0 ; i<n ; i++){
         int num = arr[i];
         int cnt =0;
         for(int j = 0 ; j<n ; j++){
            if(arr[j]==num){
                cnt++;
            }
         }

         if(cnt==1){
            return num;
         }
        }
        
        return -1;

    }
}