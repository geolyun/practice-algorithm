import java.util.Arrays;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int size = 0;
        
        int max = Arrays.stream(tangerine).max().getAsInt();
        
        int[] cnt = new int[max+1];
        
        for (int i = 0; i < tangerine.length; i++) {
            cnt[tangerine[i]]++;
        }
        
        Arrays.sort(cnt);
        
        for (int i = 0; i < cnt.length / 2; i++) {
            int temp = cnt[i];
            cnt[i] = cnt[cnt.length - 1 - i];
            cnt[cnt.length - 1 - i] = temp;
        }
        
        for (int j = 0; j < cnt.length; j++) {
            if (size >= k) {
                break;
            } else {
                answer++;
                size += cnt[j];
            }
        }
        
        return answer;
    }
}