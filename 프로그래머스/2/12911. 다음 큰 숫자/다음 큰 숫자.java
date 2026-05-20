class Solution {
    public int solution(int n) {
        int answer = 0;

        boolean check = false;

        String binaryString = Integer.toBinaryString(n);
        String replaceString = binaryString.replace("0", "");
        int cnt = replaceString.length();

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