package to_0407;
/* 9-7. 원더랜드 (최소 스패팅 트리 - 크루스칼 : Union&Find 활용)  */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//간선 정보 담을 객체
class Edge implements Comparable<Edge>{
	public int v1;
	public int v2;
	public int cost;
	Edge(int v1, int v2, int cost){
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost; //비용 기준 오름차순 정렬 
	}
}

public class Main1 {
	//집합 표현하는 배열  
	static int [] unf;
	//Find : 들어온 v가 소속된 집합 번호를 리턴해주는 함수 
	public static int Find(int v) {
		if(v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}
	//Union (a,b를 하나의 집합으로 만드는 함수)
	public static void Union(int a, int b) {
		int fa= Find(a);
		int fb = Find(b);
		if(fa != fb) unf[fa] = fb;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		unf = new int[n+1];
		ArrayList<Edge> arr = new ArrayList<>();
		for(int i=1; i<=n; i++) unf[i]= i;
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			arr.add(new Edge(a,b,c));
		}
		//최소비용 누적할 용 
		int answer = 0;
		//비용 오름차순 정렬 
		Collections.sort(arr);
		for(Edge ob : arr) {
			int fv1 = Find(ob.v1); //v1의 집합 번호 받고
			int fv2 = Find(ob.v2); //v2의 집합 번호 받음 
			//두 번호 동일한 경우 같은 집합 소속이므로 추가해서는 안됨 
			if(fv1 != fv2) { //둘이 다른 집합 소소의 정점인 경우에 한해서 
				answer += ob.cost;
				Union(ob.v1, ob.v2);//둘을 한 집합으로 묶어서 추가하기 
			}
		}
		System.out.println(answer);
	}
}