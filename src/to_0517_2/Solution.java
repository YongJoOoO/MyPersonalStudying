package to_0517_2;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int sum = 0;
        if(a == b) {
            return a;
        }else if(a > b){
            while( a != b) {
                sum += b;
                b++;
            }
        }else if( a < b){
            while(a != b){
                sum += a;
                a++;
            }
        }
        
        answer = Long.valueOf(sum);
        
        return answer;
    }
}