class Solution {
    int len;
    int ans;
    int k;
    public int distributeCookies(int[] cookies, int k) {
        len = cookies.length;
        ans = Integer.MAX_VALUE;
        this.k = k;

        int[] divide = new int[k];
        minFinder(cookies, 0, divide);
        return ans;
    }
    public void minFinder(int[] cookies, int i, int[] divide) {
        if(i == len){
            int max = Integer.MIN_VALUE;
            for(int ele: divide){
                max = Math.max(max,ele);
            }

            ans = Math.min(ans,max);
            return;
        }

        for(int j = 0;j < k;j++){
            divide[j] += cookies[i];
            minFinder(cookies, i+1, divide);
            divide[j] -= cookies[i];

            if(divide[j] == 0) break;
        }
    }
}