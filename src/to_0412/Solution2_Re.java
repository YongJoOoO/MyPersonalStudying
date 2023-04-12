package to_0412;

/* 1-2. 청소 | RE */
import java.util.*;
class Solution2_Re {
	public int[] solution(int[][] board, int k){
		//answer 에는 최종 위치 (행, 열) 담아 리턴
		int[] answer = new int[2]; 
		int n = board.length;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int d = 1, x = 0, y=0, count=0;
		while(count < k) {
			count++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx <0 || nx >=n || ny<0 || ny >=n || board[nx][ny] == 1) {
				//회전시키기
				d = (d+1)%4	;
				//지속
				continue;
			}
			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;
		
		return answer;
	}

	public static void main(String[] args){
		Solution2_Re T = new Solution2_Re();
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