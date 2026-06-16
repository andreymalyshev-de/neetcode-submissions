class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (true) {
            int v = nums[i];
            if (v == -1) return i;
            nums[i] = -1;
            i = v;
        }
    } 
}
