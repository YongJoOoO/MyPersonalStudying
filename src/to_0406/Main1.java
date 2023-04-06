package to_0406;

import java.util.Scanner;

/* 10-3. 최대부분증가수열 LIS */ 
public class Main1 {
	static int[] dy;
	//솔루션 함수 
	static int solution(int [] arr) {
		int answer = 0;
		dy = new int[arr.length];
		dy[0]=1; //최초값은 길이 1
		answer = dy[0];//길이1 짜리 들어오는 것 대비
		
		//dy[i]에 담을 길이 = 처음 ~ i 직전까지 앞배열 탐색 아며
		//현재 arr[i]보다 값은 작으면서 길이 dy[]는 최대 갖는 애를 찾고 +1 
		for(int i=1; i<arr.length; i++) {
			int max = 0;
			for(int j= i-1; j>=0; j--) {
				if(arr[i] > arr[j] && dy[j] > max) max = dy[j];
			}
			//현재의 i 길이는 (자기보다 작은애들 중) 앞에서의 최대 길이 + 1
			dy[i] = max + 1; 
			//이제 answer = 기존 answer 보다 더 큰 dy[]나타나면 갱신됨
			answer = Math.max(answer, dy[i]);
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb= new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(arr));
	}
}