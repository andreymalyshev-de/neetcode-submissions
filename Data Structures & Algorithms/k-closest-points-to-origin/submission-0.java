class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingDouble((int[] x) -> Math.sqrt(x[0]*x[0] + x[1]*x[1])));
        for (int[] i: points) {
            q.add(i);
        }
        int[][] res = new int[k][2];
        while (k > 0) {
            k--;
            res[k] = q.poll();
        }

        return res;
    }
}
