package to_0823_1;
import java.util.*;
//교육 과정 문풀 - 위상정렬 : 답이 여러 개면 그 중 아무거나 반환 
class Solution {
	//solution
	public String[] solution(String[] subjects, String[] course){
		
		int n= subjects.length;
		//각 과목에 대하여 번호로 마킹처리 
		HashMap<String, Integer> map = new HashMap<>();
		//순서대로 문자열과 번호를 이수 과목 번호로 
		for(int i=0; i<n; i++) map.put(subjects[i], i);//각 문자열과 번호 담기 
		
		//코스 배열 기준으로 ArrayList 그래프 생성 
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		//진입차수 
		int[] indegree = new int[n];
		
		
		for(int i=0; i<n; i++) { //과목별 정점 공간 생성 
			graph.add(new ArrayList<>());
		}
		//데이터 처리
		for(int i=0; i<course.length; i++) {
			int a = map.get(course[i].split(" ")[0]);//코스의 첫 번째 String 값을 기준으로 map의 번호를 가져옴
			int b = map.get(course[i].split(" ")[1]);//코스의 두 번째 String 값을 기준으로 map의 번호를 가져옴 
			
			//b 수강 후 a 를 수강 가능하므로 이 방향좌표를 graph 에 담기 
			graph.get(b).add(a);//b듣고 a들어라
			//진입차수 ++처리
			indegree[a]++;//a를 향하는 진입 차수 ++ 처리 
		}
		
		
		//위상 정렬 갈기자
		Queue<Integer> Q= new LinkedList<>();
		for(int i=0; i<n; i++) {
			if(indegree[i]==0) {
				Q.add(i);
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		String[] answer = new String[n];
		
		while(!Q.isEmpty()) {
			//하나 뽑기 
			int cur = Q.poll();
			//하나씩 담아야 하는데 
			arr.add(cur);
			for(int nx : graph.get(cur)) {
				indegree[nx]--;//cur이 가리키는 다음 정점들을 --처리 
				if(indegree[nx] == 0) {
					Q.add(nx);
				}
			}
		}
		
		//정답 세팅 
		for(int i=0; i<n; i++) {
			answer[i] = subjects[arr.get(i)];
		}
		
		return answer;
    }
	//main
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
		
		//System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
		//System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
		//System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
	}
}