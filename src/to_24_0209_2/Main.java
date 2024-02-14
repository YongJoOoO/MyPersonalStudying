package to_24_0209_2;

import java.util.Scanner;

/**
 * 14425번. 문자열 집합 - 트라이 문풀
 * @author MYLG
 *
 */
class tNode{
	tNode[] next = new tNode[26]; //영어 26문자 
	boolean isEnd;//단말 노드 여부 
}
public class Main {
	static int N, M;
		
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);

		N = kb.nextInt();
		M = kb.nextInt();
		/**
		 * N개 문자열을 하나의 집합 S에 포함되는 Trie 형태로 구성
		 */
		tNode root = new tNode();
		while(N > 0) {
			String text = kb.next();
			tNode now = root;
			for(int i=0; i<text.length(); i++) {
				char c = text.charAt(i);
				//26개 알파벳 위치배열 idx로 나타내기 위함 -'a' 수행
				if(now.next[c-'a'] == null) {//다음이 없다면 객체 생성해주고, 
					now.next[c-'a'] = new tNode();
				}
				now = now.next[c-'a'];//now 갱신 
				//마지막 글자 단말노드로 처리
				if(i == text.length() - 1) now.isEnd = true;
			}
			N--;
		}
		
		int cnt = 0;
		while(M > 0) {
			String txt = kb.next();
			tNode now = root;
			for(int i=0; i<txt.length(); i++) {
				char c = txt.charAt(i);
				if(now.next[c-'a'] == null) {
					break;
				}
				now = now.next[c-'a'];
				if(i == txt.length()-1 && now.isEnd) {
					cnt++;
				}
			}
			M--;
		}
		
		System.out.println(cnt);
	}
}