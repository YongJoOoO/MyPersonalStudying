package to_0501;
/* 3-4. 피부과 문제풀이  -> 이중 for 돌지 않아야 함 */
import java.util.ArrayList;
class Person {
	int inTime;
	int outTime;
	Person(int inTime, int outTime){
		this.inTime = inTime;
		this.outTime =outTime;
	}
}
class Solution1 {
	//시간 HH:MM -> M분으로 변경 
	public int getTime(String x) {
		//HH
		int H = Integer.parseInt(x.split(":")[0]);
		int M = Integer.parseInt(x.split(":")[1]);
		return 60 * H + M;
	}
	//솔루션 함수 
	public int solution(int[] laser, String[] enter){
		int answer = 0;
		ArrayList<Person> arr = new ArrayList<>();
 		//환자 0번 제외부터 카운팅해야 함 
		for(int i =0; i<enter.length ;i++) {
			String x = enter[i];
			//들어온 시간 
			int InTime = getTime(x.split(" ")[0]);
			//시술 시간 
			int Ing = laser[Integer.parseInt(x.split(" ")[1])];
			//나가는 시간 
			int outTime = InTime + Ing;
			//여기에 담고 
			arr.add(new Person(InTime, outTime));
		}
		
		for(int i=0; i<arr.size(); i++) {
			int a= arr.get(i).inTime;
			int b= arr.get(i).outTime;
			int cnt = 0;
			
			for(int j = i+1; j<arr.size(); j++) {
				if(a < arr.get(j).inTime && b>arr.get(j).inTime) {
					cnt++;
				}
			}
			answer = Math.max(answer, cnt);
		}
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
	}
}