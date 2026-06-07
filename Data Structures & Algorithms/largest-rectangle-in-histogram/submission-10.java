class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
        
            int[] cur = new int[]{heights[i], i};
            while (!stack.isEmpty() && stack.peek()[0] > cur[0]) {
                int[] tmp = stack.pop();
                if (tmp[0] == cur[0]) { // case 2 2
                    break;
                }

                int area = stack.isEmpty() ? (cur[1] * tmp[0]) : ((cur[1] - stack.peek()[1] - 1) * tmp[0]);
                if (max < area) max = area;
                System.out.println("el: " + tmp[0] + " i: " + tmp[1]);
                System.out.println("max: " + max);
            }

            stack.push(cur); 
        }

        while (!stack.isEmpty()) {
            int[] tmp = stack.pop();

            int area = stack.isEmpty() ? (heights.length * tmp[0]) : ((heights.length - stack.peek()[1] - 1) * tmp[0]);
            if (max < area) max = area;
            System.out.println("End: el: " + tmp[0] + " i: " + tmp[1]);
            System.out.println("max: " + max);
        }
        
        return max;

    }
}
