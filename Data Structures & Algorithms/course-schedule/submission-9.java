class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Queue<Integer>> hm = new HashMap<>();

        for (int[] req: prerequisites) {
            Queue<Integer> l = hm.getOrDefault(req[0], new LinkedList<>());
            l.add(req[1]);
            hm.put(req[0], l);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!help(hm, new HashSet<Integer>(), i)) return false;
        }

        return true;
    }

    private boolean help(HashMap<Integer, Queue<Integer>> hm, Set<Integer> set, int i) {
        if (set.contains(i)) return false;
        if (!hm.containsKey(i)) return true;

        set.add(i);
        Queue<Integer> list = hm.get(i);
        while(list.size() != 0) {
            int a = list.poll(); // perhaps a queue here
            if (!help(hm, set, a)) {
                return false;
            }
        }
        set.remove(i);

        return true;
    }
}
