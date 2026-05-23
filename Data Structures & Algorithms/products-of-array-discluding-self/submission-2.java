class Solution {
    public int[] productExceptSelf(int[] nums) {
        int c = nums.length - 1;
        int[] a1 = new int[c];
        int[] a2 = new int[c];
        int ctr = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            ctr*=nums[i];
            a1[i] = ctr;
        }
        System.out.println(Arrays.toString(a1));
        // a1 = [a; ab; abc] -- a2 = [dbc; dc; d]
        ctr = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            ctr *= nums[i];
            a2[i - 1] = ctr;
        }
        System.out.println(Arrays.toString(a2));
    
        int[] res = new int[c + 1];
        int a = 0;
        int b = 0;
        int i = 0;

        while(a < c || b < 0) {
            if (b == 0) {
                res[i] = a2[b];
                i++;
                b++;
            }
            else if (a == c - 1) {
                res[i] = a1[a];
                a++;
                i++;
            }
            else {
                res[i] = a1[a] * a2[b];
                a++;
                b++;
                i++;
            }
        }
        return res;
    }
}  
