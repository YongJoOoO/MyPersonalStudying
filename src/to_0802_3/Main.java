package to_0802_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Top implements Comparable<Top>{
	int num; //최초 번호 
	int s;//밑면 넓이
	int h;//높이
	int w;//무게
	Top(int num, int s, int h, int w){
		this.num = num;
		this.s = s;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Top o) {
		// TODO Auto-generated method stub
		return o.s - this.s;//기본 넓이 큰 거 우선 내림차순 정렬
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		
		ArrayList<Top> arr = new ArrayList<>();
			
		for(int i=0; i<N; i++) {
			int s = kb.nextInt();
			int h = kb.nextInt();
			int w= kb.nextInt();
			
			arr.add(new Top(i+1, s, h, w));//데이터 삽입
		}
	
		//넓이 큰 순서로 정렬 
		Collections.sort(arr);
		
		int answer =0;//개수 셀 용도고 
		ArrayList<Integer> ans = new ArrayList<>();// 사용 번호 담기 
	
		int[] dy = new int[N+1];//현재 i번쨰 블럭 쌓아서 올릴 수 있는 최대 높이 
		
		dy[0]= 0;
		dy[1] = arr.get(0).h;
		
		for(int i=1; i<N; i++) {//현재 벽돌 i로 찍기 
			int max =0;
			for(int j=i; j>=0; j--) { //앞 벽돌 순회 
				if(arr.get(j).w < arr.get(i).w && max < dy[j]) {
					max = dy[j];
				}
			}
			dy[i+1] = max + arr.get(i).h;
		}
		
		
	}

}
