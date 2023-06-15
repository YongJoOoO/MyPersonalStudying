package to_0614_A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Sawon implements Comparable<Sawon>{
	int s; //서류 순위 
	int m;// 면접 순위 
	Sawon(int s, int m){
		this.s =s;
		this.m =m;
	}
	@Override
	public int compareTo(Sawon o) {
		// TODO Auto-generated method stub
		return this.s - o.s;
	}
}

public class Main {
	static int n;
	static ArrayList<Sawon> arr = new ArrayList<>();
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int tc = kb.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int t=0; t<tc ; t++) {
			
			n = kb.nextInt();//5
			for(int i=0; i<n ; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				arr.add(new Sawon(a, b));
			}
			Collections.sort(arr);
			int cnt = 0;
			int min = Integer.MAX_VALUE;
			
			for(Sawon s : arr) {
				if(min > s.m) {
					cnt++;
					min = s.m;
				}
			}
			
			answer.add(cnt);
		}
		
		for(int x : answer) {
			System.out.println(x);
		}
	}
}