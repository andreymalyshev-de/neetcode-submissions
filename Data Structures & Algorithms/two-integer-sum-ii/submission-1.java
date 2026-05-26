class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;
        
        while(a < b) {
            int n = numbers[a] + numbers[b];
            if (n == target) return new int[]{a + 1, b + 1};
            else if (n > target) {
                b--;
            }
            else {
                a++;
            }
        }

        return new int[]{a + 1, b + 1};
    }
}
