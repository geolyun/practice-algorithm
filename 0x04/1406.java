import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        int M = sc.nextInt();

        LinkedList<Character> list = new LinkedList<>();

        // 단어의 한 글자씩 리스트에 추가
        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }

        // List 요소 탐색 줄이기 위해 ListIterator 사용
        ListIterator it = list.listIterator(list.size());

        for (int j = 0; j < M; j++) {
            String keyword = sc.next();

            if (keyword.equals("L") && it.hasPrevious()) {
                it.previous();
            } else if (keyword.equals("D") && it.hasNext()) {
                it.next();
            } else if (keyword.equals("B")) {
                if (it.hasPrevious()) {    // 왼쪽에 지울 게 있는지 확인
                    it.previous();         // 왼쪽으로 한 칸 가면서 해당 글자를 '지정'
                    it.remove();           // 방금 지정된(지나친) 글자를 삭제
                }
            } else if (keyword.equals("P")) {
                String addword = sc.next();
                char ch = addword.charAt(0);
                it.add(ch);
            } else {
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }

        String result = sb.toString();
        System.out.println(result);
    }
}
