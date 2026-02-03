class Solution {
    public int totalFruit(int[] fruits) {
        int i =0;
        int j = 0;

        int n = fruits.length;

        int k =2;

        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
      

      while(j<n){
        map.put(fruits[j], map.getOrDefault(fruits[j],0)+1);  // we are putting elements first till size k
        

        while(map.size()>k){   // if mapsize becomes greater than k then we will remove the left occurence minimize its size
            int left = fruits[i];
            map.put(left , map.get(left)-1);

            if(map.get(left)==0){
                map.remove(left);
            }

            i++;

        }

        max = Math.max(max , j-i+1);    // when map.size() <=k ;

        j++;


      }

        return max;
    }
}