class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] array = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            array[i][0] = position[i];
            array[i][1] = speed[i];
        }
        Arrays.sort(array, (a, b) -> b[0] - a[0]);

        int c = 1;
        double a = (double)(target - array[0][0]) / array[0][1];
        double b = 0;
        for (int i = 1; i < array.length; i++) {
            b = (double)(target - array[i][0]) / array[i][1];
            if (b > a) {
                c++;
                a = b;
            }
        }
        return c;
    }
}
