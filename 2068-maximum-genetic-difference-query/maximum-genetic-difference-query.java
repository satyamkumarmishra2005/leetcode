class Solution {
    class Trie{
        int val;
        Trie[] child;
        int ct;

        public Trie(){
            this.val = -1;
            this.child = new Trie[2];
            this.ct = 0;
        }
    }

    Trie root;

    private void add(int val){
        Trie node = root;

        for(int i = 31;i >= 0;i--){
            int bit = (val >> i) & 1;

            if(node.child[bit] == null){
                node.child[bit] = new Trie();
            }
 
            node = node.child[bit];
            node.ct++;
        }

        node.val = val;
    }

    private void remove(int val){
        Trie node = root;
    
        for(int i = 31; i >= 0; i--){
            int bit = (val >> i) & 1;

            node.child[bit].ct--;

            if(node.child[bit].ct == 0){
                node.child[bit] = null;
                break;
            }
            
            node = node.child[bit];
        }
    }

    private int getMax(int val){
        Trie node = root;

        for(int i = 31;i >= 0;i--){
            int bit = (val >> i) & 1;
            int invBit = (bit == 0) ? 1 : 0;

            if(node.child[invBit] != null){
                node = node.child[invBit];
            }
            else{
                node = node.child[bit];
            }
        }

        return node.val;
    }

    private void dfs(HashMap<Integer, List<int[]>> QueryMap, HashMap<Integer, List<Integer>> adj, int[] ans, int node){
        add(node);

        for(int[] it : QueryMap.getOrDefault(node, new ArrayList<>())){
            ans[it[0]] = it[1] ^ getMax(it[1]);
        }

        for(int it : adj.getOrDefault(node, new ArrayList<>())){
            dfs(QueryMap, adj, ans, it);
        }

        remove(node);
    }

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        root = new Trie();

        HashMap<Integer, List<int[]>> QueryMap = new HashMap<>();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0;i < parents.length;i++){
            adj.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        }

        for(int i = 0;i < queries.length;i++){
            QueryMap.computeIfAbsent(queries[i][0], k-> new ArrayList<>()).add(new int[]{i, queries[i][1]});
        }

        int[] ans = new int[queries.length];

        for(int i = 0;i < parents.length;i++){
            if(parents[i] == -1){
                dfs(QueryMap, adj, ans, i);
            }
        }

        return ans;
    }
}