package to_0407;
/* 9-8. 원더랜드 | 프림으로 풀기 : PriorityQueue 사용하기 */
import java.util.*;
class Edge1 implements Comparable<Edge1>{
    public int vex;
	public int cost;
    Edge1(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge1 ob){
        return this.cost-ob.cost;
    }
}
class Main3 {
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		ArrayList<ArrayList<Edge1>> graph = new ArrayList<ArrayList<Edge1>>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<Edge1>());
		}
		int[] ch=new int[n+1];
		for(int i=0; i<m; i++){
			int a=kb.nextInt();
			int b=kb.nextInt();
			int c=kb.nextInt();
			graph.get(a).add(new Edge1(b, c));
			graph.get(b).add(new Edge1(a, c));
		}
		int answer=0;
		PriorityQueue<Edge1> pQ = new PriorityQueue<>();
		pQ.offer(new Edge1(1, 0));
		while(!pQ.isEmpty()){
			Edge1 tmp=pQ.poll();
			int ev=tmp.vex;
			if(ch[ev]==0){
				ch[ev]=1;
				answer+=tmp.cost;
				for(Edge1 ob : graph.get(ev)){
					if(ch[ob.vex]==0) pQ.offer(new Edge1(ob.vex, ob.cost));
				}
			}
		}
		System.out.println(answer);
	}
}