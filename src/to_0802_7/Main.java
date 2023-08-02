package to_0802_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

class Brick implements Comparable<Brick>{
	int num, s, h, w;
	Brick(int num,int s, int h, int w) {
		this.num = num;
		this.s= s;
		this.h =h;
		this.w =w;
	}
	@Override
	public int compareTo(Brick o) {
		// TODO Auto-generated method stub
		return o.s-this.s;//밑면 내림차순 정렬  
	}
}
public class Main {
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n =kb.nextInt();
		
		int[] dy = new int[n];
		
		ArrayList<Brick> arr= new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a= kb.nextInt();
			int b= kb.nextInt();
			int c= kb.nextInt();
			arr.add(new Brick(i+1, a, b, c));
		}
		Collections.sort(arr);
		
		int maxHeight = -1;
		
		for(int i=0; i<n; i++) {
			int max = 0;
			for(int j=i; j>=0; j--) {
				if(arr.get(i).w < arr.get(j).w && max < dy[j]) {
					max = dy[j];
				}
			}
			dy[i] = max + arr.get(i).h;
			maxHeight = Math.max(maxHeight, dy[i]);
		}
		Stack<Integer> st = new Stack<>();
		
		int idx=n-1;
		while(idx >= 0) {
			if(maxHeight == dy[idx]) {
				st.push(arr.get(idx).num);
				maxHeight -= arr.get(idx).h;
			}
			idx--;
		}
		System.out.println(st.size());
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}
}