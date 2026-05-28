class Solution {
    public int trap(int[] height) {
        int w = 0;
        int a = 0;
        int b = height.length - 1;
        int min = 0;
        while (a < b) {
            if (height[a] < height[b]) {
                min = Math.max(min, height[a]);
                a++;
                w += Math.max(0, (min - height[a]));
            }
            else {
                min = Math.max(min, height[b]);
                b--;
                w += Math.max(0, (min - height[b]));
            }
        }
        return w;
    }
}
