class Solution {

    public void dfs(String srcEmail ,   HashSet<String> visited ,HashMap<String , List< String>> adjMap ,  List<String> subList ){
        visited.add(srcEmail);
        subList.add(srcEmail);

        if(!adjMap.containsKey(srcEmail)){
            return ;
        }

        for(String neighbour : adjMap.get(srcEmail)){
            if(!visited.contains(neighbour)){
                dfs(neighbour , visited , adjMap , subList);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // adj Map
        HashMap<String , List< String>> adjMap = new HashMap<>();
         for(List<String> account : accounts){

            // connect first email with same email 
        
            String firstemail = account.get(1);
            for(int i = 2 ; i< account.size() ; i++){
                String email = account.get(i);

                if(!adjMap.containsKey(firstemail)){
                    adjMap.put(firstemail, new ArrayList<>());
                }

                adjMap.get(firstemail).add(email);

                
                if(!adjMap.containsKey(email)){
                    adjMap.put(email, new ArrayList<>());
                }

                adjMap.get(email).add(firstemail);
            }
         }

         List<List< String >> res = new ArrayList<>();
         HashSet<String> visited = new HashSet<>();

         for(List<String> account : accounts){
          String firstemail = account.get(1);
          if(!visited.contains(firstemail)){
        List<String> subList = new ArrayList<>();
            dfs(firstemail , visited , adjMap , subList);
            Collections.sort(subList);
            subList.add(0, account.get(0));  // name 

            res.add(subList);
          }
         }
         return res;
    }
}