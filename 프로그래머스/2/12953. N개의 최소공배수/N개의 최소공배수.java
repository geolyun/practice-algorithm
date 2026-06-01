import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        
        int num = arr[arr.length-1];
        
        boolean check = false;
        
        while (check == false) {
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (num % arr[i] == 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == arr.length) {
                check = true;
                answer = num;
            } else {
                ++num;   
            }
        }
        
        return answer;
    }
}