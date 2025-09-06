class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        // 길이 판별
        if(!(s.length() == 4 || s.length() == 6)) {
            return false;
        }
        
        // 숫자인지 판별 (정규식으로 변경할 수 있음)
        for(char c : s.toCharArray()) {
            if(!('0' <= c && c <= '9')) {
                return false;
            }
        }
        
        return answer;
    }
}