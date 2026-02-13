class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int k = p.length();

        int i =0;
        int j =0;

        HashMap<Character, Integer> pmap = new HashMap<>();

        HashMap<Character, Integer> smap = new HashMap<>();

        
        List<Integer> result = new ArrayList<>();


        for(char ch: p.toCharArray()){
            pmap.put(ch, pmap.getOrDefault(ch,0)+1);
        }
    
    while(j<s.length()){
         char ch = s.charAt(j);
         smap.put(ch, smap.getOrDefault(ch,0)+1);


         if(j-i+1<k){
            j++;
         }

         else if (j-i+1==k){
            if(pmap.equals(smap)){
                result.add(i);

            }

            char outchar = s.charAt(i);
            smap.put(outchar, smap.get(outchar)-1);


            if(smap.get(outchar)==0){
                smap.remove(outchar);
            }

            i++;
            j++;
         }

    }

    return result;
        
    }
}