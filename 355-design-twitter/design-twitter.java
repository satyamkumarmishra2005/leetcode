class Tweet implements Comparable<Tweet>{
    int time ;
    int tweetId;
    Tweet(int t, int id){
        time = t;
        tweetId = id;
    }
       
    
    public int compareTo(Tweet that){
        return that.time - this.time ;// dec order most recent tweet
    }
}

class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;
    User(int userId){
        this.userId = userId;
        followers = new HashSet<>();
        tweets = new LinkedList<>();  
    }
    public void addTweet(Tweet t){
        tweets.add(0,t); // Insertion at head
    }
    public void addFollower(int followeeId){
        followers.add(followeeId);
    }
     public void removeFollower(int followeeId){
        followers.remove(followeeId);
    }
}

class Twitter {
HashMap<Integer , User> userMap;
int timeCounter;
    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter , tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
          if(!userMap.containsKey(userId)) {
            return new ArrayList<>() ;
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        // add self tweets + followers tweets
        User user = userMap.get(userId);

       for(int followerId : user.followers){
        int count = 0;
        for(Tweet tweet : userMap.get(followerId).tweets){
            pq.offer(tweet);
            count++;
            if(count>10){
                break;
            }
        }
       }
       int count = 0;
        for(Tweet tweet : user.tweets){
            pq.offer(tweet);
            count++;
            if(count>10){
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty() && index<10){
          Tweet tweet =  pq.poll();
          res.add(tweet.tweetId);
            index++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
         if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
         if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }

        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
            return ;
        }
         User user = userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */