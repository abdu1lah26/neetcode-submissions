class Twitter {

    int time;

    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, List<Tweet>> usertweets;
    Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        time = 0;
        usertweets = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {

        usertweets.putIfAbsent(userId, new ArrayList<>());

        usertweets.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {

        List<Tweet> feed = new ArrayList<>();

        if(usertweets.containsKey(userId)) {
            feed.addAll(usertweets.get(userId));
        }

        if(followMap.containsKey(userId)) {

            for(int followeeid : followMap.get(userId)) {

                if(usertweets.containsKey(followeeid) && followeeid != userId) {
                    feed.addAll(usertweets.get(followeeid));
                }
            }
        }

        Collections.sort(feed, (a, b) -> b.time - a.time);

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < Math.min(10, feed.size()); i++) {
            ans.add(feed.get(i).id);
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}