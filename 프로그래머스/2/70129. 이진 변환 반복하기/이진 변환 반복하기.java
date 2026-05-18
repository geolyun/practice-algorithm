class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int zerocnt = 0;
        int cnt = 0;
        
        while (s.length() > 1) {
            
            int originalLength = s.length();
            String newS = s.replace("0", "");
            int newLength = newS.length();
            
            String binaryResult = Integer.toBinaryString(newLength);
            
            zerocnt += originalLength - newLength;
            cnt += 1;
            
            s = binaryResult;
        }
        
        answer = new int[]{cnt, zerocnt};
        
        return answer;
    }
}