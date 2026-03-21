import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        // 앞뒤 확인해야해서 deque로 구현
        Deque<Integer> q = new ArrayDeque<>();
    
        // 일단 큐에 모든 카드 순서대로 추가
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        // 명령 실행
        while (q.size() > 1) {
            q.remove();
            q.add(q.remove());
        }

        System.out.println(q.peek());
    }
}
