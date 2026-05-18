import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stk = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.add('(');
            }
            else if (c == ')') {
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                } else {
                    answer = false;
                }
            }
        }
        
        if (!stk.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}