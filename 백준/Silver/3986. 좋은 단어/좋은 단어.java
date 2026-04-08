import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 좋은 단어 카운트
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            Stack<Character> s = new Stack<>();
        
            for (char c: word.toCharArray()) {
                // 스택에 아무것도 없으면 추가
                if (s.isEmpty()) {
                    s.add(c);
                // 스택의 최상단과 입력값이 같지 않으면 꺼내지 않고 새로 추가
                } else if (s.peek() != c) {
                    s.add(c);
                // 그외의 케이스 전부 꺼냄
                } else {
                    s.pop();
                }
            }
            
            if (s.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}