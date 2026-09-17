class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> freqMap = new HashMap<>();
        //[string, freq]
        PriorityQueue<Pair> minH = new PriorityQueue<>(
            (a,b) -> {
                if(a.freq != b.freq) return a.freq - b.freq;
                return b.str.compareTo(a.str); //notice reverse order here when same freq
            }
        );
        List<String> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(freqMap.containsKey(words[i])){
                freqMap.put(words[i], freqMap.get(words[i]) + 1);
            }
            else{
                freqMap.put(words[i], 1);
            }
        }
        for(Map.Entry<String, Integer> entry: freqMap.entrySet()){
            minH.offer(new Pair(entry.getKey(), entry.getValue()));
            if(minH.size() > k){  //keeping minheap of size k
                minH.poll();
            }
        }
       // Collections.reverseOrder(minH);
        for(int i=0; i<k; i++){
            String temp = minH.poll().str;
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }
    class Pair{
        String str;
        int freq;
        Pair(String s, int f){
            this.str = s;
            this.freq = f;
        }
    }
}