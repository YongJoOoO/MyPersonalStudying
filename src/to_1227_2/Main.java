package to_1227_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 9613번. gcd 합 
 * @author MYLG
 *
 */
public class Main {
	static int gcd(int a, int b) {
		int r = a % b;
		if(r == 0) return b;
		else return gcd(b, r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int TC = kb.nextInt();
		
		for(int t = 0; t<TC; t++) {
			int n = kb.nextInt();
			int[] arr = new int[n];
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<n; i++) {
				arr[i] = kb.nextInt();
			}
			
			for(int i=0; i<n-1; i++) {
				int a = arr[i];
				for(int j = i+1; j<n; j++) {
					int b = arr[j];
					int g = gcd(a, b);
					list.add(g);
				}
			}			
			long sum = 0;
			for(int x : list) sum += x;
			
			System.out.println(sum);
		}
	}
}