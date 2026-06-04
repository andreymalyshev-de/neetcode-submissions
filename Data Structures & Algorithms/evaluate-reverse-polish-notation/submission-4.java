class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            int a;
            int b;

            switch (c) {
                case "+": 
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a + b));
                    break;
                case "-": 
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b - a));
                    break;
                case "*": 
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a * b));
                    break;
                case "/": 
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b / a));
                    break;
                default:
                    stack.push(c);
                    break;
            }
            System.out.println(stack.peek());
        }
        return Integer.parseInt(stack.pop());        
    }
}
