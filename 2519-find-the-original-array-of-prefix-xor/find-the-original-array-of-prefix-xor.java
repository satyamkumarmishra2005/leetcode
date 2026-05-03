class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] temp = new int[n];
        temp[0] = pref[0];
        for (int i = 1; i < n; i++){
            temp[i] = pref[i-1]^pref[i];
        }
        return temp;
    }
}