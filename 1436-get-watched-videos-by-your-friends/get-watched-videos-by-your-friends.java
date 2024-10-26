class Solution {
    class pair implements Comparable<pair>{
        String video ;
        int freq;

        pair(String video , int freq){
            this.video = video;
            this.freq = freq;
        }

        public int compareTo(pair that){
            if(this.freq == that.freq){
                return this.video.compareTo(that.video);
            }
           return  this.freq - that.freq;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // Bfs
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.offer(id);
        visited.add(id);
        int currentLevel = 0;
      while(!queue.isEmpty()){
        int size = queue.size();
      

    
        // Iterate level by level
        for(int i =0 ; i < size ; i++){
           int  curId = queue.poll();

           for(int friend : friends[curId]){
            if(!visited.contains(friend)){
                visited.add(friend);
                queue.offer(friend);
            }
           }
        }

        currentLevel++;
        if(currentLevel == level){
            break;
        }
      }

      HashMap<String , Integer> freqMap = new HashMap<>();
      while(!queue.isEmpty()){
        int curId = queue.poll();

        for(String video : watchedVideos.get(curId) ){
            freqMap.put(video , freqMap.getOrDefault(video,0)+1);
        }
      }
      List<pair> videoList = new ArrayList<>();
      for(String video : freqMap.keySet()){
        videoList.add(new pair(video , freqMap.get(video)));
      }
      Collections.sort(videoList);
      List<String> res = new ArrayList<>();
      for(pair p : videoList){
          res.add(p . video);
      }
      
    return res;
}
}

