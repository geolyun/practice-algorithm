import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int room = sc.nextInt();
        // 제일 많이 쓴 수를 찾기 위해 배열 선언
        int[] score = new int[10];

        // 0일때도 실행되게 do-while문
        // 모든 자릿수를 검증하면서 배열 인덱스에 추가
        do {
            int num = room % 10;
            score[num] += 1;
            room = room / 10;
        } while (room > 0);

        // 6과 9는 서로 대체가 가능하므로 서로를 합해줌.
        // 그리고 2를 나누었을 때 세트수가 됨. 소수점일때는 한 세트를 더 써야하므로 올림을 해줌.
        int max = (int) Math.ceil((score[6] + (double) score[9]) / 2);

        // 최대 세트값 검증
        for (int i = 0; i < 10 ; i++) {
            // 6번, 9번 인덱스는 건너뛰어줌.
            if (i == 6 || i == 9) {
                continue; 
            }
            // 각 인덱스에 대해 최댓값과 검증
            if (score[i] > max) {
                max = score[i];
            }
        }
        System.out.println(max);
    }
}
