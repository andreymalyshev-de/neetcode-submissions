class Solution {
    public int search(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;
        int i = r / 2;
        int c = 0;
        while (i >= 0 && i < nums.length && c < 100) {
            System.out.println(i);
            c++;
            if (nums[i] == target) return i;
            else if (nums[i] > target) {
                if (i == 0 || nums[i - 1] < target) return -1;
                r = i;
                i /= 2;
            }
            else {
                //System.out.println(nums[i]);
                if (i == nums.length - 1 || nums[i + 1] > target) {
                    return -1;
                }
                l = i;
                i = (int)((r - l) * 0.5) > 0 ? i + (int)((r - l) * 0.5) : i + 1;
                System.out.println(i);
            }
        }

        return -1;
    }
}
