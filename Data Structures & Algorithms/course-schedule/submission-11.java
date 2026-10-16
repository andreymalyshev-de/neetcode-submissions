class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int[] i: prerequisites) {
            List<Integer> list = hm.getOrDefault(i[0], new ArrayList<>());
            list.add(i[1]);
            hm.put(i[0], list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!help(hm, i, new HashSet<>())) return false;
        }

        return true;
    }

    private boolean help(HashMap<Integer, List<Integer>> hm, int c, Set<Integer> visited) {
        if (!hm.containsKey(c)) return true; 

        visited.add(c);
        List<Integer> list = hm.get(c);
        for (int i: list) {
            if (visited.contains(i)) return false;
            if (!help(hm, i, visited)) return false;
        }

        visited.remove(c);
        hm.remove(c);

        return true;
    }
}
