package to_0907_C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*가장 높은 탑 쌓기 - DP*/
class Brick implements Comparable<Brick>{
	int m;//밑면
	int h;//높이
	int w;//무게 
	Brick(int m, int h, int w){
		this.m = m;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Brick o) {
		// TODO Auto-generated method stub
		return o.m - this.m;//큰 넓이 우선
	}
}
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		
		ArrayList<Brick> arr =new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int a= kb.nextInt();
			int b= kb.nextInt();
			int c = kb.nextInt();
			arr.add(new Brick(a, b, c));
		}
		Collections.sort(arr); //작은 밑면 우선 정렬 
		int answer= 0;
		int[] dy = new int[N];
		dy[0] = arr.get(0).h;
		
		for(int i=1; i<N; i++) {
			int max = 0;
			for(int j=i-1; j>=0; j--) {
				//이미 밑면은 정렬된 상태이므로 
				if(arr.get(j).w > arr.get(i).w && dy[j] > max) {
					max = dy[j];//그 값으로 세팅해오
				}
			}
			dy[i] = max + arr.get(i).h;
			answer = Math.max(answer, dy[i]);//가장 큰 값으로 세팅 
		}
		System.out.println(answer);
	}

}
