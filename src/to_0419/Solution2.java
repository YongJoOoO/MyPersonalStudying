package to_0419;
/* 1-7. 비밀번호  */
import java.util.*;
class Solution2 {
	//솔루션 함수 
	public int solution(int[] keypad, String password){
		int answer = 0;
		//인접한 8방향 순회할 용도 
		int[] dx = { -1, -1, 0, 1, 1,1, 1, 0, -1};
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
		//키패드 담는 3X3 규격
		int[][] pad = new int[3][3];
		//각 번호 i-> j로 가는 시간 세팅할 배열 
		int[][] dist = new int[10][10];
		
		for(int i =0; i<3; i++) {
			for(int j=0; j<3; j++) {
				// 이렇게 해서 3X3 에 차례로 값 담기 가능 
				pad[i][j] = keypad[i*3+j];
			}
		}
		//내부의 값을 기본 2 초기화 
		for(int i=0; i<10; i++) {
			//dist[i] 각 i 번째의 dist 배열에 2로 초기화시킴 
			Arrays.fill(dist[i], 2); 
		}
		//대각선은 각자 자기 자신에게 가는 값이므로 0초기화 
		for(int i=0; i<10; i++) dist[i][i] = 0; //대각선 값은 0초기화 	
		
		for(int i=0; i<3; i++) {
			for(int j =0; j<3; j++) {
				//키패드 차례로 순회함
				//ex. 0행 0열의 값이 from에 있으면 (얘는 출발점) 
				int from = pad[i][j];
				//from출발점에 인접한 8방향에 대하여 돌기 위해 k로 돌기
				for(int k =0; i<8; k++) {
					//패드 경계 내부의 값이면
					if(i+dx[k] >=0 && i+dx[k] <3 && j+dy[k] >=0 && j+dy[k] <3) {
						//from 기준으로 인접하게 이동했던 숫자들 (-> k로 돌면서 차례로 to 변수에 담음)
						int to = pad[i+dx[k]][j+dy[k]];
						//from -> to 로 가능 시간 1초로 재세팅 
						dist[from][to]= 1; //인접한 값이면 1
					}
				}
			}
		}
		//이제 입력된 password비번 순서대로 시간 확인하면서 누적
		for(int i=1; i<password.length(); i++) {
			int from = (int) password.charAt(i-1)-48;
			int to = (int) password.charAt(i)-48;
			answer += dist[from][to];
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}