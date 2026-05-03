class Solution {
    int n; // n questions
    int m; // m students/m mentors
    int[] dp;
    int[][] students;
    int[][] mentors;

    int solve(int mask) {
        int index = Integer.bitCount(mask);
        if (index == m) 
            // we already assigned a mentor to each student
            return 0;
        if (dp[mask] != -1) 
            return dp[mask];
        
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (((mask >> i) & 1) == 0) {
                // unvisited
                int score = 0;
                for (int j = 0; j < n; j++) {
                    if (students[index][j] == mentors[i][j])
                        score++;
                }
                int newMask = mask | (1 << i); // mark as visited
                score += solve(newMask);
                maxScore = Math.max(score, maxScore);
            }
        }

        return dp[mask] = maxScore;
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        n = students[0].length;
        m = students.length;    
        // our goal is to assign a mentor to each student.
        dp = new int[(1 << m)];
        Arrays.fill(dp, -1);
        this.students = students;
        this.mentors = mentors;
        return solve(0);        
   }
}