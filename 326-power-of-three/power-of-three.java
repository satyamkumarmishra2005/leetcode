
  class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 3 != 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }
}

//     for(int i =0 ; i<31 ; i++){
//         int ans = (int) Math.pow(3,i);
//         if(ans==n){
//             return true;
//         }
        
//     }
// return false;
//     }
// }