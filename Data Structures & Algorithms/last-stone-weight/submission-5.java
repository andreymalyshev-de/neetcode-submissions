class Solution {
    public int lastStoneWeight(int[] stones) {
        int max = 0;
        for (int i: stones) {
            if (i > max) max = i;
        }

        int[] nums = new int[max + 1];
        for (int i: stones) {
            nums[i]++;    
        }

        int a = -1;
        int b = -1;
        for (int i = max; i > 0; i--) {
            while (nums[i] != 0) {
                if (a < 0) {
                    a = i;
                    nums[i]--;
                }
                else if (b < 0) {
                    b = i;
                    nums[i]--;
                }

                if (a > 0 && b > 0) {
                    if (a > b) {
                        nums[a - b]++;
                    }
                    else if (a < b) {
                        nums[b - a]++;
                    }
                    i = a;
                    a = -1;
                    b = -1;
                }
            }
        }

        return a < 0 ? 0 : a;
    }
}
