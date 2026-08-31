class Solution {
    private List<Integer> res;
    private Set<Integer> visited;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Queue<Integer>> hm = new HashMap<>();
        for (int[] req: prerequisites) {
            Queue<Integer> list = hm.getOrDefault(req[0], new LinkedList<>());
            list.add(req[1]);
            hm.put(req[0], list);
        }

        res = new ArrayList<>();
        visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!help(hm, new HashSet<>(), i)) return new int[]{};
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean help(HashMap<Integer, Queue<Integer>> hm, Set<Integer> set, int i) {

        if (set.contains(i)) return false;
        if (!hm.containsKey(i)) {
            if (visited.contains(i)) return true;
            visited.add(i);
            res.add(i);
            return true;
        }

        set.add(i);
        Queue<Integer> list = hm.get(i);
        while(!list.isEmpty()) {
            int a = list.poll();
            if (!help(hm, set, a)) return false;
        }
        set.remove(i);

        if (visited.contains(i)) return true;
        visited.add(i);
        res.add(i);
        return true;
    }
}
