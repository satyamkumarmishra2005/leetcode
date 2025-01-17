class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;

        for(int x : derived){
            xor =( xor ^ x );
        }

        return xor == 0; // if xor of derived elemnets is 0 then it is valid 
    }
}