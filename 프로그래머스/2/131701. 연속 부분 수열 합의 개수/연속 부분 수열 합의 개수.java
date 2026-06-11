import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        int n = elements.length;
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                int sum = 0;
                
                for (int k = j; k < j+i; k++) {
                    sum += elements[k % n];
                }
            
            set.add(sum);
        
            }
            
        }

        
        answer = set.size();
    
        return answer;
    }
}