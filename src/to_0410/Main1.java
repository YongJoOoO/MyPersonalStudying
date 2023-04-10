package to_0410;
/* 1-1. 사다리 타기 */
public class Main1 {
	//솔루션
	public char[] solution(int n, int[][] ladder) {
		char[] answer = new char[n];
		for(int i=0; i<n; i++) {
			//알파벳 순으로 대문자 담는다. 
			answer[i] = (char) (i+65);
		}
		//각 사다리 정보 하나씩 뽑아서 
		for(int[] line : ladder) {
			//막대기 x가 지칭하는 위치와 그 직전 위치 자리 교환
			for(int x : line) {
				char tmp = answer[x];
				answer[x] = answer[x-1];
				answer[x-1] = tmp;
			}
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		System.out.println(T.solution(5, new int[][] { {1,3}, {2,4}, {1,4} } ));
	}
}