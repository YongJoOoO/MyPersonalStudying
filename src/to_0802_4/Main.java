package to_0802_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*2655번. 가장 높은 탑 쌓기 */
class Brick implements Comparable<Brick>{
	int num, s,h,w;
	
	Brick(int num, int s, int h, int w){
		this.num = num;
		this.s =s;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Brick o) {
		// TODO Auto-generated method stub
		return o.s - this.s;//밑면 내리마순 정려 
	}
}
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		
		ArrayList<Brick> arr = new ArrayList<>();
		arr.add(new Brick(0,0,0,0)); //0부터 시작하니까 임시로 하나 두고 
		
		for(int i=1; i<=N; i++) {
			int s=  kb.nextInt();
			int h = kb.nextInt();
			int w= kb.nextInt();
			
			arr.add(new Brick(i, s, h, w));
		}
		
		//정렬
		Collections.sort(arr);
		
		Stack<Integer> ans = new Stack<>();//역순 출력해야 하니까 
		
		int[] dy = new int[N+1];
				
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if(arr.get(i).w < arr.get(j).w ) {
					dy[i] = Math.max(dy[i], dy[j] + arr.get(i).h);
				}
			}
		}
		
		for(int x : dy) {
			System.out.println(x);
		}
		/*
		int maxHeight = -1;
		
		for (int i=0; i<=N; i++) {
			if (maxHeight < dy[i]) maxHeight = dy[i];
		}
		
		int index = N;
		ArrayList<Integer> result = new ArrayList<>();
		
		while (index!=0) {
			if (maxHeight == dy[index]) {
				result.add(arr.get(index).num);
				maxHeight -= arr.get(index).h;
			}
			index--;
		}
		
		System.out.println(result.size());
		for (int i=result.size()-1; i>=0; i--) {
			System.out.println(result.get(i));
		}
		
		*/
	}

}
