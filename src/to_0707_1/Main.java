package to_0707_1;

/*백준 1414번. 불우이웃 돕기 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int N, sum;
	static PriorityQueue<lEdge> queue;
	//실행 메인 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		queue = new PriorityQueue<>();
		//N개의 입력을 받을 건데 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] tempc = st.nextToken().toCharArray();
			//각 문자로 바뀐 j번째 값에 대하여 숫자 형태로 바꿔줄 거임 
			for (int j = 0; j < N; j++) {
				int temp = 0;
				//소문자일 경우 
				if (tempc[j] >= 'a' && tempc[j] <= 'z')
					temp = tempc[j] - 'a' + 1;
				//대문자일 경우
				else if (tempc[j] >= 'A' && tempc[j] <= 'Z')
					temp = tempc[j] - 'A' + 27;
				
				//총 랜선 길이 누적합 
				sum = sum + temp; // 총 랜선의 길의 저장
				//i!=j : 다른 컴터끼리만 연결한대쓰니까. 그리고 가중치 0이아니어야 존재하는 랜선이기 때문 
				if (i != j && temp != 0)
					queue.add(new lEdge(i, j, temp)); //큐에 Edge 형태로 담기 
			}
		}
		//결합 상태를 위해 부모 배열 생성 
		parent = new int[N];
		//자기 자신을 저장 
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;
		//-> 최소비용 신장트리 알고리즘 수행 
		int useEdge = 0; //사용된 간선 카운팅 - N-1까지
		int result = 0; //최소비용 가중치 누적용 
		//큐가 비지 않을 때까지 반복 
		while (!queue.isEmpty()) { // 최소 신장 트리 알고리즘을 수행하여 줍니다.
			lEdge now = queue.poll();
			if (find(now.s) != find(now.e)) { // 같은 부모가 아니라면 -> 연결 가능
				union(now.s, now.e);
				result = result + now.v;
				useEdge++;
			}
		}
		//큐 비어서 빠져나온 상태가 간선 N-1개만 사용했으면 : 최대값 = 전체 - 최소비용 
		if (useEdge == N - 1)
			System.out.println(sum - result);
		else //그 외의 간선 사용하면 연결 못한 것이므로 -1 출력 
			System.out.println(-1);
	}
	//유니온 
	public static void union(int a, int b) { // union 연산 : 대표 노드끼리 연결하여 줌
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
	}
	//find
	public static int find(int a) { // find 연산
		if (a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]); // 재귀함수의 형태로 구현 -> 경로 압축 부분
	}
}
//Edge 클래스 
class lEdge implements Comparable<lEdge> {
	int s, e, v;

	lEdge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}
	@Override
	public int compareTo(lEdge o) {
		return this.v - o.v;
	}
}