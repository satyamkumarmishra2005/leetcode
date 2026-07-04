class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        findpermutation(nums,visited, ans , new ArrayList<>());

        return ans;
        
    }


    public void findpermutation(int[]nums , boolean[] visited , List<List<Integer>> ans, List<Integer> ds ){

        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
     
     for(int i =0 ; i< nums.length; i++){

        if(visited[i]){
            continue;
        }

        if(i>0 && nums[i]== nums[i-1] && !visited[i-1]){
            continue;
        }

        ds.add(nums[i]);
        visited[i]= true;

        findpermutation(nums, visited, ans,ds);

        ds.remove(ds.size()-1);

        visited[i]= false;
     }

    }
}