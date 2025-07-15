class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int i =0;
        int j =0;
        int ans = 0;

        List<Integer> result = new ArrayList<>();

        // Make two HashMap one stores string p other stores string s
        // The window size wil be the length of P  as K

        // If the window size is less then K then incremnt the pointer
        // If the window size is equals to K then check if pmap.equals smap means elemnts are equal 
        // If equal add them in the result 
        // Then slide the window by removing the leftmost elemnt i then i++ and j++

        HashMap<Character,Integer> pmap = new HashMap<>();
        HashMap<Character,Integer> smap = new HashMap<>();

        int k = p.length();

        for(char ch:p.toCharArray()){
          pmap.put(ch, pmap.getOrDefault(ch,0)+1);
        }

        while(j<s.length()){

            char ch = s.charAt(j);
            smap.put(ch, smap.getOrDefault(ch,0)+1);


            if(j-i+1<k){
                j++;
            }

          else if(j-i+1==k){
                
                if(pmap.equals(smap)){
                  result.add(i);
                }


                char outchar = s.charAt(i);
                smap.put(outchar , smap.get(outchar)-1);

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