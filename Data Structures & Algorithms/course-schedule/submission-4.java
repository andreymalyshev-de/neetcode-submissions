class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            hm.put(i, new ArrayList<>());
        }

        for (int[] prq: prerequisites) {
            hm.get(prq[1]).add(prq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            if (!help(hm, visited, i)) return false;
        }

        return true;
    }

    private boolean help(HashMap<Integer, List<Integer>> hm, Set<Integer> visited, int i) {
        if (hm.get(i).isEmpty()) return true;
        //System.out.println(i);
        if (visited.contains(i)) return false;

        visited.add(i);
        for (int j: hm.get(i)) {
            if (!help(hm, visited, j)) return false;
        }

        return true;
    }
}
