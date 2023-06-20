package to_0620_3;

import java.util.*;
/* 1934번. 최소공배수 
 * */
public class Main {
	//gcd() 함수 
	static int gcd(int a, int b) { //큰수, 작은수 (작은수==0) 이 되면 그때의 a 리턴 후 종료)
		if(b==0) return a;
		else {
			return gcd(b, a%b);//재귀함수 형태
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int T = kb.nextInt();
		ArrayList<Integer> arr =  new ArrayList<>();
		
		for(int t=0; t<T; t++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			int result = (a * b) / gcd(a, b);
			arr.add(result);
		}
		
		for(int x :  arr) {
			System.out.println(x);
		}
	}
}