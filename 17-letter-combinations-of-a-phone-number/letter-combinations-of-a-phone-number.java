class Solution {
      List<String> result = new ArrayList<>();

     public void solve(int indx , String digits , StringBuilder temp ,  Map<Character, String> mp ){
        if(indx>= digits.length()){
            result.add(temp.toString());
            return ;
        }

       char ch = digits.charAt(indx); // 2
        String str = mp.get(ch); // abc

        for(int i =0 ; i< str.length(); i++){
            temp.append(str.charAt(i));
            solve(indx+1 , digits, temp , mp);
            // undo backtrack
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return result;
        }

        Map<Character, String> mp = new HashMap<>();
        
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        
        StringBuilder temp = new StringBuilder();

        solve(0 , digits , temp , mp);

        return result;
    }

 
}


//Ahh \U0001f525 excellent doubt — you noticed recursion keeps calling solve() after temp.append(), so when does the temp.deleteCharAt(...) line actually run?

// Let’s untangle this with a recursion + backtracking timeline.

// The key:

// In recursion, the function pauses at the recursive call (solve(idx+1, ...)).

// It only continues to the backtrack line after the recursive call returns.

// So temp.deleteCharAt(...) runs when recursion is done for that branch.

// Walkthrough with digits = "23"

// \U0001f449 At the start:
// idx = 0, digit = '2', so str = "abc"

// Iteration i = 0 ('a')
// temp.append('a');   // temp = "a"
// solve(1, "23", temp, mp);  // recursive call (pauses here)


// \U0001f53d Inside recursion (idx = 1, digit '3', str = "def")

// i = 0 → append 'd' → temp = "ad"
// call solve(2, "23", "ad") → since idx == digits.length(), result = "ad"
// then return → now executes:
// temp.deleteCharAt(temp.length()-1) → removes 'd' → temp = "a"

// i = 1 → append 'e' → temp = "ae"
// recurse → result = "ae"
// return → backtrack → temp = "a"

// i = 2 → append 'f' → temp = "af"
// recurse → result = "af"
// return → backtrack → temp = "a"

// ⏪ Done with all options for '3'.
// Return to the parent call where temp = "a".

// Now the parent finishes its recursive call and executes:

// temp.deleteCharAt(temp.length()-1); // removes 'a'


// So temp = "".

// Iteration i = 1 ('b')

// append 'b' → recurse into next digit → build "bd", "be", "bf".

// after recursion finishes → backtrack → remove 'b'.

// Iteration i = 2 ('c')

// append 'c' → recurse into next digit → build "cd", "ce", "cf".

// after recursion finishes → backtrack → remove 'c'.

// \U0001f4cc So when does deleteCharAt run?

// After each recursive call returns.

// That’s when you “undo” the last choice to try the next letter.

// \U0001f511 Analogy:
// Think of recursion like exploring paths in a maze:

// append() = go forward in one direction.

// solve() = explore deeper.

// When you hit a dead end or finish, recursion returns.

// deleteCharAt() = step back to the last junction, so you can try another path.