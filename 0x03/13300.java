import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;

        // 6학년을 행으로 남여를 열로 배열 생성 
        int[][] people = new int[7][2];

        for (int i = 0; i < N; i++) {
            int gender = sc.nextInt();
            int age = sc.nextInt();

            // 알맞은 학년, 성별 자리에 한명 추가
            people[age-1][gender] += 1;
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                // 각 학년, 성별마다 필요한 방의 수 추가
                cnt += Math.ceil(people[i][j] / (double) K);
            }
        } 
        System.out.println(cnt);
    }
}
