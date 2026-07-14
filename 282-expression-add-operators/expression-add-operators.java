class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        dfs(num, target, 0, "", 0, 0);

        return ans;
    }

    private void dfs(String num,
                     int target,
                     int index,
                     String path,
                     long value,
                     long prev) {

        // Entire string used
        if (index == num.length()) {

            if (value == target) {
                ans.add(path);
            }

            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Skip numbers with leading zeros
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            String currStr = num.substring(index, i + 1);
            long curr = Long.parseLong(currStr);

            // First number
            if (index == 0) {

                dfs(num,
                    target,
                    i + 1,
                    currStr,
                    curr,
                    curr);

            } else {

                // +

                dfs(num,
                    target,
                    i + 1,
                    path + "+" + currStr,
                    value + curr,
                    curr);

                // -

                dfs(num,
                    target,
                    i + 1,
                    path + "-" + currStr,
                    value - curr,
                    -curr);

                // *

                dfs(num,
                    target,
                    i + 1,
                    path + "*" + currStr,
                    value - prev + prev * curr,
                    prev * curr);
            }
        }
    }
}