class Solution {

    public int [] dijkstra(int src , int n , ArrayList<ArrayList<int [] >> adjList ){
        PriorityQueue< int [] > pq = new PriorityQueue<>(new Comparator<int [] >(){
            public int compare(int [] p1 , int [] p2){
                return p1[1] - p2[1]; // return minimum;
            }
        });

        int time [] = new int [n];
       Arrays.fill(time , Integer.MAX_VALUE);

       time[src] = 0;
       pq.offer(new int [] {src , 0});

       while(!pq.isEmpty()){
        int pair [] = pq.poll();
        int u = pair[0];
        int d = pair[1];

        if(d > time[u]){  // if the currently visited node has already calculated result which is small then the agin visit then skip
            continue;
        }
        for(int [] neighbour : adjList.get(u)){
            int v = neighbour [0];
            int w = neighbour[1];

            if( time[u] + w < time[v]){
                time[v] = time[u] + w;
                 pq.offer( new int [] {v , time[v]});
            }

        }
       }

       return time;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int [] >> adjList = new ArrayList<>();

        for(int i =0 ; i< n ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int time [] : times ){
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];

            adjList.get(u).add(new int [] {v,w});
        }

        int mintime [] = dijkstra(k -1 , n , adjList);

        int res = Integer.MIN_VALUE;

        for(int time : mintime){
            res = Math.max(res , time);
        }

        // Initially each node has a value of Infinity;

        return (res==Integer.MAX_VALUE  ) ? -1 : res;  // if  any unvisited node is there unvisited node have a value of Infinity then we will return -1 ;
    }
}