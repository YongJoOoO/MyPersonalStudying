package to_0731_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*가장 높은 탑 쌓기 */
class Top implements Comparable<Top>{
	int s;//밑면 넓이 
	int h;//높이 
	int w;//무게
	Top(int s, int h, int w){
		this.s = s;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Top o) {
		if(this.s == o.s) return o.w - this.w;//무게 내리마순 
		return o.s - this.s;//기본 넓이 내림차순 
	}
}
public class Main{
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();//벽돌 개수 
		ArrayList<Top> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int s = kb.nextInt();
			int h = kb.nextInt();
			int w = kb.nextInt();
			arr.add(new Top(s, h, w));
		}
		Collections.sort(arr);
		//정렬된 pQ에서 dy[i] 정의 : 현재 벽돌 i를 포함한 최대 높이
		int dy[] = new int[N];
		//첫 번쨰 벽돌 세팅
		dy[0] = arr.get(0).h;
		int cur_s = arr.get(0).s;
		int cur_w = arr.get(0).w;
		int answer= 0;
		
		for(int i=1; i<N; i++) {
			int nx_s = arr.get(i).s;
			int nx_w = arr.get(i).w;
			int max = 0;
			for(int j=i-1; j>=0; j--) {
				//nx벽돌의 s보다 크고, w보다 무거운 벽돌이면서, dy[j]값이 가장 max인 애를 찾아서 
				if(nx_s < cur_s && nx_w <cur_w && max<dy[j]) {
					max = dy[j];//얘로 max 세팅한 뒤 
				}
			}
			dy[i] = max + arr.get(i).h;//현재 높이 누적 세팅 
			cur_s = nx_s;
			cur_w = nx_w;
			answer = Math.max(answer, dy[i]);//가장 큰 높이 세팅 
		}
		System.out.println(answer);
	}
}