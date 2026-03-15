import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
    
        // 후입선출인 스택 자료구조를 활용
        Stack<Integer> stack = new Stack<>();

        // 합계 담기 위한 변수
        int sum = 0;

        for (int i = 0; i < k; i++) {
            int cmd = sc.nextInt();

            // 0이 아닌 값이면 스택에 추가
            if (cmd != 0) {
                stack.add(cmd);
            }
            // 0이 들어오면 스택에서 pop
            else {
                stack.pop();
            }
        }

        // 스택에서 모든 값 꺼내서 합해줌
        while (!stack.isEmpty()) {
            Integer value = stack.pop(); 
            sum += value;    
        }

        System.out.println(sum);
    }
}
