class Solution {
    private HashMap<Integer, List<Integer>> hm;

    public int countComponents(int n, int[][] edges) {
        hm = new HashMap<>();
        for (int[] i: edges) {
            List<Integer> list = hm.getOrDefault(i[0], new ArrayList<>());
            list.add(i[1]);
            hm.put(i[0], list);
            list = hm.getOrDefault(i[1], new ArrayList<>());
            list.add(i[0]);
            hm.put(i[1], list);
        }

        int c = n - hm.size();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(i)) continue;
            help(i, new HashSet<Integer>());
            c++;
        }

        return c;
    }

    private void help(int n, Set<Integer> visited) {
        List<Integer> list = hm.getOrDefault(n, new ArrayList<>());
        visited.add(n);
        for (int i: list) {
            if (!visited.contains(i)) help(i, visited);
        }
        hm.remove(n);
    }
}
