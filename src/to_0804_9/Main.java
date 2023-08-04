package to_0804_9;

import java.util.Scanner;

/*1759번. 암호 만들기 */
public class Main {
	static int L, C;
	static boolean[] visited;
	static String[] arr;
	
	//구성이 유효한지 판별 
	static boolean isValid(String x ) {
		int mo = 0, ja = 0;
		for(char c : x.toCharArray()) {
			if(c == 'a' || c =='e' || c=='i'|| c== 'o' || c =='u') {
				mo++;
			}
			else ja++;
		}
		
		if(mo >= 1 && ja >= 2) return true;
			
		return false;
	}
	
	//DFS
	static void DFS(int v, int lv, String answer) {
		if(lv == L) {
			answer += arr[v];
			if(isValid(answer)) {
				System.out.println(answer);
			}else return;
		}
		
		visited[v] = true;
		answer += arr[v];
		
		for(int i=v; i<C; i++) {
			if(!visited[i]) {
				answer += arr[i];//누적 시키고 
				DFS(i, lv++, answer);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		L = kb.nextInt();
		C = kb.nextInt();
		
		String tmp = kb.nextLine();
		
		arr = tmp.split(" ");
		
		
		visited = new boolean[C];
		
		DFS(0, 0, "");
		
	}

}
