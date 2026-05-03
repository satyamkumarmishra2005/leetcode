class Solution {
    private List<List<Integer>> graph;
    int []inDegree;
    int []cache;
    private void buildGraph(int n, int [][]relations) {
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int []relation : relations) {
            int from = relation[0] - 1, to = relation[1] - 1;
            inDegree[to] += 1;
            graph.get(from).add(to);
        }
    }

    List<List<Integer>> kCombinations;
    // Generates K combinations for courses
    private void generateKCombinations(int index, List<Integer> courses, int k, List<Integer> buckets) {
        if(k >= courses.size()) { kCombinations.add(new ArrayList<>(courses)); return; }
        if(buckets.size() == k) { kCombinations.add(new ArrayList<>(buckets)); return; }
        
        for(int i = index; i < courses.size(); i += 1) {
            buckets.add(courses.get(i));
            generateKCombinations(i + 1, courses, k, buckets);
            buckets.remove(buckets.size() - 1);
        } 
    }

    private int minNumberOfSemesters(int currentMask, int []inDegree, int n, int k) {
        // Base case: none of the courses are available
        if((currentMask + 1) == (1 << n)) return 0;
        if(cache[currentMask] != -1) return cache[currentMask];
        List<Integer> availableCourses = new ArrayList<>();
        for(int i = 0; i < n; i += 1) {
            // if course is available and inDegree is 0
            if(inDegree[i] == 0 && ((currentMask >> i) & 1) == 0) {  availableCourses.add(i); }
        }
        int minSemesters = Integer.MAX_VALUE;
        kCombinations = new ArrayList<>();
        generateKCombinations(0, availableCourses, k, new ArrayList<>());
        for(List<Integer> combinations : kCombinations) {
            int newMask = currentMask;
            int []newIndegree = new int[n];
            for(int i = 0; i < n; i += 1) { newIndegree[i] = inDegree[i]; }
            for(int combination : combinations) {
                newMask |= (1 << combination);
                for(int child : graph.get(combination)) {
                    newIndegree[child] -= 1;
                }
            }
            minSemesters = Math.min(minSemesters, 1 + minNumberOfSemesters(newMask, newIndegree, n, k));
        }
        return cache[currentMask] = minSemesters;
    }



    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        graph = new ArrayList<>();
        inDegree = new int[n];
        cache = new int[1 << n];
        Arrays.fill(cache, -1);
        buildGraph(n, relations);
        int currentMask = 0; // 0 => all courses are available
        return minNumberOfSemesters(currentMask, inDegree, n, k);
    }
}