import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        int N = s.length();
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        
        if (stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}