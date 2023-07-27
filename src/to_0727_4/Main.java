package to_0727_4;

import java.util.Arrays;
import java.util.Scanner;

/*1994번. 등차수열 */
public class Main {
	//solution 함수 
	public int solution(int n, int[] nums) {
		int answer = 0;
		if(n==1) return 1;
		int[][] dy = new int[n+1][n+1];
		//정렬
		Arrays.sort(nums);
		//
		for(int i=1; i<n; i++) {
			for(int j=i+1; j<=n; j++) {
				dy[i][j] = 2;//일단 기본 2 세팅 
				//i 앞의 항 찾는 거임 따라서 i번쨰 값에서 (공차)를 빼주면 되는 건데 
				
				int pre = nums[i] - (nums[j] - nums[i]); // 2 * nums[i] - nums[j]
				int k =0;//o초기화 해준뒤 
				for(k =i-1; k>=1; k--) {//i앞~1까지 역순으로 돌면서 k 즉, 앞의 등차수열 항 존재하는지 탐색 
					if(nums[k] == pre) break;//탈출 
				}
				//i,j번쨰를 마지막으로 하는 등차의 최대 길이 = 기존 vs k~i까지의 길이 + 1 
				dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);
				answer = Math.max(answer, dy[i][j]); //기존값보다 큰 길이 생기면 갱신 
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb= new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] nums =new int[n+1];
		
		for(int i=1; i<=n; i++) nums[i] = kb.nextInt();
		System.out.print(T.solution(n, nums));
	}
}