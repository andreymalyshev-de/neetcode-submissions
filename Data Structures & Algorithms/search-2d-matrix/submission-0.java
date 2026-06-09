class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] l = new int[]{0, 0};
        int[] r = new int[]{matrix.length - 1, (matrix[0].length * matrix.length) - 1};
        int[] i = new int[]{0, 0}; // [0] = n, [1] = m
        int c = 0;
        
        while (l[0] <= r[0] && l[1] <= r[1]) {
            //c++;



            i[0] = (l[1] + (r[1] - l[1]) / 2) / matrix[0].length;
            i[1] = (l[1] + (r[1] - l[1]) / 2) % matrix[0].length;



            //System.out.println("r: " + r[0] + " " + r[1]);
            //System.out.println("l: " + l[0] + " " + l[1]);
            //System.out.println("i: " + i[0] + " " + i[1]);

            if (matrix[i[0]][i[1]] > target) {
                if (i[1] == 0) {
                    r[0] = i[0] - 1;
                    r[1] = (matrix[0].length - 1) + r[0]*matrix[0].length;
                }
                else {
                    r[0] = i[0];
                    r[1] = i[1] - 1 + r[0]*matrix[0].length;
                }
            }
            else if (matrix[i[0]][i[1]] < target) {
                if (i[1] == matrix[0].length - 1) {
                    l[0] = i[0] + 1;
                    l[1] = l[0]*matrix[0].length;
                }
                else {
                    l[0] = i[0];
                    l[1] = i[1] + 1 + l[0]*matrix[0].length;
                }
            }
            else return true;
        }
        return false;
    }
}
