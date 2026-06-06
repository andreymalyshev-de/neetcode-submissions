class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // if the car with smaller position meets the target >= faster then it is a fleet
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Deque<double[]> stack = new ArrayDeque<>();

        for (int i = 0; i < position.length; i++) {
            queue.add(new int[]{position[i], speed[i]});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            double a = ((double)(target - cur[0]) / cur[1]);

            while (!stack.isEmpty() && (stack.peek()[1] <= a || stack.peek()[0] == cur[0])) {
                System.out.println("-");
                System.out.println(stack.peek()[1]);
                System.out.println(stack.peek()[0] == cur[0]);
                System.out.println("-");
                stack.pop();
            }

            stack.push(new double[]{cur[0], a});
            System.out.println(cur[0] + " " + a);
            System.out.println(stack.size());
        }

        //System.out.println(Math.ceil((double)(10 - 6) / 3));

        return stack.size();
    }
}
