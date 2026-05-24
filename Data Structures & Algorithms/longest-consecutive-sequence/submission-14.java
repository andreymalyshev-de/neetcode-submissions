class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            set.add(i);
        }

        int max = 0;
        int seq = 0;
        Iterator<Integer> it = set.iterator();
        Set<Integer> cset = new HashSet<>();

        while(it.hasNext()) {
            seq = 1;
            int cur = it.next();
            if (!cset.contains(cur)) {
                int temp = cur;
                while (set.contains(cur + 1)) {
                    cset.add(cur);
                    seq++;
                    cur++;
                }
                cset.add(cur);
                while (set.contains(temp - 1)) {
                    cset.add(temp);
                    seq++;
                    temp--;
                }
                cset.add(temp);
            }
            if (seq > max) max = seq;
        }

        return max;
    }
}
