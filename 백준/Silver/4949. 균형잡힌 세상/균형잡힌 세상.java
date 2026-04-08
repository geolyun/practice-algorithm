import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            Stack<Character> s = new Stack<>();

            // 종료 조건: 입력의 끝에 점 하나만 들어온 경우
            if (line.equals(".")) {
                break;
            }

            // 맨 마지막에 스택에 값 있나 확인위해 불린 사용
            boolean check = false;

            for (char i : line.toCharArray()) {
                if (i == ('(')) {
                    s.add(i);
                }
                
                // 닫는 괄호에 스택이 비어있지 않고 맨 위의 값이 여는 괄호일때만 꺼냄
                if (i == (')')) {
                    if (!s.isEmpty() && s.peek() != '(') {
                        System.out.println("no");
                        check = true;
                        break;
                    } else if (s.isEmpty()) {
                        System.out.println("no");
                        check = true;
                        break;
                    }
                    else {
                        s.pop();
                    }
                }
                
                if (i == ('[')) {
                    s.add(i);
                }

                // 닫는 괄호에 스택이 비어있지 않고 맨 위의 값이 여는 괄호일때만 꺼냄
                if (i == (']')) {
                    if (!s.isEmpty() && s.peek() != '[') {
                        System.out.println("no");
                        check = true;
                        break;
                    } else if (s.isEmpty()) {
                        System.out.println("no");
                        check = true;
                        break;
                    }
                    else {
                        s.pop();
                    }
                }
            }

            // 스택에 괄호 아무거나 남아있으면 no
            if (!check) {
                if (s.isEmpty()) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}