import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // 입력을 쪼개줌
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int currentHeight = Integer.parseInt(st.nextToken());

            // 나보다 작은 탑들은 스택에서 제거(내 값보다 크면서 제일 상단에 있는 것만 찾으면 됨)
            while (!stack.isEmpty() && stack.peek()[1] < currentHeight) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek()[0]).append(" ");
            }

            // 현재 탑 정보를 스택에 저장
            stack.push(new int[] {i, currentHeight});
        }

        System.out.println(sb.toString().trim());
    }
}
