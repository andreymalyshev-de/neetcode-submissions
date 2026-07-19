class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0; //end
        int min = Integer.MAX_VALUE; //start
        for (int[] i: intervals) {
            max = Math.max(max, i[0]);
        }

        int[] help = new int[max + 1];
        for (int[] i: intervals) {
            if (help[i[0]] < i[1]) help[i[0]] = i[1];
            if (i[0] < min) min = i[0];
        }

        int[] cur = new int[]{min, min};
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < max + 1; i++) {
            if (help[i] != 0) {
                System.out.println(i + " " + help[i]);
                int end = help[i];
                if (cur[1] < i) {
                    list.add(cur);
                    cur = new int[]{i, end};
                }
                if (cur[1] < end) cur[1] = end;
                if (i == max) list.add(cur);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
