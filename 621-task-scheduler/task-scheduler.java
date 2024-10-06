class Task implements Comparable<Task>{
    int freq;
    int executionTime;

    Task(int f , int t){
        freq = f;
        executionTime = t;
    }

    @Override
    public int compareTo(Task that) {
        return that.freq - this.freq; // in decreasing order
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqmap = new HashMap<>();
        for (char ch : tasks) {

            freqmap.put(ch, freqmap.getOrDefault(ch, 0) + 1);
        }
        // Insertion in max heap - PQ
        PriorityQueue<Task> pq = new PriorityQueue<>();

        for (Character ch : freqmap.keySet()) {
            int freq = freqmap.get(ch);
            pq.offer(new Task(freq, 0));
        }

        Queue<Task> queue = new LinkedList<>();
        int time = 0;
        while (!queue.isEmpty() || !pq.isEmpty()) {
            time++;
            // check if there is a task in pq and process it

            if (!pq.isEmpty()) {
                Task task = pq.poll();
                task.freq--;
                if (task.freq > 0) {
                    //update the execution time
                    task.executionTime = time + n;
                    queue.offer(task);
                }
            }
            // Shift the active process to the pq
        if (!queue.isEmpty() && queue.peek().executionTime==time) {
  pq.offer(queue.poll());
        }
        }
        // Shift the active process to the pq
//         if (!queue.isEmpty() && queue.peek().executionTime==time) {
//   pq.offer(queue.poll());
       // }
        return time;
    }
}
