package to_0414;
/* 1-4. 좌석번호 복습 풀이 
 * */
import java.util.Arrays;

class Solution2_Re {
	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		int[][] seat = new int[c][r];
		if(k > c*r) return new int[] {0,0};
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int d = 1;
		int x=0, y=0, count=1;
		
		while(count < k) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx<0 || nx>=c || ny <0 || ny>=r || seat[nx][ny] > 0) {
				d = (d+1) %4;
				continue;
			}
			//일단 현재 좌표에 카운팅 담아놓고 
			seat[x][y] = count;
			count++; //다음 좌표에 담을 카운팅
			//현재 좌표에서 다음 좌표로 자리 이동처리
			x = nx;
			y = ny;
		}
		answer[0] = x+1;
		answer[1] = y+1;

		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution2_Re T = new Solution2_Re();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}