package to_0525_1;
// 4-5. 모임 장소 
import java.util.*;
class Solution {
	//솔루션 함수 
	public int solution(int[][] board){
		int answer=0;
		int n = board.length;
		//행
		ArrayList<Integer> row = new ArrayList<>();
		//열
		ArrayList<Integer> col = new ArrayList<>();
		// 각 애들의 좌표를 담을 것 
		for(int i=0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(board[i][j] == 1) {
					row.add(i); //행
					col.add(j); //열
				}
			}
		}
		//오름차순 최소거리 중앙점 찾기 
		Collections.sort(row);
		Collections.sort(col);
		
		//각각 중앙점 좌표에 존재하는 mR, mC 발견 
		int x = row.get(row.size()/2);
		int y = col.get(col.size()/2);
		
		//최소거리 누적 
		for(int p : row) answer += Math.abs(x - p);
		for(int p : col) answer += Math.abs(y - p);
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
	}
}