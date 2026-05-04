import java.util.*;

class Solution {
    public String solution(String s) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
                        
        String[] parts = s.split(" ");

        for (int i = 0; i < parts.length; i++) {
            int number = Integer.parseInt(parts[i]);
            
            if (number > max) max = number;
            if (number < min) min = number;
        }
        
        StringBuilder sb = new StringBuilder();
               
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        String answer = sb.toString();
        
        return answer;
    }
}