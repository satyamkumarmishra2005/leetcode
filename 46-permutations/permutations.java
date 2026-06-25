class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        findpermutation(nums, ans , visited, new ArrayList<>());

        return ans;
        
    }


    public void findpermutation(int[] nums , List<List<Integer>> ans , boolean[] visited , List<Integer> ds){

        if(ds.size()== nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }


        for(int i =0 ; i<nums.length ; i++){

        if(visited[i]){
            continue;
        }

        visited[i]= true;
        ds.add(nums[i]);

        findpermutation(nums, ans, visited , ds);

        ds.remove(ds.size()-1);

        visited[i] = false;

        
        }


    }
}