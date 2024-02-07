class Solution {
    public int maximumPopulation(int[][] logs) {
        int [] arr = new int [101];
        for(int i = 0 ;  i< logs.length; i++){
            arr[logs[i][0]-1950]++;
            arr[logs[i][1]-1950]--;
        }
     // Running sum ;
     for(int i = 1 ; i<101; i++){
         arr[i] += arr[i-1];
     }
     int maxVal = 0;
     int maxYear = 1950;
     for(int i = 0 ; i<101;i++){
         if(maxVal < arr[i]){
             maxVal = arr[i];
             maxYear = i + 1950;
         }
     }
return maxYear;
       
    }
}