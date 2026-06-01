class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == ']' || c == ')' || c == '}') {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                switch (t) {
                    case '[':
                        if (c == ']') continue;
                        else return false;
                    case '(':
                        if (c == ')') continue;
                        else return false;
                    case '{':
                        if (c == '}') continue;
                        else return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
