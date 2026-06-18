class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0; 
        int fast = 0;

        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                // p + mc - x = p + kc - x
                // p - distance from beginning till cycle entry
                // c - cycle length
                // 0 < m < k - numbers of cycles that slow/fast goes before meeting fast/slow
                // x - distance from the meeting point till the cycle entry 
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) return slow; 
        }
    } 
}
