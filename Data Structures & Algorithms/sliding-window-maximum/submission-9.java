class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        // my leftmost element is the biggest one

        int[] arr = new int[nums.length - k + 1];

        int r = 0;
        int l = 0;
        stack.push(Integer.MIN_VALUE);

        for (r = 0; r < k; r++) {
            while (!stack.isEmpty() && stack.peek() < nums[r]) {
                stack.pop();
            }
            stack.push(nums[r]);
        }

        arr[l] = stack.peekLast();

        while (r < nums.length) {
            //System.out.println(Arrays.toString(arr));
            if (nums[l] == stack.peekLast()) {
                stack.removeLast();
            }
            l++;

            while (!stack.isEmpty() && stack.peek() < nums[r]) {
                stack.pop();
            }
            stack.push(nums[r]);
            r++;

            arr[l] = stack.peekLast();
        }

        return arr;
    }
}
