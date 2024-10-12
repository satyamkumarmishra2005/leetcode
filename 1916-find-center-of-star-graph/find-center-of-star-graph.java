class Solution {
    public int findCenter(int[][] edges) {
        // Brute force
        HashMap<Integer , Integer> freqMap = new HashMap<>();
       int totaledges = edges.length;
        for(int i = 0 ; i<edges.length ; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];

            freqMap.put(v1,freqMap.getOrDefault(v1,0)+1);
            freqMap.put(v2,freqMap.getOrDefault(v2,0)+1);

            if(freqMap.get(v1)==totaledges){
                return v1;
            }
            if(freqMap.get(v2)==totaledges){
                return v2;
            }
        }
        return 0 ;
    }
}