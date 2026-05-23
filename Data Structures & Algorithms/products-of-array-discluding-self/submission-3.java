class Solution {
    public int[] productExceptSelf(int[] nums) {
        int c = nums.length - 1;
        int[] res = new int[c + 1];
        Arrays.fill(res, 1);
        int ctr = 1;

        // System.out.println(Arrays.toString(a1));
        // a1 = [a; ab; abc] -- a2 = [dbc; dc; d]
        for (int i = nums.length - 1; i > 0; i--) {
            ctr *= nums[i];
            res[i - 1] *= ctr;
        }
        System.out.println(Arrays.toString(res));
        ctr = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            ctr*=nums[i];
            res[i + 1] *= ctr;
        }
        //System.out.println(Arrays.toString(a2));

        return res;
    }
}  
