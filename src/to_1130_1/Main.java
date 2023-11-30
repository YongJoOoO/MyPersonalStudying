package to_1130_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 4803번. 트리 - 자바 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int[] parent;
	
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	//union
	  static void union(int a, int b){
	        a= find(a);
	        b = find(b);
	        if(a!=b){
	            if(parent[a]==-2){
	                parent[b] = a;
	            }
	            else if(parent[b]==-2){
	                parent[a] = b;
	            }
	            else if(parent[a] < 0){
	            	parent[b] = a;
	            }
	            else {
	            	parent[a] = b;
	            }
	        }
	    }
	
	//실행 메인 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int idx = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N ==0 && M == 0) break;
			parent = new int[N+1];
			for(int i=1; i<=N; i++) parent[i] = i;
			
			//데이터 입력
            for(int i=0; i<M; i++){
                int n1 = Integer.parseInt(st.nextToken());
                int n2 =Integer.parseInt(st.nextToken());

                n1 = find(n1);
                n2 = find(n2);

                if(n1==n2){
                    parent[n1] = -2;
                }
                else{
                    union(n1,n2);
                }
            }
            
			int treeNum = 0;
            for(int i=1; i<=N; i++){
                if(parent[i]==-1) treeNum+=1;
            }
		
			
			if(treeNum == 0) {
				sb.append("Case " + idx +": ").append("No trees.\n");
			}else if(treeNum == 1) {
				sb.append("Case " + idx +": ").append("There is one tree.\n");
			}else if(treeNum > 1) {
				sb.append("Case " + idx +": ").append("A forest of "+ treeNum+" trees.\n");
			}			
			idx++;
		}	
	}
}