class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] x) -> x[0]));
        List<int[]> list = new ArrayList<>();

        for (int[] i: intervals) {
            pq.add(i);
        }
        
        int[] cur = new int[]{pq.peek()[0], pq.peek()[0]};
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (tmp[0] <= cur[1]) {
                if (tmp[1] > cur[1]) cur[1] = tmp[1];
                if (pq.isEmpty()) list.add(cur);
            }
            else {
                list.add(cur);
                cur = tmp;
                if (pq.isEmpty()) list.add(cur);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
