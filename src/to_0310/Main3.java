package to_0310;

import java.util.Scanner;
import java.util.Stack;

/* 5-3. 크레인 인형뽑기 (카카오 기출)*/
public class Main3 {
	//솔루션 함수 
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		//moves 탐색 : 크레인 위치
		for(int pos : moves) {
			//2차원 배열의 행크기만큼 돌면서 
			for(int i = 0; i<board.length; i++) {
				if(board[i][pos-1] != 0) { //인형 존재하는 경우, 뽑고 0으로 세팅
					int tmp = board[i][pos-1];
					board[i][pos-1] = 0;
					//현재 인형이 기존 스택 top 데이터와 동일한 경우 터뜨려야 함
					if(!stack.isEmpty() && tmp == stack.peek()) {
						answer += 2; 
						stack.pop();//꺼냄
					}
					else { //다른 인형이면 그냥 push
						stack.push(tmp);
					}
					//담았든 터뜨렸든 
					//각 크레인 내부 도는 i는 break 벗어나서 다음 크레인으로 이동
					break;
				}
			}
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] board = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		int m = kb.nextInt();
		int[] moves = new int[m];
		
		for(int i = 0; i<m; i++) {
			moves[i] = kb.nextInt();
		}
		
		//출력
		System.out.println(T.solution(board, moves));
	}
}