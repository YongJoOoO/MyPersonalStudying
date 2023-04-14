package to_0414;
// 1-3. 잃어버린 강아지 RE
import java.util.*;
class Solution1_Re {
	
	public int solution(int[][] board){
		int answer = 0;
		int n  = board.length;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int d1= 0, d2=0;
		int x1 =0, y1=0, x2=0, y2=0;
		
		//초기 현수, 강아지 시작 위치 세팅
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] == 2) {
					x1 = i;
					y1 = j;
				}else if(board[i][j]== 3) {
					x2 = i;
					y2 = j;
				}
			}
		}
		
		int count = 0;
		while(count < 10000) {
			count++;
			//현수가 다음에 갈 좌표 위치
			int nx1 = x1 + dx[d1];
			int ny1 = y1 + dy[d1];
			//강아지가 다음에 갈 좌표 위치
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];
		
			//회전 조건 담기 
			boolean flag1 = true, flag2 = true;
			//현수의 회전 경우의 수 
			if(nx1 <0 || nx1>=n || ny1 <0 || ny1 >=n || board[nx1][ny1] == 1 ) {
				d1 = (d1+1)%4;
				flag1= false;//그래야 이동 안함
			}
			//강아지의 회전 경우의 수 
			if(nx2 <0 || nx2 >=n || ny2 <0 || ny2 >= n || board[nx2][ny2] == 1) {
				d2 = (d2+1) %4;
				flag2 = false;
			}
			//현수가 회전x 이동하는 경우
			if(flag1 == true) {
				x1 = nx1;
				y1 = ny1;
			}
			//강아지가 회전x 이동하는 경우
			if(flag2 == true) {
				x2 = nx2;
				y2 = ny2;
			}
			//현수와 강아지가 만나는 경우
			if(x1 == x2 && y1 == y2) {
				break;
			}
		}
		//10000 초과 시 
		if(count>=10000) return 0;
		answer = count;
		
		return answer;		
	}
	public static void main(String[] args){
		Solution1_Re T = new Solution1_Re();
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