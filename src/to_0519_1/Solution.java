package to_0519_1;
/*핸드폰 번호 가리기 - 통과 */
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        //1) 길이 구하기
        int length = phone_number.length();
        //2) 대체 문자 잡기 
        String tmp = "";
        for(int i=0; i<length; i++ ){
            tmp += "*";
        }
        
        //3) 문자 대체하기 뒷자리 4개 뽑고 
        phone_number = phone_number.substring(length-4, length);
        
        //4) 붙이기
        answer = tmp + phone_number;
        
        return answer;
    }
}