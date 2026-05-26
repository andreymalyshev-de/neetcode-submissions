class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Set<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int u = j + 1; u < nums.length; u++) {
                    if (nums[i] + nums[j] + nums[u] == 0) {
                        Set<Integer> s = new HashSet<>();
                        System.out.println("i: " + nums[i] + " j: " + nums[j] + " u: " + nums[u]);
                        s.add(nums[i]); s.add(nums[j]); s.add(nums[u]);
                        set.add(s);
                    }
                }
            }
        }

        Iterator<Set<Integer>> it = set.iterator();
        List<List<Integer>> list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(new ArrayList<>(it.next()));
            if (list.get(list.size() - 1).size() < 3) {
                List<Integer> l = list.get(list.size() - 1);
                if (l.get(0) == 0) {
                    l.add(0); l.add(0);
                }
                else {
                    l.add(0 - l.get(0) - l.get(1));
                }
            }
        }

        return list;
    }
}
