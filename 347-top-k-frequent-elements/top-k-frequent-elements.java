   class Number implements Comparable<Number> {
    int element;
    int frequency;

    Number(int element , int frequency){
        this.element = element;
        this.frequency = frequency;
    }

    public int compareTo(Number that){
        // max heap
        return that.frequency - this.frequency ;//dec
    }
}

class Solution {
 
    public int[] topKFrequent(int[] nums, int k) {
           PriorityQueue<Number> queque = new PriorityQueue<>();
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        // find freq of all elements
        for (int element : nums) {
            freqMap.put(element,freqMap.getOrDefault(element,0)+1);

        }
        // insert element in queque
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            Number number = new Number(entry.getKey() , entry.getValue());
            queque.offer(number);
        }
      int result[] = new int[k];
        int index = 0;
        while(index<k){
            Number number = queque.poll();
            result[index] = number.element;
            index++;
        }
        return result;
        
    }
}