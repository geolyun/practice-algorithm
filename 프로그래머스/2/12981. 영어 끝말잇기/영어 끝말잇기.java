import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
                
        Set<String> set = new HashSet<>();
        
        set.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1]; // 이전 단어
            String currWord = words[i];     // 현재 단어
            
            boolean isWrong = prevWord.charAt(prevWord.length()-1) != currWord.charAt(0);
            
            boolean isDuplicate = !set.add(currWord);
            
            if (isWrong || isDuplicate) {
                answer = new int[]{
                    (i % n) + 1, // 탈락한 사람의 번호
                    (i / n) + 1  // 탈락한 사람의 차례
                };
                break; 
            }
        } 

        return answer;
    }
}