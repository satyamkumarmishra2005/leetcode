class Solution {
    public boolean validPalindrome(String s) {
        int left =0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left)== s.charAt(right)){
                left++;
                right--;
            }

            else{
                return isvalidPalindrome(s , left+1, right) ||  isvalidPalindrome(s , left, right-1); // try deleting 1 character from either direction
            }
        }

        return true;
        
    }

    public boolean isvalidPalindrome(String s , int left , int right){

        while(left< right){
            if(s.charAt(left)== s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }



        }

        return true;
    }
}