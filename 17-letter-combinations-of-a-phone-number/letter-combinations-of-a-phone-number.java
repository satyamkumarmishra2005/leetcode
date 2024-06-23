import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        return padlist("", digits);
    }
    
    private static ArrayList<String> padlist(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char digit = up.charAt(0);
        String letters = getLetters(digit);
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < letters.length(); i++){
            char ch = letters.charAt(i);
            ans.addAll(padlist(p + ch, up.substring(1)));
        }
        return ans;
    }

    private static String getLetters(char digit) {
        switch(digit) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }
}
    

