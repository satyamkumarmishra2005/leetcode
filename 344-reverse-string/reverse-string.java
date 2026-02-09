class Solution {
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

