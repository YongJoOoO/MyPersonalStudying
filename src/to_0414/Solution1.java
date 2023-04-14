package to_0414;
/*1-3. 잃어버린 강아지 (나의 첫 시도) */
import java.util.*;
class Solution1 {
	public int solution(int[][] board){
		int n = board.length;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int x1 = 0, y1 = 0, x2 = 0, y2 =0;
		//현수, 강아지의 최초 출발 위치를 우선 세팅 
		for(int i=0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(board[i][j] == 2) {
					x1 = i;
					y1 = j;
				}else if(board[i][j]==3) {
					x2 = i;
					y2 = j;
				}
			}
		}
		// 현수, 강아지 방향 좌표, 시간 변수
		int d1 = 0, d2 = 0, count = 0;

		while(count < 10000) {
			count++;
			//현수 이동 
			int nx1 = x1 + dx[d1];
			int ny1 = y1 + dy[d1];
			//강아지 이동
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];
			//flag - 현수 회전과 강아지 회전을 별개의 사건으로 두어야 하고
			// 회전 시에는 이동X 이므로 flag 별도로 걸어둘 것 
			//[flag == true 기본 이동 O, flag == false 이면 회전만.]	
			boolean flag1 = true, flag2 = true;
			if(nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1){
				d1 = (d1+1) % 4;
				flag1 = false; //이동 못하고 제자리에 있고 회전만 하도록 
			}
		
			if(nx2 < 0 || nx2 >=n || ny2 <0 || ny2 >= n || board[nx2][ny2] == 1) {
				d2 = (d2+1) % 4;
				flag2 = false;
			}
			
			//이동한 좌표를 세팅 - 회전 없이 여전히 true인 경우에만 
			if(flag1 == true) {
				x1 = nx1;
				y1 = ny1;
			}
			if(flag2 == true) {
				x2 = nx2;
				y2 = ny2;
			}
			
			//이제 현수와 강아지가 만난 경우 break 걸어주기
			if(x1 == x2 && y1 == y2) break;
		}
		if(count >= 10000 ) return 0;
		
		return count;		
	}
	//실행 메인 
	public static void main(String[] args){
		Solution1 T = new Solution1();
		int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; 
		System.out.println(T.solution(arr1));
		int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; 
		System.out.println(T.solution(arr2));
	}
}