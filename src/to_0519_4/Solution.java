package to_0519_4;
/*문자열 내림차순 배치 하기 */
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        
        for(int i=tmp.length-1; i>=0 ; i--){
            answer += String.valueOf(tmp[i]);
        }
        
        return answer;
    }
}