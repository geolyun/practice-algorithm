import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        long ans = 0;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            // 키 같은 사람들이 연속적으로 나올 수 있으므로 배열 선언 
            int[] current = new int[] {h, 1};

            // 자신보다 작은 사람들은 스택에서 제거
            while (!stack.isEmpty() && stack.peek()[0] < h) {
                ans += stack.pop()[1];
            }
           
            // 같거나 큰 키만 존재
            // 같을 때는 스택에서 꺼내서 카운트 추가한 후 스택에 다시 추가
            if (!stack.isEmpty()) {
                if (stack.peek()[0] == h) {
                    int[] top = stack.pop();

                    ans += top[1];

                    current[1] += top[1];

                    // 같은 키를 다 꺼냈을 때 배열에 값이 남아있으면 그 사람과 볼 수 있으므로 1 추가
                    if (!stack.isEmpty()) {
                        ans++;
                    }
                }
                // 자신보다 키가 큰 사람 만나면 그 사람과 자기 밖에 없으니 1만 추가
                else {
                    ans++;
                }
            }
            stack.push(current);
        }

        System.out.println(ans);
    }
}

