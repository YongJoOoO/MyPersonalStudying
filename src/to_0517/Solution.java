package to_0517;

import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(char x : my_string.toCharArray()){
            if(Character.isDigit(x)){
                answer += Character.getNumericValue(x);
            }
        }
        return answer;
    }
    
    public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("aAb1B2cC34oOp"));
	}
}