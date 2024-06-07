class Solution {
    public boolean isIsomorphic(String s, String t) {
        int [] indexs = new int [200];
        int [] indext = new int [200];

        int l = s.length();

        if(l!=t.length()){
            return false;
        }

        for(int i =0 ; i<l ; i++){
            if(indexs[s.charAt(i)] != indext[t.charAt(i)]){
                return false;
            }
            indexs[s.charAt(i)]= i+1;
            indext[t.charAt(i)]= i+1;
        }
        return true;
    }

}