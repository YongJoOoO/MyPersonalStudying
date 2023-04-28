package to_0428;

import java.util.Stack;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        Stack<Character> st = new Stack<>();
        for(char x : my_string.toCharArray()){
            st.push(x);
        }
        
        while(!st.isEmpty()){
            answer += st.pop();
        }
        
        return answer;
    }
}