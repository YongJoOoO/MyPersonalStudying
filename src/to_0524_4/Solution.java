package to_0524_4;

class Solution {

	public int solution(int n) {
        int answer = 0;
  
        if(n == 0) return 0;
        else if (n==1) return 1;
        else {
        	return solution(n-2) + solution(n-1);
        }

    }
    
    //실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(3));
	}
    
}