class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] top = new int[k];
        HashMap<Integer, Integer> ks = new HashMap<>();
        for (int i = k - 1; i >= 0; i--) {
            int max = 0;
            for (int j: nums) {
                if (!ks.containsValue(j)) {
                    max = j;
                    break;
                }
            }
            for (int j: nums) {
                if (!ks.containsValue(j) && (map.get(j) > map.get(max))) max = j;
            }
            top[i] = max;
            ks.put(i, max);
        }
        return top;
    }
}
