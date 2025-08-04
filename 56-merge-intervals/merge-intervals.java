class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

         List<int[]> res = new ArrayList<>();

         int[] newinterval = intervals[0];

         res.add(newinterval);

         for(int[] interval: intervals){
            if(interval[0]<= newinterval[1]){
              newinterval[1] = Math.max(interval[1], newinterval[1]);
            }

            else{
                newinterval= interval;

                res.add(newinterval);
            }
         }

          return res.toArray(new int[res.size()][]);
    }
}