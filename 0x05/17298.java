import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 스택을 뒤집기 위한 스택을 할당
        Stack<Integer> beforesStack = new Stack<>();
        Stack<Integer> afterStack = new Stack<>();
        // 결과가 반대나오니 그걸 뒤집기 위한 스택
        Stack<Integer> resultStack = new Stack<>();        

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            // 스택에 모두 push
            int num = Integer.parseInt(st.nextToken());
            beforesStack.push(num);
        }

        for (int j = 1; j <= n; j++) {
            int A = beforesStack.pop();

            // 자신보다 작은 수들은 스택에서 제거
            while (!afterStack.isEmpty() && A >= afterStack.peek()) {
                afterStack.pop();
            }

            // 스택에 값이 있으면 자신보다 오큰수이므로 결과 스택에 push
            resultStack.push(afterStack.isEmpty() ? -1 : afterStack.peek());

            afterStack.push(A);
        }

        while(!resultStack.isEmpty()){
            sb.append(resultStack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}

