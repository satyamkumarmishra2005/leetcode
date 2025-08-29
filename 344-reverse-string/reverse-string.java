class Solution {
//     public void reverseString(char[] s) {
//        reverse(s,0,s.length-1);
//     }
//     private void reverse(char[] s , int left , int right){
//         if(left >=  right){
//             return;
//         }
//  char temp = s[left];
//  s[left] = s[right];
//  s[right] = temp;

//  reverse(s,left+1 , right-1);
//     }
// }

// Time complexity O(N)
// Space complexity O(1)
//  public void reverseString(char[] s) {

//     int left = 0 ; 
//     int right = s.length-1;

//     while(left<=right){
//      char temp = s[left];
//      s[left] = s[right];
//      s[right] = temp;
    
//     left++;
//     right--;
    
//  }
//}

public void reverseString(char[] s) {
    int n = s.length;
    
    reverse(s , 0 , n);
}

static void reverse(char[] s , int i , int n){
    if(i>= n/2){
        return ;
    }

    char temp = s[i];
    s[i] = s[n-i-1];
    s[n-i-1] = temp;


    reverse(s, i+1 , n);
}
}
