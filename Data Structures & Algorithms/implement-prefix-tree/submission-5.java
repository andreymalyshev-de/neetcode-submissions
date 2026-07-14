class PrefixTree {
    private TrieNode[] children;

    public PrefixTree() {
         this.children = new TrieNode[26];
    }

    public void insert(String word) {
        TrieNode[] arr = children;

        for (int i = 0; i < word.length(); i++){
            if (arr[word.charAt(i) - 'a'] != null) {
                if (i + 1 == word.length()) {
                    arr[word.charAt(i) - 'a'].wordEnd = true;
                }
                arr = arr[word.charAt(i) - 'a'].children;
            }
            else {
                if (i + 1 == word.length()) {
                    arr[word.charAt(i) - 'a'] = new TrieNode(true);
                } 
                else {
                    arr[word.charAt(i) - 'a'] = new TrieNode(false);
                    arr = arr[word.charAt(i) - 'a'].children;
                }
            }
        }

    }
    

    public boolean search(String word) {
        TrieNode[] arr = children;

        for (int i = 0; i < word.length(); i++){
            if (arr[word.charAt(i) - 'a'] != null) {
                if (i + 1 == word.length() && !arr[word.charAt(i) - 'a'].wordEnd) {
                    return false;
                }
                arr = arr[word.charAt(i) - 'a'].children;
            }
            else {
                return false;
            }
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode[] arr = children;
        //System.out.println(Arrays.toString(children));

        for (int i = 0; i < prefix.length(); i++){
            if (arr[prefix.charAt(i) - 'a'] != null) {
                arr = arr[prefix.charAt(i) - 'a'].children;
            }
            else {
                return false;
            }
        }

        return true;
    }

    private class TrieNode {
        public boolean wordEnd;
        public TrieNode[] children;

        public TrieNode(boolean wordEnd) {
            this.wordEnd = wordEnd;
            this.children = new TrieNode[26];
        }
    }
}
