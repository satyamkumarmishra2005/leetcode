class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        // Brute Force 
      //  Time complexity: O(n3)
//         int n = A.length;

        

//     int prefixcommonArray [] = new int [n];  // created a prefixcommonArray to store the count of common elements
    
//      // Loop through each index to calculate common elements for each prefix
//     for(int currentindex = 0 ; currentindex< n ; currentindex++){
//         int commoncount = 0;

    
//         for(int Aindex = 0 ; Aindex<= currentindex ; Aindex++){
//             for(int Bindex = 0 ; Bindex<= currentindex ; Bindex++){

//                 if(A[Aindex]==B[Bindex]){
//                     commoncount ++;
//                     break;   //Prevent counting Duplicates
//                 }
//             }
//         }
//       // Store the count of common elements for the current prefix
//         prefixcommonArray[currentindex] = commoncount;
//     }
//      return prefixcommonArray;
//     }
// }

// Optimized Approch using Hashset

// Time complexity: O(n2)
//space complexity : O(n)

int n = A.length;

int prefixcommonArray[] = new int [n];

// Initialize sets to store elements from A and B

Set<Integer> elementInA = new HashSet<Integer>();
Set<Integer> elementInB = new HashSet<Integer>();

 // Iterate through the elements of both arrays

for(int currentIndex = 0 ; currentIndex< n ; currentIndex++){

      // Add current elements from A and B to respective sets
  elementInA.add(A[currentIndex]);
  elementInB.add(B[currentIndex]);

   int commoncount = 0;
   
    // Count common elements between the sets

   for(int element :  elementInA ){
    if( elementInB.contains(element)){
         commoncount++;
    }
   }
   // Store the count of common elements for the current prefix
   prefixcommonArray[currentIndex] =  commoncount;
    
}

return  prefixcommonArray;


    }
}