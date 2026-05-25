class Solution {
    public boolean isPalindrome(String s) {
/*         int[] s.getBytes() = IntStream.range(0, s.length()).map(i -> s.getBytes()[i])
        .filter(x -> (((x > 47) && (x < 58)) || ((x > 64) && (x < 91)) || ((x > 96) && (x < 123))))
        .toArray(); */


        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            System.out.println("i: " + (char)s.getBytes()[i] + " j: " + (char)s.getBytes()[j]);
            //System.out.println("i: " + s.getBytes()[i] + " j: " + s.getBytes()[j]);
            int a = s.getBytes()[i];
            int b = s.getBytes()[j];
            if (!(((a > 47) && (a < 58)) || ((a > 64) && (a < 91)) || ((a > 96) && (a < 123)))) {
                i++;
            }
            else if (!(((b > 47) && (b < 58)) || ((b > 64) && (b < 91)) || ((b > 96) && (b < 123)))) {
                j--;
            }
            else if (a == b) {
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
