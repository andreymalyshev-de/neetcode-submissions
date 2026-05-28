class Solution {
    public int trap(int[] height) {

        List<Integer> list = new ArrayList<>();

        //find start and end boundaries and initialize a list with those
        int i = 0;
        while(i < height.length - 2 && height[i] < height[i + 1]) {
            i++;
        }

        int j = height.length - 1;
        while(j > 0 && height[j] < height[j - 1]) {
            j--;
        }
        
        for (i = i; i < j + 1; i++) {
            list.add(height[i]);
        }
        if (list.size() < 3) return 0; 

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
