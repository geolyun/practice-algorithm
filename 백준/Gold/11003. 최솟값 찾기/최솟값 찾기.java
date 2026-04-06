import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // 실제 값 저장
        int[] arr = new int[n];

        // 값의 인덱스를 슬라이드 윈도우로 저장
        Deque<Integer> q = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;

            // 뒤에서부터 배열을 확인해서 들어올 숫자보다 작으면 쳐냄
            while (!q.isEmpty() && arr[q.peekLast()] > now) {
                q.pollLast();
            }

            // 새로운 수 추가
            q.addLast(i);

            // 맨 앞 숫자 인덱스가 원하는 인덱스보다 작으면 꺼냄
            if (!q.isEmpty() && q.peekFirst() <= i-l) {
                q.pollFirst();
            }

            sb.append(arr[q.peekFirst()]).append(" ");
        }

        System.out.println(sb.toString());
    }
}

