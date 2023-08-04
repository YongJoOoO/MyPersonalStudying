package to_0804_8;

import java.util.Arrays;
import java.util.Scanner;

//1759번. 암호만들기 
public class Main {
	static int L, C;
	static String answer;
	static String[] arr;
	
	//암호가 가능성 있는 구성인지 확인용 함수 
	static boolean findingAmho(String s) {
		int mo = 0, ja = 0;
		for(char x : s.toCharArray()) {
			if(x == 'a' || x == 'e' || x == 'i' || x =='o' || x =='u' ) {
				mo++;
			}else {
				ja++;
			}
		}
		if(mo >= 1 && ja >= 2) { //모음 1개 이상, 자음 2개 이상이어야 가능성있는 암호
			return true;
		}
		
		return false;
	}
	
	//DFS
	static void DFS(int v, String x, int lv) {
		if(lv== L) {		
			answer += x;//붙이고.
			if(findingAmho(x)) {
				System.out.println(x);
			}else return;
		}
		
		answer += x;//호출된 문자 덧붙인 뒤
		
		for(int i = v; i<C; i++) { //이 뒤에 올 문자에 대해 호출 
			DFS(i+1, arr[i], lv+1);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		L = kb.nextInt();//암호 개수 
		C = kb.nextInt();//구성 가능한 문자들
		
		String tmp = kb.nextLine();
		
		arr = tmp.split(" ");//자르고
		
		Arrays.sort(arr);//정렬시켠놓고
		
		int len = C-L;
		
		
		
		
	}

}
