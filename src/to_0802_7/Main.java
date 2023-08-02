package to_0802_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

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
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[] dy = new int[n];
		
		ArrayList<Brick> arr= new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a= Integer.valueOf(st.nextToken());
			int b= Integer.valueOf(st.nextToken());
			int c= Integer.valueOf(st.nextToken());
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
	
		ArrayList<Integer> ans = new ArrayList<>();
		
		int idx =dy.length -1;
		while(idx >= 0) {
			if(maxHeight == dy[idx]) {
				ans.add(arr.get(idx).num);
				maxHeight -= arr.get(idx).h;
			}
			idx--;
		}
		
		System.out.println(ans.size());
		
		for(int i=ans.size()-1; i>=0; i--) {
			System.out.println(ans.get(i));
		}
	
	}
}