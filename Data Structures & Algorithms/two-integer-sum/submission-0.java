class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c)) {
                int a = map.get(c);
                int b = i;
                if (a < b) return new int[]{a, b};
                else return new int[]{b, a};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
