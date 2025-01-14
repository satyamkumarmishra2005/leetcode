class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        // Brute Force 
      //  Time complexity: O(n3)
        int n = A.length;

        

    int prefixcommonArray [] = new int [n];  // created a prefixcommonArray to store the count of common elements
    
     // Loop through each index to calculate common elements for each prefix
    for(int currentindex = 0 ; currentindex< n ; currentindex++){
        int commoncount = 0;

    
        for(int Aindex = 0 ; Aindex<= currentindex ; Aindex++){
            for(int Bindex = 0 ; Bindex<= currentindex ; Bindex++){

                if(A[Aindex]==B[Bindex]){
                    commoncount ++;
                    break;   //Prevent counting Duplicates
                }
            }
        }
      // Store the count of common elements for the current prefix
        prefixcommonArray[currentindex] = commoncount;
    }
     return prefixcommonArray;
    }
}