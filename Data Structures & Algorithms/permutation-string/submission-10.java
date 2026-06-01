class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // clever solution with arrays, 
        // we create 2 arrays of the length s1 then fill the 
        // 1st one with the char freqs of s1 and the second one
        // with the char freqs of the respective window in s2
        // (2nd arr serves as a window for s2)
        // if ever those arrays (char freqs in a window and in s1)
        // match then true

        if (s1.length() > s2.length()) return false;

        int[] arr1 = new int[26]; // max 26 ascii chars
        int[] arr2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++; // that's why only lowercase letters
            arr2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (arr1[i] == arr2[i]) matches++; // counting the matches in the 1st window
        }

        if (matches == 26) return true;

        int l = 0;

        for (int r = s1.length(); r < s2.length(); r++) {
            System.out.println("arr1: " + Arrays.toString(arr1) + " arr2: " + Arrays.toString(arr2));
            System.out.println(matches);
            if (arr2[s2.charAt(l) - 'a'] == arr1[s2.charAt(l) - 'a']) matches--;
            arr2[s2.charAt(l) - 'a']--;
            if (arr2[s2.charAt(l) - 'a'] == arr1[s2.charAt(l) - 'a']) matches++;
            l++;

            if (arr2[s2.charAt(r) - 'a'] == arr1[s2.charAt(r) - 'a']) matches--;
            arr2[s2.charAt(r) - 'a']++;
            if (arr2[s2.charAt(r) - 'a'] == arr1[s2.charAt(r) - 'a']) matches++;
            if (matches == 26) return true;
        }

        System.out.println("arr1: " + Arrays.toString(arr1) + " arr2: " + Arrays.toString(arr2));

        return false;
    }
}
