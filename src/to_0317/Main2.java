package to_0317;
/* 6-9. 뮤직비디오 | 결정 알고리즘 
[입력]
첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.
[출력]
첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.
*/

import java.util.*;
class Main2 {
	//주어진 DVD 1개당 '용량'으로 전체 arr 용량을 몇개의 DVD에 담아내는지 확인  
	public int count(int[] arr, int capacity){
		int cnt=1, sum=0;
		for(int x : arr){
			//각 DVD 뽑아서 sum에 누적시킨 값이 용량 이상일 경우
			//다음 DVD로 카운팅 해야 함
			if(sum+x>capacity){
				cnt++;//다음 DVD에 담도록 
				sum=x;//새롭게 담길 현재 곡의 용량 x로 다시 세팅
			}
			else sum+=x;//용량아직 안벗어났으면 계속 누
		}
		return cnt;
	}

	public int solution(int n, int m, int[] arr){
		int answer=0;
		int lt=Arrays.stream(arr).max().getAsInt();
		int rt=Arrays.stream(arr).sum();
		//이분 검색하여 범위 좁히자
		while(lt<=rt){
			//이분 검색하여 범위 좁히자
			int mid=(lt+rt)/2;
			//2) 비교 후, 왼쪽 범위에서 다시 찾아봄 
			if(count(arr, mid)<=m){
				answer=mid; //우선 답 세팅
				rt=mid-1;//더 좁혀나가볼 것
			}//3) 비교 후, 오른쪽 범위에서 다시 찾아봄 
			else lt=mid+1;
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		System.out.println(T.solution(n, m, arr));
	}
}