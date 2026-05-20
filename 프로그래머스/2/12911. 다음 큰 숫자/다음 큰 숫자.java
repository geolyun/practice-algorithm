class Solution {
    public int solution(int n) {
        int answer = 0;

        boolean check = false;

        // 변환한 이진수와 0 제거한 이진수의 차로 1의 갯수 구함 
        String binaryString = Integer.toBinaryString(n);
        String replaceString = binaryString.replace("0", "");
        int cnt = replaceString.length();

        // 답을 찾을 때까지 반복
        while (check == false) {
            
            ++n;

            String newbinaryString = Integer.toBinaryString(n);
            String newreplaceString = newbinaryString.replace("0", "");
            int newcnt = newreplaceString.length();

            if (cnt == newcnt) {
                check = true;
                answer = n;
            }
        }

        return answer;
    }
}