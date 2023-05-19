package to_0519;
/*프로그래머스 '콜라츠 추측' 문제 */
class Solution {
    public int solution(int num) {
        int answer = 0;
        
        while(num > 1){
            
            if(num % 2 == 0) { //짝수인 경우 
                num /= 2;
            }else{ //홀수인 경우 
                num = (num*3)+1;
            }
            answer++;    

            if(answer > 500) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}
