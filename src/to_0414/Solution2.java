package to_0414;
/* 1- 4. 좌석 번호 (나의 첫 시도)*/
import java.util.*;
class Solution2 {
	// c=강연장 열. r =강연장 행. k번쨰 사람의 좌표
	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		//k번쨰 사람의 카운팅을 값으로 담는 용도임 
		int[][] seat = new int[c][r];//행열 담고  -> 90도 회전했다고 생각해라 
		
		//이미 k번째 수 > c*r 인 경우면. 그 칸에 담을 자리가 어차피 없다는 거니까 0,0, 반환함
		if(k > c*r) return new int[] {0,0};
		//방향 좌표 초기화
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int d = 1; //90도 회전 후 12시아니고 3시 방향으로 시작함
		int x=0, y=0, count = 1;// 좌표 +1 해야 함
		
		while(count <k ) {
			//다음으로 갈 지점 지칭용
			int nx = x+dx[d];
			int ny = y+dy[d];
			//경계 밖이거나 이미 방문해서 내용물 담겨있으면 회전 해야 함 
			if(nx<0 || nx>=c || ny<0 || ny>=r|| seat[nx][ny] > 0) {
				d = (d+1) % 4;
				continue; //회전만 하고 지나가야 다음 차례에 +1 처리됨
			}
			seat[x][y] = count; //내용물 담기 (몇 번째)
			count++;
			x = nx;
			y = ny; //자리 이동시킴
		}
		//최종 답 세팅
		answer[0] = x+1;
		answer[1] = y+1;
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}