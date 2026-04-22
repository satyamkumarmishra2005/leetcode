class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        solve(nums , result , new ArrayList<>(), visited);

        return result;
        
    }


     public void solve(int [] nums , List<List<Integer>> result , List<Integer> temp , boolean [] visited){

       

        if(temp.size()== nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i< nums.length ; i++){

            if(visited[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

                temp.add(nums[i]);

                visited[i] = true;

                solve(nums , result , temp , visited);


               temp.remove(temp.size()-1);

               visited[i]= false;    
            }
        }

        


    }
