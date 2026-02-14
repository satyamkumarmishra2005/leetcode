class Solution {
    public String minWindow(String s, String t) {

    HashMap<Character, Integer> map = new HashMap<>();

    int n = s.length();

    if(t.length()> n){
        return "";
    }

    for(char ch : t.toCharArray()){
        map.put(ch, map.getOrDefault(ch,0)+1);
    }

    int i =0;
    int j =0;

    int start_i = 0;

    int reqcount = t.length();

    int minwindowsize = Integer.MAX_VALUE;

    while(j< n){
        char ch = s.charAt(j);

        if(map.containsKey(ch) && map.get(ch)>0 ){
            reqcount--;
        }

        map.put(ch, map.getOrDefault(ch,0)-1);


        while(reqcount==0){ // Start shrinking

        int currwindowsize = j-i+1;

        if (minwindowsize > currwindowsize) {
                    minwindowsize = currwindowsize;
                    start_i = i;
                }

         

         char leftchar = s.charAt(i);
         map.put(leftchar , map.getOrDefault(leftchar,0)+1);


         if(map.containsKey(leftchar) && map.get(leftchar)> 0 ){  // we have removed the charcter of string t from string s so now the required count increases for that character
            reqcount++;
         }



         i++;






        }

        j++;
    }

     return minwindowsize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minwindowsize); 
        
    }
}