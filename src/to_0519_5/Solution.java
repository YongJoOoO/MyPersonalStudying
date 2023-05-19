package to_0519_5;
/*수박수박수박수?*/
/* 접근을 조금 특이하게 했다.
 * 일단 짝수인 경우 무조건 완성된 "수박"이 존재할 것이고
 * 홀수인 경우에는 마지막이 + "수"가 붙을 것임을 이용했다.
 * 그래서 일단 n/2 회까지 "수박" 문자열을 붙이되, 
 * 마지막에 n이 홀수인 경우에 한해서  + "수"를 붙여 answer를 return 하도록 했다.
 * */
class Solution {
    public String solution(int n) {
        String answer = "";
        String tmp = "수박";
        
        for(int i=0; i< n/2; i++){
            answer += tmp;
        }
        
        if(n % 2 != 0){
            answer += "수";
        }
        
        return answer;
    }
}