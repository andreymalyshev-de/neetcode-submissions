class Solution {
    public int trap(int[] height) {

        List<Integer> list = new ArrayList<>(Arrays.stream(height).boxed().toList());

        int i = 0;
        while(i < list.size() - 2 && list.get(i) < list.get(i + 1)) {
            list.remove(i);
        }

        if (list.size() < 3) return 0;

        i = list.size() - 1;
        while(i != 0 && list.get(i) < list.get(i - 1)) {
            list.remove(i);
            i--;
        }

        int w = 0;
        int min = 0;
        for (int h: list) { // saved water - the difference in height between this h and the pr min h * distance
            if (min < h) min = h;
            w += (min - h);
        }
        // if the last height was smaller than the biggest spotted
        if (min > list.get(list.size() - 1)) {
            int curm = list.get(list.size() - 1);
            for (i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) > curm) curm = list.get(i);
                if (curm != min) {
                    w -= (min - curm);
                }
                else break;
            }
        }

        return w;
    }
}
