class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);

            System.out.println("a: " + a + " b: " + b);

            if (alphaNum(a) && alphaNum(b)) {
                if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
                    i++;
                    j--;
                }
                else return false;
            }
            else if (!alphaNum(a)) i++;
            else if (!alphaNum(b)) j--;
            else return false;
        }

        return true;
    }

    public boolean alphaNum(char c) {
        if ((c >= '0' && c <= '9') || (c >='A' && c <= 'Z') || (c >= 'a' && c <= 'z')) return true;
        return false;
    }
}
