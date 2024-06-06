class Solution {
    public String largestOddNumber(String num) {
                StringBuilder s = new StringBuilder(num);
        int op = 0;
        for (int i = num.length()-1;i >= 0;i--){
            if (num.charAt(i)%2 !=0 ){
                op = 1;
                s.setLength(i+1);
                break;
            }
        }
        
        if (op == 1){
            return s.toString();
        }else {
            return "";
        }
    }
}