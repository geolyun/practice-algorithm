import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int l = 0;
        int r = people.length - 1;
    
        int cnt = 0;
        
        Arrays.sort(people);
                
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
                cnt++;
            } else {
                r--;
                cnt++;
            }
        }
        
        answer = cnt;
        
        return answer;
    }
}