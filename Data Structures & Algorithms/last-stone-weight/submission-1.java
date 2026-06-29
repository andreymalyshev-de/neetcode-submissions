class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i: stones) {
            q.add(i);
        }

        while(q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            if (a < b) {
                q.add(b - a);
            }
            else if (a > b) {
                q.add(a - b);
            }
        }

        return q.size() == 0 ? 0 : q.poll();
    }
}
