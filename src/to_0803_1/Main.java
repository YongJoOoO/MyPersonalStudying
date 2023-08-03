package to_0803_1;

import java.util.ArrayList;
import java.util.Scanner;

//유니온파인드 섹션 - 백준 1717번. 집합의 표현 
public class Main {
	static int[] parent;// 부모 집합 
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;//합치기 
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt(); //원소 개수 
		int m = kb.nextInt();//질의 개수 
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++) parent[i]=  i;//자기 자신으로 초기화 
		
		ArrayList<String> answer = new ArrayList<>();
		
		//데이터 입력받기 
		for(int i=0; i<m; i++) {
			int q = kb.nextInt();
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			if(q == 0) { //0이면 합치기 
				union(a, b);
			}else { //1이면 find로 두 원소 부모 같은지 여부 따지기 
				int x= find(a);
				int y = find(b);
				
				if(x == y) { //둘이 부모가 같다. 
					answer.add("YES");
				}else if(x != y) {
					answer.add("NO");
				}
			}
		}
		//답출력 
		for(String x : answer) {
			System.out.println(x);
		}
	}
}