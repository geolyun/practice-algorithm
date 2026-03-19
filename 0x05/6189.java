import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();

        // cnt값이 커서 long으로 할당
        long cnt = 0;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            // 스택에 새로운 값이 들어왔을 때 자신보다 작은 값들 제거
            // 스택에 최종적으로 남는 것은 자기를 볼 수 있는 건물들 
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }

            // 스택의 크기만큼 카운트
            cnt += stack.size();

            stack.push(num);
        }

        System.out.println(cnt);
    }
}
