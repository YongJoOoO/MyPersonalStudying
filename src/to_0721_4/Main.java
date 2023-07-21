package to_0721_4;
//DFS 로 문자열 만들기 

public class Main {
	static int N;
	static String tmp; 
	static boolean visited[];
	static String str;
	//직전에 쓴 문자열인지 판별 
	static boolean isPreSt(String a, char b) {
		int ed = a.length() -1;
		char tmp = a.charAt(ed);//끝자리 값 
		if(tmp == b) return true; //직전 문자랑 같은 문자
		
		return  false; //직전 문자랑 다른 문자 
	}
	//dfs
	static void DFS(char a , int lv, int idx) {
		if(N == lv) {
			if(isPreSt(str, a) == false) { //직전 문자랑 다른 경우 붙임
				str += a;	
			}
		}
		visited[idx] = true;
		
		for(int i=0; i<N; i++) {
			if(!visited[idx]) {
				if(isPreSt(str, a) == false) {
					str += tmp.charAt(i);
					
				}
			}
		}
		
		
		
		
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] answer = {};
		
		tmp = "abcda";
		N = tmp.length();
		visited = new boolean[N];
		char[] arr = tmp.toCharArray();
		for(int i=0; i<arr.length; i++) {
				
		}
		
		//시작점은 중복 되지 않게 
		char a = tmp.charAt(0);
		str = "";
		DFS(a, 1, 0);
		visited = new boolean[N];
		for(int i=1; i<N; i++) {
			if(a != tmp.charAt(i)) {
				str = "";//초기화
				DFS(tmp.charAt(i), 1, i); //중복되지 않게
				visited = new boolean[N];//복귀 후 
				a = tmp.charAt(i); //갱신
			}
		}
	}

}
