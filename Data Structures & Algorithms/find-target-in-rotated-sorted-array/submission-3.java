class Solution {
    public int search(int[] nums, int target) {
        // clearer reasoning
        int r = nums.length - 1;
        int l = 0;
        int i = 0;

        while (l <= r) {
            i = l + (r - l) / 2;
            int mid = nums[i];

            if (target == mid) return i;
            else if (mid < nums[r]) { // right half is sorted
                if (target > mid && target <= nums[r]) {
                    l = i + 1;
                }
                else r = i - 1;
            }
            else {
                if (target >= nums[l] && target < mid) r = i - 1;
                else l = i + 1;
            }
        }
        return -1;
    }
}
