import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> q = new LinkedList<>();

        int sum = 0;
    
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < m; j++) {
            int num = Integer.parseInt(st.nextToken());
            int targetIdx = q.indexOf(num); // 뽑으려는 숫자의 현재 위치
            int halfIdx = q.size() / 2;    // 현재 큐의 중간 지점

            if (targetIdx <= halfIdx) {
                // targetIdx만큼 반복하며 맨 앞을 뽑아 뒤로 보냄
                for (int i = 0; i < targetIdx; i++) {
                    q.addLast(q.pollFirst());
                    sum++;
                }
            } else {
            // (size - targetIdx)만큼 반복하며 맨 뒤를 뽑아 앞으로 보냄
            for (int i = 0; i < q.size() - targetIdx; i++) {
                q.addFirst(q.pollLast());
                sum++;
            }
        }
        q.pollFirst();
    }
        System.out.println(sum);
    }
}
