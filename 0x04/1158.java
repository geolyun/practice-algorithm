import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // 큐의 선입선출 이용해서 맨 앞의 값을 뒤에 poll해서 붙이는 방식 사용
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 큐가 비어있을 때까지 실행
        while (!queue.isEmpty()) {
            // k 전까지만 맨 앞의 값을 맨 뒤로 poll해줌
            for (int j = 0; j < k-1; j++) {
                queue.add(queue.poll());
            }

            // k번째가 맨 앞에 왔을 때 꺼내서 값에 추가
            sb.append(queue.poll());

            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}
