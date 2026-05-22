class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            StringBuilder btr = new StringBuilder();
            byte[] bytes = s.getBytes();
            for (byte b: bytes) {
                btr.append(b).append(";"); // | is or and treated as or and not as a char
            }
            if (s.equals("")) btr.append("!");
            if (i != strs.size() - 1) str.append(btr.toString()).append(",");
            else str.append(btr.toString());
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        if (str.length() > 0) strs = new ArrayList<>(Arrays.stream(str.split(",")).toList());
        // allows me to create a changable list out of an immutable one
        List<String> strs2 = new ArrayList<>();
        for (String s: strs) {
            if (s.equals("!")) strs2.add("");
            else {
                String[] arr = s.split(";");
                StringBuilder word = new StringBuilder();
                for (String as: arr) {
                    as = new String(new byte[]{Byte.parseByte(as)});
                    word.append(as);
                }
                strs2.add(word.toString());
            }
        }
        return strs2;
    }
}
