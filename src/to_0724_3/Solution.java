package to_0724_3;
import java.util.*;
//스프링쿨러 문제 풀이
class Solution {
	public int solution(int n, int[] nums){
		int answer = 0; 
		int[][] line = new int[nums.length+1][2];
		//세팅  
		for(int i=0; i<=n; i++) {//각 로프i를 사용했을 때
			line[i][0] = Math.max(0, i-nums[i]);//범위 시작값 (0은 안벗어나게)
			line[i][1] = Math.min(n, i+nums[i]);//범위 끝값  (n은 안벗어나게) 
		}
		//왼쪽 시작값 기준 오름차순 정렬
		Arrays.sort(line, (a, b)-> a[0]-b[0]);//시작값 기준 정렬 
		
		int st = 0, ed = 0, i=0;
		while(i<line.length) {
			//시작점이 st보다 작거나 같은 스프링쿨러들 중에서 가장 길게 뿌릴 수 있는 애 찾는 거임 
			if(line[i][0] <= st) {
				ed = Math.max(ed, line[i][1]);	//끝점이 기존ed보다 큰 애 발견 시, 갱신
				i++;
			}
			answer++;
			if(ed == n) return answer; //끝점 다으면 종료
			//위를 거쳐왔는데 ed값이 갱신 안되고 st=ed값이 됐다면 조건에 만족하는 애 없다는 거니 -1 리턴
			if(st == ed) return -1; //시작점이 ed가 되어 버리면 -1리턴
			st = ed;//이제 시작점을 다시 끝점으로 갱신 <-얘를 기준으로 선택
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
		System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));		
		System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
		System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
	}
}