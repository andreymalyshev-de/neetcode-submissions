class WordDictionary {
    public HashMap<Character, TrieNode> hm;

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
        return help(hm, word, 0);    
    }

    public boolean help(HashMap<Character, TrieNode> kids, String word, int j) {

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode n: kids.values()) {
                    if (i + 1 == word.length()) {
                        if (n.wordEnd) return true;
                        else continue;
                    }
                    if (help(n.hm, word, i + 1)) return true;
                }
                return false;
            }
            else {
                if (kids.containsKey(c)) {
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
