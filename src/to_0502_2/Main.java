package to_0502_2;
import java.util.*;
/* 11866번. 요세푸스 문제 0*/
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> Q= new LinkedList<>();
		//1) 일단 다 담고 
		for(int i=1; i<=n; i++) {
			Q.offer(i);
		}
		//2) k-1까지는 poll해서 다 뒤로 보내고
		//k번째 값은 poll한 뒤 출력후 삭제 
		System.out.print("<");
		while(Q.size()>0 ) {
			for(int i =0; i<k-1; i++) {
				Q.add(Q.poll());
			}
			System.out.print(Q.poll());
			if(Q.size() > 0) {
				System.out.print(", ");
				
			}
		}
		System.out.print(">");		
	}
}