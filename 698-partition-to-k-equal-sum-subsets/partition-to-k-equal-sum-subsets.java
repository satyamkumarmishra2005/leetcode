class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int totalsum = 0;

        boolean[] visited = new boolean[nums.length];

        for(int num: nums){
            totalsum = totalsum+num;
        }
    
    if(totalsum%k!=0){
        return false;
    }

    int target = totalsum/k;


  return   backtrack(nums,visited, target, k,0,0,0);

        
    }


    public boolean backtrack(int[]nums , boolean[]visited, int target , int k , int indx, int currsum , int count){

        if(count==k){
            return true;
        }

        if(currsum==target){
           return  backtrack(nums,visited,target,k,0,0,count+1);
        }


        for(int i = indx; i< nums.length ; i++){

            if(visited[i]){
                continue;
            }

            if(currsum+nums[i]> target){
                continue;
            }

            visited[i]= true;


            if(backtrack(nums, visited, target,k , i+1, currsum+nums[i], count)){
                return true;
            }

            visited[i]= false;
        }


        return false;
    }
}