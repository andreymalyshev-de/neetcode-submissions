class Solution {
    public boolean isPalindrome(String s) {
        int[] list = IntStream.range(0, s.length()).map(i -> s.getBytes()[i])
        .filter(x -> (((x > 47) && (x < 58)) || ((x > 64) && (x < 91)) || ((x > 96) && (x < 123))))
        .toArray();
        
        int i = 0;
        int j = list.length - 1;
        while (i < j) {
            System.out.println("i: " + (char)list[i] + " j: " + (char)list[j]);
            int a = list[i];
            int b = list[j];
            if (a == b) {
                i++;
                j--;
            }
            else if (a > 64 && a < 91 && (b - 32) == a) {
                i++;
                j--;
            }
            else if (b > 64 && b < 91 && (a - 32) == b) {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}
