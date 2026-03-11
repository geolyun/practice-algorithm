import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        // add랑 get으로 편하게 사용하려고 arraylist 사용
        ArrayList<Integer> numlist = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            numlist.add(a);
        }

        // 오름차순 정렬
        Collections.sort(numlist);

        // 투 포인터 알고리즘 사용을 위한 포인터 기록
        int x = sc.nextInt();
        int l = 0;
        int r = num-1;
        int cnt = 0;
        
        while (l < r) {
            // 값보다 작으면 왼쪽에서 +1
            if (numlist.get(l) + numlist.get(r) < x) {
                l += 1;
            // 값보다 크면 오른쪽에서 -1
            } else if (numlist.get(l) + numlist.get(r) > x) {
                r -= 1;
            } else {
                // 같을 때 횟수도 1 더하고 두 포인터 모두 움직여줘야함.
                cnt += 1;
                l += 1;
                r -= 1;
            }
        }
        System.out.println(cnt);
    }
}
