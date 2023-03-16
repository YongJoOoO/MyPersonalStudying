package to_0316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 6-6. 장난 꾸러기
[입력]
첫 번째 줄에 자연수 N(5<=N<=100)이 주어진다.
두 번째 줄에 제일 앞에부터 일렬로 서있는 학생들의 키가 주어진다.
키(높이) 값 H는 (120<=H<=180)의 자연수 입니다.
[출력]
첫 번째 줄에 철수의 반 번호와 짝꿍의 반 번호를 차례로 출력합니다.*/
public class Main4 {
	public ArrayList<Integer> solution(int n, int[] arr){
		ArrayList<Integer> answer= new ArrayList<>();
		//이 문제의 경우, 정상 정렬된 배열과 입력받은 배열을 for(i)로 각각 비교하며 
		//바뀐 지점 찾으면 되는 문제이다.
		//1) 정렬 전에 기존 arr를 임시 tmp에 깊은 복사 clone 떠놓고 
		int[] tmp = arr.clone();
		//2) 이제 tmp를 정렬한다.
		Arrays.sort(tmp);
		
		//3) 각 i 값 비교하여 다른 지점이 바뀐 지점
		for(int i = 0; i<n;i++) {
			if(arr[i] != tmp[i]) answer.add(i+1); //바뀐 지점 담기 
		}	
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr= new int[n];
		for(int i=0; i<n;i++) arr[i] = kb.nextInt();
		
		for(int x : T.solution(n, arr)) System.out.print(x + " ");
	}
}