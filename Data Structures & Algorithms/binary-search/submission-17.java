class Solution {
    public int search(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;
        int i = 0;

        while (l <= r) {
            i = l + (r - l) / 2;

            if (nums[i] == target) return i;
            else if (nums[i] > target) {
                r = i - 1;
            }
            else l = i + 1;
        }

        return -1;
    }
}
