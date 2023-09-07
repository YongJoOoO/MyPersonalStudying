package to_0907_D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//RE
class Top implements Comparable<Top>{
	int s;
	int h; 
	int w;
	Top(int s, int h, int w){
		this.s= s;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Top o) {
		// TODO Auto-generated method stub
		return o.s - this.s;//넓이 내리맛누 
	}
}
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Top> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			arr.add(new Top(a, b, c));
		}
		Collections.sort(arr);//정렬
		int answer= 0;
		int[] dy = new int[n];
		dy[0] = arr.get(0).h;
		
		for(int i=1; i<n; i++) {
			int max_h = 0;
			for(int j = i-1; j>=0; j--) {
				if(arr.get(j).w > arr.get(i).w && dy[j] >max_h ) {
					//즉. j로 앞을 순회하면서, 현재i값보다 w무거우면서, dy[j]값이 가장 큰 값 선택 
					max_h = dy[j];
				}
			}
			//여기서 세팅
			dy[i] = max_h + arr.get(i).h;
			answer = Math.max(answer, dy[i]);
		}
		System.out.println(answer);
	}
}
