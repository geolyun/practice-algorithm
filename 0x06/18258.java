import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        // 앞뒤 확인해야해서 deque로 설정
        Deque<Integer> q = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // case 많아서 switch로 구현
            switch (st.nextToken()) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;
            
                case "pop":
                    if (!q.isEmpty()) {
                        sb.append(q.remove()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (!q.isEmpty()) {
                        sb.append(q.peekFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "back":
                    if (!q.isEmpty()) {
                        sb.append(q.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
