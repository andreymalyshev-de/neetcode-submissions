class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>
        (Comparator.comparingDouble((int[] x) -> x[0]*x[0] + x[1]*x[1]).reversed());
        
        for (int[] i: points) {
            if (q.size() < k) q.add(i);
            else {
                double a = Math.sqrt(i[0]*i[0] + i[1]*i[1]);
                int[] x = q.peek();
                double b = Math.sqrt(x[0]*x[0] + x[1]*x[1]);
                if (a < b) {
                    q.poll();
                    q.add(i);
                }
            }
        }
        
        int[][] res = new int[k][2];
        
        while (k > 0) {
            k--;
            res[k] = q.poll();
        }

        return res;
    }
}
