class Solution {
    public int rob(int[] a) {

        int n = a.length;
        if(n==0) return 0;
        if(n ==1) return a[0];
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0) a1.add(a[i]);
            if(i!=n-1) a2.add(a[i]);
        }
        return Math.max(solve(a1),solve(a2));
    }
    public int solve(ArrayList<Integer> a){
        int n = a.size();
        int prev1=a.get(0);
        int prev2=0;

        for(int i=1;i<n;i++){

            int pick = a.get(i);
            if(i>1) pick+=prev2;
            int nopick = prev1;

            int cur = Math.max(pick,nopick);

            prev2=prev1;
            prev1=cur;
        }
        return prev1;        
    }
}