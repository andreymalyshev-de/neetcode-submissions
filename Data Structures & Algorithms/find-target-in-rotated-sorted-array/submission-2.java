class Solution {
    public int search(int[] nums, int target) {
        
        int r = nums.length - 1;
        int l = 0;
        int i = 0;

        while (l <= r) {
            i = l + (r - l) / 2;
            int mid = nums[i];

            if (target < mid) {
                if (target >= nums[l]) {
                    r = i - 1;
                }
                else {
                    if (mid < nums[l]) r = i - 1;
                    else l = i + 1;
                }
            }
            else if (target > mid) {
                if (mid < nums[r]) {
                    if (target <= nums[r]) l = i + 1;
                    else r = i - 1;
                }
                else l = i + 1;
            }
            else return i;
        }
        return -1;
    }
}
