package to_0412;
/* 1-2. 청소 | 로봇이 상하좌우 위치로 이동함
 * */
import java.util.*;
class Solution2 {
	//솔루션 함수 
	public int[] solution(int[][] board, int k){
		int[] answer = new int[2];  //반환용 답 
		int n = board.length; //격자판 크기
		//위치 이동 변수 : 12. 3. 6. 9 시계방향 순 
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int d = 1, x= 0, y=0, count=0; 
		while(count < k) {
			count++;//반복 조건 
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 격자밖 or 장애물 만날 경우 = 회전 해야 함 
			if(nx <0 || nx >= n || ny <0 || ny >=n || board[nx][ny] == 1) {
				d = (d+1) % 4;//계속 시계방향으로 회전 처리해야 하고
				//회전 시에도 시간 걸리므로 위치 동일해야 함 
				continue;
			}
			//좌표 찍어주고
			x = nx;
			y = ny; 
		}
		//반복문 탈출 후, 정답에 각각 x,y 최종 좌표 담기 
		answer[0] = x;
		answer[1] = y;
		
		return answer;
	}

	//실행 메인 
	public static void main(String[] args){
		Solution2 T = new Solution2();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
		
	}
}