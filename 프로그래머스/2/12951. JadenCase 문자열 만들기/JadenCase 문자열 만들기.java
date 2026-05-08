class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        // 첫 번째 글자는 무조건 "이전이 공백이었다"고 가정하고 대문자 후보로 만듦
        boolean isFirst = true; 

        for (char c : s.toCharArray()) {
            // 1. 현재 문자가 공백이면 다음 글자는 '첫 글자'가 됨
            if (c == ' ') {
                sb.append(c);
                isFirst = true;
            } 
            // 2. 공백이 아닌데 첫 글자라면 대문자로, 아니면 소문자로
            else {
                if (isFirst) {
                    sb.append(Character.toUpperCase(c));
                    isFirst = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }

        return sb.toString();
    }
}