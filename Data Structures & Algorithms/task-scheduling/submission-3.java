class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnts = new int[26];
        for (char c: tasks) {
            cnts[90 - c]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i: cnts) {
            if (i > 0) pq.add(i);
        }

        int res = 0;
        int ctr = 0;
        Queue<Integer> q = new LinkedList<>();
        while (pq.size() > 0) {
            ctr = 0;
            while (pq.size() > 0 && ctr <= n) {
                ctr++;
                int cur = pq.poll() - 1;
                if (cur > 0) q.add(cur);
            }

            if (q.size() > 0 && ctr <= n) ctr += (n - ctr + 1);
            res += ctr;

            while (!q.isEmpty()) {
                pq.add(q.poll());
            }
        } 
    

        return res;
    }
}
