class Solution {
    public String longestPalindrome(String s) {

        if(s.length()<=1){
            return s;
        }

        String lps = "";

        // for odd length palindrome

        for(int i = 1 ; i<s.length(); i++){

            int low = i;
            int high = i;

            while(s.charAt(low)== s.charAt(high)){
                low--;
                high++;

                if(low==-1 || high ==s.length()){
                break;
            }

            }


            

        String palindrome = s.substring(low+1, high);

        if(palindrome.length()> lps.length()){
            lps = palindrome;
        }



        // consider even length

        low = i-1;
        high = i;


        while(s.charAt(low)==s.charAt(high)){
            low--;
            high++;

            if(low==-1 || high ==s.length()){
                break;
            }

        }

         


         palindrome = s.substring(low+1, high);
 

      if(palindrome.length()> lps.length()){
            lps = palindrome;
        }





        }


        return lps;
        
    }
}