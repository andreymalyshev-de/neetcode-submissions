class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> window = new PriorityQueue<>(Comparator.reverseOrder());
        int[] arr = new int[nums.length - k + 1];

        int r = 0;
        int l = 0;
        int max = Integer.MIN_VALUE;

        for (r = 0; r < k; r++) {
            window.add(nums[r]);
        }

        arr[l] = window.peek();

        while (r < nums.length) {
            window.remove(nums[l]);
            window.add(nums[r]);
            l++;
            r++;
            arr[l] = window.peek();
        }

        return arr;
        
    }
}
