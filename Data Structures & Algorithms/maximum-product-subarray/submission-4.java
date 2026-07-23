class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int cmax = nums[0];
        int cmin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n == 1) {
                if (cmax < n) cmax = n;
            }
            else {
                if (cmin * n < cmin) {
                    if (cmax * n > cmax) cmax = cmax * n;
                    else cmax = n;
                    cmin = cmin * n;
                }
                else {
                    if (cmin * n > cmax) {
                        int tmp = cmax;
                        cmax = cmin * n;
                        if (n > tmp * n) cmin = tmp * n;
                        else cmin = n;
                    }
                    else {
                        int tmp = cmax;
                        if (cmax * n > cmax) cmax = cmax * n;
                        else {
                            if (cmin * n > n) cmax = cmin * n;
                            else cmax = n;
                        }
                        if (n > tmp * n) cmin = tmp * n;
                        else cmin = n;
                    }
                }
            }
            if (cmax > max) max = cmax;
            System.out.println("n: " + n + " cmax: " + cmax + " cmin: " + cmin);
        }

        return max;
    }
}
