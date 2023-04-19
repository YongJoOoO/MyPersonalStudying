package to_0419;
/* 1-7. 비밀번호 다시 풀기
 * */
import java.util.*;
class Solution2_Re {
	public int solution(int[] keypad, String password){
		int answer = 0;
		//8방향
		int[] dx = { -1, -1, 0, 1, 1,1, 1, 0, -1};
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
		int[][] pad = new int[3][3];
		int[][] dist = new int[10][10];//1~9까지의 숫자 각각에 대하여 가는 데 걸리는 시간 담을 용도. 0 제외하므로 크기+1
		
		//초기화 단계 
		for(int i=0; i<3; i++) {
			for(int j =0; j<3; j++) {
				pad[i][j] = keypad[i*3+j];// 차례로 규격 맞게 담김
			}
		}
		//dist는 내부 모두 2로 초기화
		for(int i=1; i<10; i++) {
			Arrays.fill(dist[i], 2);
		}
		//대각선도 0으로 초기화 
		for(int i=1; i<10; i++) dist[i][i] = 0;
		
		//본격적으로 
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				//모든 키패드 순회하면서 각 좌표별 -> 인근 숫자까지 거리를 1로 다시 세팅해주어야 함 
				int from = pad[i][j];
				for(int k=0; k<8; k++) { //현재의 from에 대한 8방향 순회하며
					if(i + dx[k] >0 && i+dx[k] <3 && j+dy[k]>=0 && j+dy[k]<3) {
						int to = pad[i+dx[k]][j+dy[k]];
						dist[from][to]= 1;//인근 위치는 1로 시간 재세팅 
					}
				}
			}
		}
		//answer 누적 
		for(int i=1; i<password.length(); i++) {
			int from = (int) password.charAt(i-1)-48;
			int to = (int) password.charAt(i)-48;
			answer += dist[from][to];
		}
		return answer;
	}
	public static void main(String[] args){
		Solution2_Re T = new Solution2_Re();
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}