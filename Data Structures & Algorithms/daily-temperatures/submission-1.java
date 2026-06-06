class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temps.length; i++) {
            int c = 0;
            while (!stack.isEmpty() && stack.peek() < temps[i]) {
                c++;
                if (temps[i - c] != stack.peek()) continue;
                stack.pop();
                res[i - c] += c;
            }
            stack.push(temps[i]);
            System.out.println(stack);
        }

        return res;
    }
}
