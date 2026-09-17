class BitTrie{
    BitTrie bit[];
    int cnt;
    BitTrie(){
        cnt = 0;
        bit = new BitTrie[2];
    }
    public void addNum(int n){
        BitTrie curr = this;
        for(int i = 30; i >= 0; i--){
            int r = (n&(1<<i)) == 0? 0 : 1;
            if(curr.bit[r] == null)    curr.bit[r] = new BitTrie();
            curr = curr.bit[r];
            curr.cnt++;
        }
    }
    public void removeNum(int n){
        BitTrie curr = this;
        for(int i = 30; i >= 0; i--){
            int r = (n&(1<<i)) == 0? 0 : 1;
            curr = curr.bit[r];
            curr.cnt--;
        }
    }
}
class Solution {
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        Map<Integer, List<int []>> vals = new HashMap<>();
        for(int i = 0; i < queries.length; i++){
            int q[] = queries[i];
            if(!vals.containsKey(q[0]))  vals.put(q[0], new ArrayList<>());
            vals.get(q[0]).add(new int[]{q[1], i});
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int root = -1;
        for(int i = 0; i < parents.length; i++){
            if(parents[i] == -1)    root = i;
            if(!graph.containsKey(parents[i]))   graph.put(parents[i], new ArrayList<>());
            graph.get(parents[i]).add(i);
        }
        BitTrie bt = new BitTrie();
        int res[] = new int[queries.length];
        dfs(bt, vals, root, graph, res);
        return res;
    }
    private void dfs(BitTrie bt, Map<Integer, List<int []>> vals, int curr, Map<Integer, List<Integer>> graph, int res[]){
        bt.addNum(curr);
        if(vals.containsKey(curr)){
            for(int val[]: vals.get(curr)){
                res[val[1]] = getMaxXor(bt, val[0]);
            }
        }
        if(graph.containsKey(curr)){
            for(int child: graph.get(curr)){
                dfs(bt, vals, child, graph, res);
            }
        }
        bt.removeNum(curr);
    }
    private int getMaxXor(BitTrie bt, int val){
        BitTrie curr = bt;
        int num = 0;
        for(int i = 30; i >= 0; i--){
            int r = 1 - ((val&(1<<i)) == 0 ? 0 : 1);
            if(curr.bit[r] != null && curr.bit[r].cnt > 0){
                curr = curr.bit[r];
                num |= (1<<i);
            }else   curr = curr.bit[1 - r];
        }
        return num;
    }
}