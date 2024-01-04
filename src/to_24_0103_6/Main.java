package to_24_0103_6;

import java.util.Scanner;

/**
 * 9963번. N-Queen - 백트래킹 문풀  
 * @author MYLG
 *
 */
public class Main {
	static int count = 0;
	static int N;
	static int[] arr;
	
	//DFS
	static void DFS(int row) { //행에 대한 깊이탐색 시도 
		if(row == N) {
			count++;//여기까지 깊이 행이 도달했다면 모든 행에 퀸을 두었다는 것이므로 ++처리 
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[row] = i;//현재 깊이의 행에 퀸 위치를 i열에 둔다
			if(isPossible(row)) {
				DFS(row+1);//다음 깊이로 이동
			}
		}
	}
	
	//isPossible
	static boolean isPossible(int row) {
		for(int i=0; i<row; i++) {
			if(arr[i] == arr[row]) {
				//들어온 행에대한 열과 같은 열값을 갖는 게 이전 arr에 있었는지 확인 
				return false;//그 위치는 공격가능한 영역이므로 
			}
			
			//들어온 직전 행, 현재 찍은 i행 차이와 직전 열 - 현재 i열의 차가 같은 경우 동일 대각선상에 존재하는 퀸이 존재하므로 안됨 
			if(Math.abs(i-row) == Math.abs(arr[i]-arr[row])) {
				return false;
			}
		}
		return true;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		arr = new int[N];
		
		DFS(0);
		
		System.out.println(count);
		
	}
}