class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];

        for (int i = temps.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (temps[j] > temps[i] || res[j] > 0) {

                if (temps[j] > temps[i]) {
                    res[i] = j - i;
                    break;
                }

                else if (res[j] > 0) j += res[j];
                System.out.println(j);
            }
        }
        return res;
    }
}
