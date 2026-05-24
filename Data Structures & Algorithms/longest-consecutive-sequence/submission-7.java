class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            set.add(i);
        }

        int max = 0;
        int seq = 0;
        Iterator<Integer> it = set.iterator();

        while(it.hasNext()) {
            seq = 1;
            int cur = it.next();
            while (set.contains(cur + 1)) {
                seq++;
                cur++;
            }
            if (seq > max) max = seq;
        }

        return max;
    }
}
