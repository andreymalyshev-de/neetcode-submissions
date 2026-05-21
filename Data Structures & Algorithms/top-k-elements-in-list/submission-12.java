class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int i: nums) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        HashMap<Integer, Set<Integer>> map2 = new HashMap<>();

        for (int i: nums) {
            int f = map1.get(i);
            if (map2.containsKey(f)) {
                Set<Integer> s = map2.get(f);
                s.add(i);
                map2.put(f, s);
            }
            else {
                Set<Integer> s = new HashSet<>();
                s.add(i);
                map2.put(f, s);
            }
        }

        int c = k - 1;
        int[] top = new int[k];

        for (int i = nums.length; i >= 0; i--) {
            if (map2.containsKey(i)) {
                Set<Integer> s = map2.get(i);
                Iterator<Integer> it = s.iterator();
                while (it.hasNext()) {
                    top[c] = it.next();
                    c--;
                    if (c < 0) return top;
                }
            }
        }
        return top;
    }
}
