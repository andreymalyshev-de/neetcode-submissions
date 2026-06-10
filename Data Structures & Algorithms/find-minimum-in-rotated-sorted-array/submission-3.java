class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;

        while (l < r) {
            i = l + (r - l) / 2;

            int mid = nums[i];
            int rc = nums[r];
            int lc = nums[l];

            if (mid > rc) {
                l = i + 1;
            }
            else {
                r = i;
            }
            System.out.println(mid);
        }

        return nums[l];
    }
}
