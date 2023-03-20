package back_0320_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 2751번. 수 정렬하기 2 
 * */
public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n =kb.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) arr.add(kb.nextInt());
		
		//정렬
		Collections.sort(arr);
		

		for(Integer c : arr) {
			sb.append(c).append("\n");
		}
		System.out.println(sb);
	}
}