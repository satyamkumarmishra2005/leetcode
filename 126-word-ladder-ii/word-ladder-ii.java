class Solution {

    private int getCharDifference(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return new ArrayList<>();
        
         if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
         }

        int n = wordList.size();
        Map<String, List<String>> adj = new HashMap<>();
        
        // Build adjacency list
        for (String word : wordList) {
            adj.put(word, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (getCharDifference(wordList.get(i), wordList.get(j)) == 1) {
                    adj.get(wordList.get(i)).add(wordList.get(j));
                    adj.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        List<List<String>> ansList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        int shortestDistance = bfsForShortestPathCost(adj, beginWord, endWord, map);
        List<String> list = new ArrayList<>();
        list.add(endWord);
        endToStartDFS(adj, beginWord, endWord, map, list, ansList);

        return ansList;

    }

    private void endToStartDFS(Map<String, List<String>> adj, String src, String node, HashMap<String, Integer> map, List<String> list, List<List<String>> ansList){// node = start node which is destination node
        if(node.equals(src)){
            ansList.add(new ArrayList<>(list));
        }

// System.out.println(node);

        for(String neigh: adj.get(node)){
            if(map.containsKey(neigh) && map.get(neigh)<map.get(node)){
                list.add(0,neigh);
                endToStartDFS(adj, src, neigh, map, list, ansList);
                list.remove(0);
            }
        } 
    }



    private int bfsForShortestPathCost(Map<String, List<String>> adj, String src, String dest, HashMap<String, Integer> map) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();
        
        queue.add(src);
        dist.put(src, 1);
        map.put(src, 1);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDist = dist.get(current);

            if (current.equals(dest)) {
                return currentDist;
            }

            for (String neighbor : adj.get(current)) {
                if (!dist.containsKey(neighbor)) {
                    dist.put(neighbor, currentDist + 1);
                    queue.add(neighbor);
                    map.put(neighbor, currentDist + 1);
                }
            }
        }

        return 0;
    }

}