class Solution {
    public int totalFruit(int[] fruits) {


        // Same question as Pick Toys and as Maximum subaaray with max K unique characters here k = 2

        int i =0;
        int j =0;
        int k =2 ;
        
        int max = 0;

         int n = fruits.length;
         HashMap<Integer,Integer> map = new HashMap<>();

         while(j< n){
        map.put(fruits[j], map.getOrDefault(fruits[j],0)+1);

        while(map.size()>k){
            int left = fruits[i];

            map.put(left , map.get(left)-1);

            if(map.get(left)==0){
                map.remove(left);
               
            }

            i++;
        }

        max = Math.max(max , j-i+1); // for condition when map.size()<=k
        j++;

         }

         return max;
        
    }
}