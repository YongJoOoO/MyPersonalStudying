package to_0727_5;

import java.util.Arrays;
import java.util.Scanner;

//1994번. 등차수열 RE
public class Main {
	//solution
	public int solution(int n, int[] nums) {
		int answer = 0;
		int dy[][] = new int[n+1][n+1];
		Arrays.sort(nums);
		
		for(int i=1; i<n; i++) {
			for(int j=i+1; j<=n; j++) {
				//기본 세팅
				dy[i][j]= 2; //최소 2개의 길이는 존재하므로 
				
				int pre = nums[i] - (nums[j] - nums[i]);//앞 항
				int k =0;
				for(k = i-1; k>=1; k--) { //i바로 앞에서부터 1까지 역순 순회
					if(nums[k] == pre) break;
				}
				dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);
				answer = Math.max(answer, dy[i][j]);
			}
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb= new Scanner(System.in);
		int n= kb.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n, arr));
	}

}
