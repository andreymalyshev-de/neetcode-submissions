class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temps.length; i++) {
            int c = 0;
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
            System.out.println(stack);
        }

        return res;
    }
}
