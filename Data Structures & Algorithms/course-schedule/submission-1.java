class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> hm = new HashMap<>();
        for (int[] rel: prerequisites) {
            int b = rel[1];
            int a = rel[0];
            if (a == b) return false;
            if (hm.containsKey(a)) {
                if (!help(hm, a, b)) return false;
                else {
                    if (hm.containsKey(b)) {
                        Set<Integer> set = hm.get(b);
                        set.add(a);
                        hm.put(b, set);
                    }
                    else {
                        Set<Integer> set = new HashSet<>();
                        set.add(a);
                        hm.put(b, set);
                    }
                }
            }
            else {
                if (hm.containsKey(b)) {
                        Set<Integer> set = hm.get(b);
                        set.add(a);
                        hm.put(b, set);
                    }
                else {
                    Set<Integer> set = new HashSet<>();
                    set.add(a);
                    hm.put(b, set);
                }
            }
        }
        return true;
    }

    private boolean help(HashMap<Integer, Set<Integer>> hm, int a, int b) {
        Set<Integer> set = hm.get(a);
        if (set.contains(b)) return false;

        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            int c = it.next();
            if (hm.containsKey(c)) {
                if (!help(hm, c, b)) return false;
            }
        }

        return true;
    }
}
