package to_0520_1;
/*부족한 금액 계산하기 */
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        //타입 일치 시켜줘야 한다. 아니면 오류 남 
        long tmp = 0; 
        for(int i=1; i<=count; i++){
            tmp += (price * i);
        }
        
        if(tmp > money){
            answer = tmp - money;
        }
       
        return answer;
    }
}