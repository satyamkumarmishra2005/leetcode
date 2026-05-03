class Solution {
    public int integerReplacement(int n) {
        long temp = n ;
        int c = 0;
        while(temp !=1){
            if(temp%2==0){
                temp/=2;
            }
            else if(temp==3 || temp%4==1){
                temp -=1;
            }
            else{
                temp+=1;
            }
            c++;
        }
        return c;
    }
}