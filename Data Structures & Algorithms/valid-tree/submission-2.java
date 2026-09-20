class Solution {
    private HashMap<Integer, List<Integer>> hm;

    public boolean validTree(int n, int[][] edges) {
        hm = new HashMap<>();

        for (int[] a: edges) {
            List<Integer> set = hm.getOrDefault(a[0], new ArrayList<Integer>());
            set.add(a[1]);
            hm.put(a[0], set);
            set = hm.getOrDefault(a[1], new ArrayList<Integer>());
            set.add(a[0]);
            hm.put(a[1], set);
            System.out.println(hm.get(0));
        }

        boolean flag = help(0, new HashSet<Integer>(), 0);

        return hm.isEmpty() ? flag : false;
    }

    private boolean help(int n, Set<Integer> visited, int pr) {
        System.out.println(n);
        if (visited.contains(n)) return false;
        visited.add(n);
        if (!hm.containsKey(n)) return true;

        List<Integer> list = hm.get(n);

        for (int i: list) {
            if (i == pr) continue;
            if (!help(i, visited, n)) return false;
        }
        hm.remove(n);

        return true;
    }
}
