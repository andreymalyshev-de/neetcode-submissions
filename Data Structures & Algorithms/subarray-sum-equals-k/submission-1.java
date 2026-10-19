class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int r = 0;
        int sum = 0;
        hm.put(sum, 1);
        while (r < nums.length) {
            sum += nums[r];
            int diff = sum - k;
            System.out.println(diff);
            int freq = !hm.containsKey(diff) ? 0 : hm.get(diff);
            cnt += freq;
            r++;
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            System.out.println(cnt);
        }

        return cnt;
    }
}