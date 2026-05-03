class Solution {
    public boolean queryString(String s, int n) {
        for(int i = 1 ; i <= n ;i++){
            String str = Integer.toBinaryString(i);
            if(!s.contains(str)){
                return false;
            }
        }
        return true;
    }
}