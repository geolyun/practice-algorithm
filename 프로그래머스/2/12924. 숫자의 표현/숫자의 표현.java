class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 투 포인터 이용
        int l = 1, r = 1, sum = 1;
  
        while (r <= n) {
            if (sum == n) answer++;

            // 합이 자연수보다 크면 왼쪽 1더하고 합에서 왼쪽 수 - 
            if (sum >= n) sum -= l++;

            // 합이 자연수보다 작으면 오른쪽 1더하고 그 수 더해줌
            else if (sum < n) sum += ++r;
        }
        
        return answer;
    }
}