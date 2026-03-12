import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String word1 = sc.next();
            String word2 = sc.next();

            // 문자열을 char 배열로 변환
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();

            // 배열 정렬 (사전순)
            Arrays.sort(chars1);
            Arrays.sort(chars2);

            // 다시 문자열로 변환
            String sortedStr1 = new String(chars1);
            String sortedStr2 = new String(chars2);

            if (sortedStr1.equals(sortedStr2)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
