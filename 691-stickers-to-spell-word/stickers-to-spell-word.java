class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;

        target = sortChars(target);
        for (int i = 0; i < n; ++i) stickers[i] = sortChars(stickers[i]);

        Queue<String> q = new LinkedList();
        q.offer(target);
        int steps = 0;
        Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            while(size-- > 0) {
                String x = q.poll();
                for (int i = 0; i < n; ++i) {
                    String now = filter(x, stickers[i]);
                    if (now.isEmpty()) return steps;
                    if (!now.equals(x) && !visited.contains(now)) {
                        visited.add(now);
                        q.offer(now);
                    }
                }
            }
        }
        return -1;
    }
    public String filter(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int idx = 0;

        for (char c : a.toCharArray()) {
            boolean found = false;
            while (idx < b.length() && b.charAt(idx) <= c) {
                if (b.charAt(idx++) == c) {
                    found = true;
                    break;
                }
            }
            if (!found) ret.append(c);
        }
        return ret.toString();
    }
    private String sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
