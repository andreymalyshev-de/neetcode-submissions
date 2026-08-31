class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int[] req: prerequisites) {
            List<Integer> l = hm.getOrDefault(req[0], new ArrayList<>());
            l.add(req[1]);
            hm.put(req[0], l);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!help(hm, new HashSet<Integer>(), i)) return false;
        }

        return true;
    }

    private boolean help(HashMap<Integer, List<Integer>> hm, Set<Integer> set, int i) {
        if (set.contains(i)) return false;
        if (!hm.containsKey(i)) return true;

        set.add(i);
        List<Integer> list = hm.get(i);
        while(list.size() != 0) {
            int a = list.get(0); // perhaps a queue here
            if (help(hm, set, a)) {
                list.remove(0);
                set.remove(a);
            }
            else return false;
        }
        set.remove(i);

        return true;
    }
}
