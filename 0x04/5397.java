import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            // 배열 탐색 성능 높이고 커서와 같은 문제여서 LinkedList 사용
            LinkedList<Character> password = new LinkedList<>();

            String word = sc.next();

            // 명령어까지 모두 담을 배열도 생성
            ArrayList<Character> keyword = new ArrayList<>(word.length());

            ListIterator iter = password.listIterator();

            for (char c : word.toCharArray()) {
                keyword.add(c);
            }
            
            for (int j = 0; j < word.length(); j++) {
                if (keyword.get(j) == '<' && iter.hasPrevious()) {
                    iter.previous();
                } else if (keyword.get(j) == '>' && iter.hasNext()) {
                    iter.next();
                } else if (keyword.get(j) == '-') {
                    if (iter.hasPrevious()) {    // 왼쪽에 지울 게 있는지 확인
                    iter.previous();         // 왼쪽으로 한 칸 가면서 해당 글자를 '지정'
                    iter.remove();           // 방금 지정된(지나친) 글자를 삭제
                }
                // 문자이거나 숫자일때 연결 리스트에 추가 
                } else if (Character.isLetterOrDigit(keyword.get(j))) {
                    iter.add(keyword.get(j));
                } else {
                    continue;
                }
            }
            StringBuilder sb = new StringBuilder();

            for (Character item : password) {
                sb.append(item);
            }

            String str = sb.toString();
            System.out.println(str);
        }
    }
}
