class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = (matrix[0].length * matrix.length) - 1;
        int[] i = new int[]{0, 0}; // [0] = n, [1] = m
        
        while (l <= r) {
            
            i[0] = (l + (r - l) / 2) / matrix[0].length;
            i[1] = (l + (r - l) / 2) % matrix[0].length;

            //System.out.println("r: " + r[0] + " " + r[1]);
            //System.out.println("l: " + l[0] + " " + l[1]);
            //System.out.println("i: " + i[0] + " " + i[1]);

            if (matrix[i[0]][i[1]] > target) {
                r = i[0] * matrix[0].length + i[1] - 1;
            }
            else if (matrix[i[0]][i[1]] < target) {
                l = i[0] * matrix[0].length + i[1] + 1;
            }
            else return true;
        }
        return false;
    }
}
