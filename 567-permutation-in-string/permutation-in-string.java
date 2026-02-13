class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character , Integer> s1map = new HashMap<>();
        HashMap<Character, Integer> s2map = new HashMap<>();
        int k = s1.length();

        for(char ch: s1.toCharArray()){
            s1map.put(ch , s1map.getOrDefault(ch,0)+1);
        }

        int i =0;
        int j =0;

        while(j<s2.length()){
            char ch = s2.charAt(j);

            s2map.put(ch , s2map.getOrDefault(ch,0)+1);

            if(j-i+1<k){
                j++;
            }

            else if (j-i+1==k){
                if(s1map.equals(s2map)){
                    return true;
                }

                
            char outchar = s2.charAt(i);
            s2map.put(outchar, s2map.get(outchar)-1);


            if(s2map.get(outchar)==0){
                s2map.remove(outchar);
            }

            i++;
            j++;



            }
        }



        return false;



        
    }
}