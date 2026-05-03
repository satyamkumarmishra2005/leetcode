class Solution {
    public int minOperations(List<Integer> nums, int target) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        
        if (sum < target) {
            return -1;
        } else if (sum == target) {
            return 0;
        }
        
        TreeMap<Integer, Integer> freqs = new TreeMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num , 0) + 1);
        }
        
        int ops = 0;
        for (int i = 0, pow = 1; i < 32 && pow < max && target > 0; i++, pow *= 2) {
            boolean need = (((target >> i) & 1) == 1);
            
            if (need) {
                target -= pow;
                
                if (freqs.containsKey(pow)) {
                    int freq = freqs.remove(pow);
                    if (freq > 1) {
                        freqs.put(pow, freq - 1);
                    }
                } else {
                    int key = freqs.ceilingKey(pow);
                    int freq = freqs.remove(key);
                    if (freq > 1) {
                        freqs.put(key, freq - 1);
                    }
                    
                    while (key != pow) {
                        ops++;
                        key /= 2;
                        freqs.put(key, freqs.getOrDefault(key , 0) + 1);
                    }
                }
            }
            
            for (int x = 1; x <= pow; x *= 2) {
                if (freqs.getOrDefault(x, 0) > 1) {
                    int f = freqs.get(x);
                    freqs.put(x * 2, freqs.getOrDefault(x * 2, 0) + f / 2);
                    freqs.put(x, 1);
                }
            }
            
        }
        
        return ops;
    }
}