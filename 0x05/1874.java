import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>(n);

        // 지금까지 스택에 넣은 숫자 중 가장 큰 값
        int firstnum = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            // 현재 입력된 숫자가 마지막으로 넣은 값보다 크면 그만큼 push
            if (num > firstnum) {
                for (int k = firstnum+1; k <= num; k++) {
                    stack.add(k);
                    list.add("+");
                }
                // 최대값 업데이트
                firstnum = num;
            } 
            
            // 스택의 맨 위가 내가 꺼내려는 숫자와 같은지 확인
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                list.add("-");
            } 

            // 조건을 만족(중간에 놓임)하지 않으면 NO
            else {
                System.out.println("NO");
                return;
            }
            
        }
       
        for (int l = 0; l < list.size(); l++) {
            System.out.println(list.get(l));
        }
    }
}
