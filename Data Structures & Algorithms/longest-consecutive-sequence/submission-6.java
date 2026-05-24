class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new TreeSet<>();
        for (int i: nums) {
            set.add(i);
        }
        
        TreeSet<Integer> seqs = new TreeSet<>();
        Iterator<Integer> it = set.iterator();
        int seq = 0;
        int prev = 0;
        boolean flag = false;

        while(it.hasNext()) {
            int cur = it.next();
            System.out.println(cur);
            if (!flag) {
                prev = cur;
                flag = true;
                seq++;
            }
            else if (prev == cur - 1) {
                seq++;
                prev = cur;
            }
            else {
                seqs.add(seq);
                seq = 1;
                prev = cur;
            }
        }

        seqs.add(seq);

        int length = seqs.last();

        return length;
    }
}
