class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        // Sort tasks in descending order to prioritize longer tasks
        Arrays.sort(tasks);
        reverse(tasks);

        int left = 1; // Minimum session count
        int right = tasks.length; // Maximum session count
        int answer = 0; // Minimum number of sessions required

        // Binary search on the range of possible session counts
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] workSessions = new int[mid]; // Array to track tasks assigned to each session

            // Check if it's possible to complete all tasks within the given session count
            if (isPossible(0, mid, sessionTime, 0, tasks, workSessions, mid)) {
                answer = mid; // Update the answer
                right = mid - 1; // Continue searching for a smaller session count
            } else {
                left = mid + 1; // Increase the session count
            }
        }

        return answer;
    }

    // Backtracking function to simulate the distribution of tasks among sessions
    private static boolean isPossible(int idx, int k, int maxLen, int max, int[] tasks, int[] workSessions, int zeroCount) {
        if (tasks.length - idx < zeroCount) {
            return false; // Not enough tasks remaining to fill all sessions
        }

        if (idx == tasks.length) {
            if (max > maxLen) {
                return false; // Current session duration exceeds the maximum session time
            }
            return true; // All tasks have been assigned to sessions successfully
        }

        int currentTask = tasks[idx];

        for (int i = 0; i < k; i++) {
            if (workSessions[i] + currentTask > maxLen) {
                continue; // Current task cannot be assigned to this session
            }

            zeroCount -= workSessions[i] == 0 ? 1 : 0; // Decrement zeroCount if a session becomes non-empty
            workSessions[i] += currentTask; // Assign the task to the current session

            // Recursively check if it's possible to complete remaining tasks with the updated sessions
            if (isPossible(idx + 1, k, maxLen, Math.max(max, workSessions[i]), tasks, workSessions, zeroCount)) {
                return true; // Tasks can be completed with the current distribution of sessions
            }

            workSessions[i] -= currentTask; // Backtrack: Remove the task from the current session
            zeroCount += workSessions[i] == 0 ? 1 : 0; // Increment zeroCount if a session becomes empty again

            if (workSessions[i] == 0) {
                break; // Skip empty sessions to avoid redundant iterations
            }
        }

        return false; // Unable to complete all tasks with the current distribution of sessions
    }

    // Utility function to reverse an array
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}