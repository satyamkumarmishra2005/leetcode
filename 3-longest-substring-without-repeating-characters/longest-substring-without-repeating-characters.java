class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int i =0;
        int j =0;
        int max = 0;

        while(j< s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(map.size()== j-i+1){
                max =   Math.max(max , j-i+1);
                j++;

            }
            else if(map.size()< j-i+1){   // duplicates found

                while(map.size()< j-i+1){
                     char leftchar = s.charAt(i);
                  map.put(leftchar, map.get(leftchar)-1);

                  if(map.get(leftchar)==0){
                    map.remove(leftchar);
                  }

                  i++;

                }

                j++;
               

            }

        }

        return max;
        
    }
}