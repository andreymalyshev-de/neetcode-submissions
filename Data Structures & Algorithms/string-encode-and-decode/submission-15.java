class Solution {

    public String encode(List<String> strs) {
        StringBuilder btr = new StringBuilder();
        for (String s: strs) {
            int l = s.length();
            btr.append(l).append("#").append(s); // 5#Hello format
            //System.out.println(btr.toString());
        }
        return btr.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int hashtag = str.indexOf('#', i); // returns the first occurance of the specified character
                                // beginning from the index i
            int l = Integer.parseInt(str.substring(i, hashtag));
            // parseInt gives int as it is, valueOf gives the ASCII value
            String s = str.substring(hashtag + 1, hashtag + 1 + l);
            i = hashtag + 1 + l;
            list.add(s);
        }

        return list;
    }
}
