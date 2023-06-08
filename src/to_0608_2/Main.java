package to_0608_2;
/*백준 11724번. 연결 요소의 개수 
 *  연결 요소의 개수 = 만약 모든 노드가 연결되어있다면 깊이있게 쭉 순회하여 DFS 최초 호출1 로 모두 리턴 받으니 cnt = 1일 것이다.
 *  즉, 모든 노드 탐색을 위해 실행한 DFS의 횟수가 == 연결 요소의 개수가 되는 것.
 * */ 
import java.io.*;
import java.util.*;
public class Main {
	//정절 변수 선언
  static ArrayList<Integer>[] A;
  static boolean visited[];
  
  //DFS 함수 
  static void DFS(int v) {
    if (visited[v]) {
      return;
    }
    visited[v] = true;
    for (int i : A[v]) {
      if (visited[i] == false) { // 연결 정점 중 방문하지 않았던 정점만 탐색함
        DFS(i);
      }
    }
  }
  
  //실행 메인 
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    A = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    
    for (int i = 1; i < n + 1; i++) { // 인접 리스트 초기화
      A[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      A[s].add(e); // 양 방향 간선이므로 양쪽으로 간선을 더 해준다
      A[e].add(s);
    }
    int count = 0;
    for (int i = 1; i < n + 1; i++) {
      if (!visited[i]) { // 미 방문한 정점이 없을 때까지 반복
        count++;
        DFS(i);
      }
    }
    System.out.println(count);
  }
}
