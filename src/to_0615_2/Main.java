package to_0615_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*신입사원 - 그리디 RE */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int T = kb.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int t= 0; t<T; t++) {
			int n = kb.nextInt();
			int[][] A = new int[n][2];
			
			for(int i=0; i<n; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				A[i][0] = a;//성적 순위 
				A[i][1] = b; //면접 순위 
			}
			
			Arrays.sort(A, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[0]-o2[0];//0번쨰 성적 순위 기준 오름차순 정렬 
				}
			});
			//그리디 - 현재 뽑은 애를 기준으로만 생각
			int cnt = 1;
			int pivot = A[0][1];//면접 첫번쨰 인간 
			
			for(int i=1; i<n; i++) {
				if(pivot < A[i][1]) continue;//면접까지 뒤쳐지는 애는 패스
				cnt++;
				pivot = A[i][1];//면접 접수는 현재 선발자로 갱신
			}
			answer.add(cnt);
		}
		//정답 출력
		for(int x : answer) System.out.println(x);
	}
}