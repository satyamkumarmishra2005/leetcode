class Solution {
    public int findCenter(int[][] edges) {
        // Brute force
        //step1 create a freqMap which stores the frequency of vertices
        // step2 return the vertex(node) whose freq is equal to total no of edges

        // Time complexity = O(N) // edges
    //     HashMap<Integer , Integer> freqMap = new HashMap<>();
    //    int totaledges = edges.length;
    //     for(int i = 0 ; i<edges.length ; i++){
    //         int v1 = edges[i][0];
    //         int v2 = edges[i][1];

    //         freqMap.put(v1,freqMap.getOrDefault(v1,0)+1);
    //         freqMap.put(v2,freqMap.getOrDefault(v2,0)+1);

    //         if(freqMap.get(v1)==totaledges){
    //             return v1;
    //         }
    //         if(freqMap.get(v2)==totaledges){
    //             return v2;
    //         }
    //     }
    //     return 0 ;

    // Optimal 

    int [] pair1 = edges[0] ;// v1,v3
    int [] pair2 = edges[1] ;// v3,v1

    if(pair1[0]== pair2[0] || pair1[0]== pair2[1]){
        return pair1[0];
    }
    return pair1[1];
}
}