package to_0517;

import java.util.Scanner;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double tmp = Math.sqrt(n);
        
        if(tmp % 1 == 0) {
        	//pow( a, b) => a의 b 제곱을 반환한다. 
        	answer = (long) Math.pow(tmp+1, 2);
        }else return -1;
        
        return answer;
    }
    

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Solution T = new Solution();
		int n = sc.nextInt();
		System.out.println(T.solution(n));
	}
}