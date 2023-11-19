package to_1119_5;
///////////////////////////////////////////////////////////////////////////////////////////// Test
//기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
//아래 표준 입출력 예제 필요시 참고하세요.
//표준 입력 예제
//int a = sc.nextInt();                 // int 변수 1개 입력받는 예제
//double b = sc.nextDouble();           // double 변수 1개 입력받는 예제
//long AB = sc.nextLong();              // long 변수 1개 입력받는 예제
//String str = sc.next();               // 문자열 1개 입력받는 예제
//char c = str.charAt(0);               // 입력받은 문자열에서 char 변수 1개 가져오는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
//표준 출력 예제
//int a = 0;
//double b = 1.0;
//long AB = 12345678901234567L;
//String str = "ABCDEFG";
//char c = 'b';
//System.out.println(a);                // int 변수 1개 출력하는 예제
//System.out.println(b);                // double 변수 1개 출력하는 예제
//System.out.println(AB);               // long 변수 1개 출력하는 예제
//System.out.println(str);              // 문자열 1개 출력하는 예제
//System.out.println(c);                // char 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

class Solution{
	
	static int N, P;
	static int[] arr1;
	static int[] arr2;
	
	static boolean[] visited;
	static int[] chk;
	static int max = Integer.MAX_VALUE;
	static ArrayList<Integer> answer;
	
	//DFS
	static void DFS(int lv, int sum) {
		if(lv == 4) {
			answer.add(sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			//1) 1번 비료
			chk[lv] = 1;
			visited[lv] = true;
			sum += arr1[i];
			if(lv != 0 && chk[lv] == 0 &&chk[lv-1] == 1) {
				sum -= P;
			}
			DFS(lv+1, sum+=arr1[i]);
			visited[lv] = false;
			
			//2) 2번 비료
			
			visited[lv] = true;
			chk[lv] = 2;
			if(lv != 0 && chk[lv] == 0 &&chk[lv-1] == 2) {
				sum -= P;
			}
			DFS(lv+1, sum+=arr2[i]);
			visited[lv] = false;
		}
		
	}

	//실행 메인 
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 sample_input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 sample_input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		*/
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		Scanner kb = new Scanner(System.in);

		int T = kb.nextInt();
		for (int test_case = 1; test_case <= T; test_case++){
			
			N = kb.nextInt();
			P = kb.nextInt();
			
			arr1 = new int[N];
			arr2 = new int[N];
			
			for(int i=0; i<N; i++) {
				arr1[i] = kb.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				arr2[i] = kb.nextInt();
			}
			
			//체크 배열
			chk = new int[N];
			visited = new boolean[N];
			answer = new ArrayList<>();
				
			DFS(0, 0);
			
			int max = Integer.MIN_VALUE;
			
			for(int x : answer) {
				max = Math.max(max, x);
			}	
			
			// 표준출력(화면)으로 답안을 출력합니다.
			System.out.println("#" + test_case + " "+ max);
		}

		kb.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
