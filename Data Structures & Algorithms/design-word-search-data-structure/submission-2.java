class WordDictionary {
    public HashMap<Character, TrieNode> hm;
    
    int c = 0;

    public WordDictionary() {
        this.hm = new HashMap<>();
    }

    public void addWord(String word) {
        HashMap<Character, TrieNode> kids = hm;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (kids.containsKey(c)) {
                if (i + 1 == word.length()) kids.get(c).wordEnd = true;
                kids = kids.get(c).hm;
            }
            else {
                if (i + 1 == word.length()) kids.put(c, new TrieNode(true));
                else kids.put(c, new TrieNode(false));
                kids = kids.get(c).hm;
            }
        }
    }

    public boolean search(String word) {
        return help(hm, word);    
    }

    public boolean help(HashMap<Character, TrieNode> kids, String word) {
        StringBuilder str = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            System.out.println(c + " " + kids.containsKey(c) + " ");

            if (c == '.') {
                if (i > 0) str.delete(0, i);
                for (int j = 0; j < 26; j++) {
                    str.setCharAt(0, (char)('a' + (char)j));
                    System.out.println("str check: " + str.toString());
                    if (help(kids, str.toString())) return true;
                }
                return false;
            }
            else {
                if (kids.containsKey(c)) {
                    //System.out.println(kids.get(c).wordEnd);
                    if (i + 1 == word.length()) {
                        return kids.get(c).wordEnd;
                    }
                    kids = kids.get(c).hm;
                }
                else return false;
            }
        }
        return true;        
    }

    private class TrieNode {
        public boolean wordEnd;
        public HashMap<Character, TrieNode> hm;

        public TrieNode(boolean wordEnd) {
            this.wordEnd = wordEnd;
            this.hm = new HashMap<>();
        }
    }
}
