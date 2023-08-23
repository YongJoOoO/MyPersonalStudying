package to_0823_4;
import java.util.*;
//교육 과정- 위상정렬 문풀
class Solution {
	public String[] solution(String[] subjects, String[] course){
		
		int n= subjects.length;
		//번호 마킹 <key, 값>
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			map.put(subjects[i], i);//번호 
		}
		//그래프 생성 
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++) graph.add(new ArrayList<>());
		
		int[] indegree = new int[n];
		
		//데이터 삽입
		for(int i=0; i<course.length; i++) {
			int a = map.get(course[i].split(" ")[0]);
			int b = map.get(course[i].split(" ")[1]);
			
			//방향 그래프 b 듣고 a 들어야 한다.
			graph.get(b).add(a);
			//진입차수 처리
			indegree[a]++;
		}
		
		//위상정렬 시작 
		Queue<Integer> Q= new LinkedList<>();
		//정답 세팅ㅎ 번호
		ArrayList<Integer> arr = new ArrayList<>();
		String[] answer = new String[n];//레알 정답용 
		
		for(int i=0; i<n; i++) {
			if(indegree[i]==0) {
				Q.offer(i);
			}
		}
	
		while(!Q.isEmpty()) {
			int cur = Q.poll();//진입차수 0인애 하나 뽑음
			arr.add(cur);//번호만 담기 
			for(int nx : graph.get(cur)) {
				//뽑은 정점이 가리키는 정점들의 진입차수를 -처리
				indegree[nx]--;
				if(indegree[nx] == 0) {
					Q.add(nx);
				}
			}
		}
		
		//정답 세팅 
		for(int i=0; i<n; i++) {
			//arr에 담은 과목 번호 순서대로 -> subject의 각 과목 번호에 접근하여 그 번호로 answer[i]를 세팅
			answer[i] = subjects[arr.get(i)];
		}

		return answer;
    }
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));

		//System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
		//System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
		//System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
	}
}