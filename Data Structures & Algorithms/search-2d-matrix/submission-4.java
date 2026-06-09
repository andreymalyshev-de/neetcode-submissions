class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int l = 0;
        int r = (m * matrix.length) - 1;
        int[] i = new int[]{0, 0}; // [0] = n, [1] = m
        
        while (l <= r) {
            
            int mid = l + (r - l) / 2;
            i[0] = mid / m;
            i[1] = mid % m;

            if (matrix[i[0]][i[1]] > target) {
                r = i[0] * m + i[1] - 1;
            }
            else if (matrix[i[0]][i[1]] < target) {
                l = i[0] * m + i[1] + 1;
            }
            else return true;
        }
        return false;
    }
}
