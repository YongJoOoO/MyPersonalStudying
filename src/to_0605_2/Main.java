package to_0605_2;

import java.util.*;

public class Main {

	//add
	
	//remove
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int answer = 0; //정답세팅용 변수 
		
		int slen = kb.nextInt();//s길이
		int plen = kb.nextInt(); //p길이(부분)
		
		//전체 문자
		char[] s = new char[slen];
		for(int i=0; i<slen; i++) s[i] = kb.next().charAt(i);
		
		//체크용 배열 ACGT
		int[] chkArr = new int[4];
		for(int i=0; i<4; i++) chkArr[i] = kb.nextInt();
		
		//확인용 배열 ACGT 
		int[] myArr = new int[4];
		
		
		
		
	}

}
