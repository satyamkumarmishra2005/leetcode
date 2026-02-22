class Solution {
    public int maxDistance(int[] position, int m) {

      Arrays.sort(position);
      int n = position.length;

      int left = 1;
      int right = position[n-1]-position[0]; // maximum force
      int res = 0;


      while(left<= right){
        int mid = left + (right-left)/2;

        if(possibleToPlace(position , m , mid)){
          res = mid; // possible answer
          left = mid+1 ;// we have to find the miaximum  minimum magnetic  force
        }

        else{
            right = mid-1;
        }

      }

      return res;
        
    }


    public boolean possibleToPlace(int[] position , int m , int force){
        int prev = position[0];
        int countballs = 1;

        for(int i = 1; i<position.length ; i++){
            int curr = position[i];

            if(curr-prev>= force){
                countballs++;
                prev = curr;
            }

            if(countballs==m){
                break;
            }
        }

        return countballs==m;
    }
}