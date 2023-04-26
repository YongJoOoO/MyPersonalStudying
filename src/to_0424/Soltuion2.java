package to_0424;
/* 2-4. 음수가 있는 부분수열 */
import java.util.*;
class Soltuion2 {
	public int solution(int[] nums, int m){
		int answer = 0;
		
		return answer;
	}

	public static void main(String[] args){
		Soltuion2 T = new Soltuion2();
		System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));	
		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));	
		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));	
	}
}