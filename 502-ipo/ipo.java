class Project implements Comparable<Project>{
    int profit;
    int capital;

    Project(int profit , int capital){
        this.profit = profit;
        this.capital = capital;
    }

    public int compareTo(Project that){
        return this.capital - that.capital ; // inc capital 
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minpq = new PriorityQueue<>();
        int n = capital.length;
        // insert project in minpq
        for(int i =0 ; i<n ; i++){
            minpq.offer(new Project(profits[i], capital[i]));
        }
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        while(k >0){
            // find all project whose capital is less than equal<=w
            while(!minpq.isEmpty() && minpq.peek().capital <= w){
                maxpq.offer(minpq.poll().profit);
            }

            if(maxpq.isEmpty()) break;
            
            w+=maxpq.poll();
            k--;
        }
        return w;
    }
}