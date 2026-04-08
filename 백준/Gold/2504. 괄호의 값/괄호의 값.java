import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> s = new Stack<>(); 
        
        boolean check = false;

        int tmp = 1;

        int sum = 0;

        char prev = ' ';

        for (char c: str.toCharArray()) {
            // 미리 곱하기를 계산하는 식
            if (c == '(') {
                tmp *= 2;
                s.add(c);
            }

            if (c == '[') {
                tmp *= 3;
                s.add(c);
            }

            if (c == ')') {
                // 스택이 비어있거나 짝이 맞지 않으면 에러 처리
                if (s.isEmpty() || s.peek() != '(') {
                    check = true;
                    break;
                }
                // 곱하기를 전체 괄호에 하는 것이 아닌 분배법칙 적용
                if (prev == '(') {
                    sum += tmp;
                }
                // 닫는 괄호 이전에 닫는 괄호면 계산이 된 값이므로 그냥 현재값을 나누기만 해줌
                s.pop();
                tmp /= 2;
            }
            
            if (c == ']') {
                if (s.isEmpty() || s.peek() != '[') {
                    check = true;
                    break;
                }
                if (prev == '[') {
                    sum += tmp;
                }
                s.pop();
                tmp /= 3;
            }

            prev = c;
        }

        if (check || !s.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(sum);
        }
    }
}