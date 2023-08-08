package to_0808_1;

import java.util.Scanner;

/*백준 1695번. 팰린드롬 만들기 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] nums = new int[n+1];
		for(int i=1; i<= n; i++) nums[i] = kb.nextInt();
		
		int[][] dy = new int[n+1][n+1];
		for(int i=1; i<=n; i++) { //i로는 수열 길이를 컨트롤 
			for(int j=1; j<=n-i; j++) { //j로 각 값에 접근
				if(nums[j]== nums[j+i]) { //양끝단이 같은 값이면 
					dy[j][j+i] = dy[j+1][j+i-1];
				}else {//양 끝단이 다른 값이면 
					dy[j][j+i] = Math.min(dy[j+1][j+i], dy[j][j+i-1]) + 1;
				}
			}
		}
		System.out.println(dy[1][n]);
	}
}