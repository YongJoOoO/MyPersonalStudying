package to_0419;

// 1-6. 과일 가져가기 | 어려운 문제 -> 반복해서 풀어보기
class Solution1 {
	//1) 최솟값을 확인해야 함
	//2) 최솟값은 유일해야 함
	//3) 최솟값 갖는 과일 인덱스 값은 서로 달라야 함
	//4) 증가한 과일 <= 감소한 과일 이어야 함
	
	//입력 배열 내부에서 각 학생이 갖는 과일 속 최솟값 담는 용도 
	public int getMin(int[] fruit) {
		int min = 100;
		for(int x : fruit) {
			min = Math.min(min, x);
		}
		return min;
	}
	//최솟값이 유니크한지 확인용 배열
	public Boolean isMinUnique(int[] fruit) {
		int cnt = 0;
		int min = getMin(fruit);
		//얻어온 최솟값이 전체 배열 순회해도 여전히 cnt==1 인지 확인
		for(int x : fruit) {
			if(x == min) cnt++;
		}
		//cnt==1 이면 유니크한 거니 True 반환 
		return cnt == 1;
	}
	//최솟값의 인덱스값 반환 함수(=과일 확인용)
	public int getMinIndex(int[] fruit) {
		int min = getMin(fruit);
		for(int i=0; i<3; i++) {
			if(fruit[i] == min) return i;
		}
		return 0;
	}
	
	//[솔루션 함수]
	public int solution(int[][] fruit){
		int answer = 0;
		int n = fruit.length; //학생수 n명 뽑고
		int[] ch = new int[n];//체크용 배열 (교환시 체크)
		for(int i=0; i<n; i++) {
			//만약 현재 i번째 학생이 교환 이루어진 애면 그냥 continue 넘어감
			if(ch[i] == 1) continue;
			// 각 학생별로 배열 보냈을 때.최솟값이 유일값 아니면 그냥 넘어감 
			if(isMinUnique(fruit[i])== false) continue;
			
			//이제 j는 i보다 뒤쪽 학생들 순회용
			for(int j=i+1 ; j<n; j++) {
				if(ch[j] == 1) continue;
				if(isMinUnique(fruit[j]) == false) continue;
				//교환 전이면서 유일한 최솟값 과일 뽑아서 
				int a = getMinIndex(fruit[i]);
				int b = getMinIndex(fruit[j]);
				// a와 b 각각의 과일이 서로 다르면서 각 값은 0보다 큰 값이어야 함
				if(a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
					//=> 교환 이후에도 증가한 과일 개수가 여전히 바구니에서 최솟값 갖는 과일인지 확인하는 부분 
					//i 학생의 증가한 과일 개수가 감소한 과일개수보다 커야하고, j 학생의 증가한 과일 개수가 감소한 과일 개수보다 커야 한다. 
					if(fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) { 
						//교환처리
						fruit[i][a]++;
						fruit[i][b]--;
						
						fruit[j][b]++;
						fruit[j][a]--;
						//방문처리 
						ch[i]=1;
						ch[j]=1;
						//현재의 안쪽 for문 탈출 
						//교환은 최초 각 i에 대하여 한번씩만 가능하므로
						break; 
					}
				}
			}
		}
		//모든 학생 최솟값 갖는 애들 누적합하여 리턴
		for(int[] x : fruit) {
			answer += getMin(x);
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
		System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));	
		System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
		System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
	}
}