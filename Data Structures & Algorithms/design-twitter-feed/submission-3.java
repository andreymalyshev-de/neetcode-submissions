class Twitter {

    private HashMap<Integer, Set<Integer>> follows;
    private HashMap<Integer, List<int[]>> tweets;
    private int ctr;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        ctr = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        ctr++;
        List<int[]> l = tweets.getOrDefault(userId, new ArrayList<>());
        l.add(new int[]{tweetId, ctr});
        tweets.put(userId, l);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] x) -> x[1]));
        List<int[]> l = tweets.containsKey(userId) ? tweets.get(userId) : null;
        if (l != null) {
            for (int[] i: l) {
                if (pq.size() < 10) {
                    pq.add(i);
                }
                else {
                    if (i[1] > pq.peek()[1]) {
                        pq.poll();
                        pq.add(i);
                    }
                }
            }
        }
        
        Set<Integer> set = follows.containsKey(userId) ? follows.get(userId) : null;
        if (set != null) {
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                l = tweets.get(it.next());
                for (int[] i: l) {
                    if (pq.size() < 10) {
                        pq.add(i);
                    }
                    else {
                        if (i[1] > pq.peek()[1]) {
                            pq.poll();
                            pq.add(i);
                        }
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[0]);
        }
        for (int i = res.size() - 1; i >= res.size() / 2; i--) {
            int tmp = res.get(i);
            res.set(i, res.get(res.size() - 1 - i));
            res.set(res.size() - 1 - i, tmp);
        }

        return res;

    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> l = follows.getOrDefault(followerId, new HashSet<>());
        l.add(followeeId);
        follows.put(followerId, l);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> l = follows.get(followerId);
        l.remove(followeeId);
        follows.put(followerId, l);
    }
}
