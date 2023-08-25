package to_0825_B;

import java.util.*;

//1738번 골목길 - 벨만포드 
class Edge{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
}
public class Main {
	static int n, m;
	static int[] distance;
	static ArrayList<Edge> edges;
	static int[] parent;
	//bellmanFord
	static boolean bellmanFord() {
		//최솟값으로 초기화
		Arrays.fill(distance, Integer.MIN_VALUE);
		parent = new int[n+1];
		
		//시작점 처리 
		distance[1]= 0;
		
		for(int i=1; i<n; i++) { //n-1번 반복 
			for(int j=0; j<edges.size(); j++) {
				Edge ed = edges.get(j);
				//더 큰 가중치 나오면 
				if(distance[ed.e] < distance[ed.s] + ed.val) {
					//값 갱신 
					distance[ed.e] = distance[ed.s] + ed.val;
					parent[ed.e] = ed.s;//직전 정점 담기 
				}
			}
		}
		
		//1번 더 반복해서 만약에 업데이트 되는 값 존재한다면 ?
		for(int i=0; i<edges.size() ; i++) {
			Edge ed = edges.get(i);
			if(distance[ed.e] < distance[ed.s] + ed.val) {
				return true;//최적 경로 안존재함 - 음수 사이클 
			}
		}
		return false; //음수 사이클 없음 
	}
	
	static int find(int a) {
		if(a==parent[a]) return a;
		else {
			return parent[a]= find(parent[a]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		//초기화 
		edges = new ArrayList<>();
		distance= new int[n+1];
		for(int i=0; i<m; i++) {
			int u = kb.nextInt();
			int v = kb.nextInt();
			int val = kb.nextInt();
			//일방통행이므로 
			edges.add(new Edge(u, v, val));
		}
		
		boolean flag = bellmanFord();

		if (flag) {
		    // 음수 사이클이 존재했다면
		    System.out.println("-1");
		} else {
		    List<Integer> path = new ArrayList<>();
		  
		    int cur = n; //5부터
		    while(cur!=1){
		    	path.add(cur);
		    	cur = parent[cur];
		    }
		    path.add(1);
		    for(int i=path.size()-1; i>=0; i--) {
		    	System.out.print(path.get(i)+" "); // -> 메모리 초과가 계속 뜨는 이유는 ?????????????
		    }
		}
	}
}