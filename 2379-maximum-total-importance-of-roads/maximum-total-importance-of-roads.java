class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long degree[] = new long[n];
        for(int edges[] : roads){
            degree[edges[0]] ++;
            degree[edges[1]] ++ ;

        }

        Arrays.sort(degree);

        long lable = 1;  // increasing order
        long sum = 0;

        for(int i =0 ; i< n ; i++){
        sum += (degree[i] * lable);
        lable ++;
        }

        return sum ;
        }
}