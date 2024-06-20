class Solution {
    public boolean isPowerOfTwo(int n) {
//         if(n<=0){
//             return false;
//         }
//         if(n==1){
//             return true;
//         }

//         return n %2 ==0 && isPowerOfTwo(n/2);
//     }
// }

// Approach 2

for(int i = 0 ; i<31 ; i++){
    int ans = (int) Math.pow(2,i);
    if(ans == n){
        return true;
    }
}
return false;
    }
}