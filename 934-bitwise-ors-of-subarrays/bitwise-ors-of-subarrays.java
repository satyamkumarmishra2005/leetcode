import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();

        for (int x : arr) {
            Set<Integer> next = new HashSet<>();
            
            next.add(x);  // start new subarray
            
            for (int val : curr) {
                next.add(val | x);  // extend previous
            }
            
            curr = next;
            res.addAll(curr);
        }
        
        return res.size();
    }
}