import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader 사용 (out of memory 실패로 인해 메모리 & 속도 최적화)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            boolean isError = false;

            String cmd = br.readLine();

            int n = Integer.parseInt(br.readLine());

            String inputArr = br.readLine(); // "[1,2,3,4]" 읽기

            // 1. 앞뒤 대괄호([]) 제거하기
            // substring(시작인덱스, 끝인덱스) -> 시작은 포함, 끝은 미포함
            String sub = inputArr.substring(1, inputArr.length() - 1); 

            // 2. 쉼표(,)를 기준으로 나누기
            String[] tokens = sub.split(",");

            Deque<Integer> q = new ArrayDeque<>();
            for (String s : tokens) {
                if (!s.equals("")) { // 빈 문자열이 아닐 때만 숫자로 변환
                    q.add(Integer.parseInt(s));
                }
            }

            boolean isReversed = false;
            
            for (char c : cmd.toCharArray()) {

                if (c == 'R') {
                    isReversed = !isReversed;
                }

                if (c == 'D') {
                    if (q.isEmpty()) {
                        isError = !isError;
                        break;
                    } else {
                        if (isReversed) {
                            q.pollLast();
                        } else {
                            q.pollFirst();
                        }
                    }
                }
            }


            if (!isError) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                while (!q.isEmpty()) {
                    if (!isReversed) {
                        sb.append(q.pollFirst()); // 앞에서부터 하나씩 꺼내기
                    } else {
                        sb.append(q.pollLast()); // 뒤에서부터 하나씩 꺼내기
                    }
                    
                    if (!q.isEmpty()) {
                        sb.append(","); // 다음 요소가 남아있을 때만 쉼표 추가
                    }
                }

                sb.append("]");
                System.out.println(sb.toString());

            } else {
                System.out.println("error");
            }
        }
    }
}

