class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // optimized solution
        //Time complexity = O(N)
        //Space complexity = O(N)

        int n = A.length;

        int result [] = new int [n];


        HashMap<Integer ,Integer> map = new HashMap<>();
        int count =0;

        for(int i = 0 ; i< n ; i++){
            map.put(A[i] , map.getOrDefault(A[i], 0) +1 );
            if(map.get(A[i])==2){
                count++;
            }

             map.put(B[i] , map.getOrDefault(B[i], 0) +1 );
            if(map.get(B[i])==2){
                count++;
            }

            result[i] = count ;
        }
    
    return result;

    }
}