package back_0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 백준 10798번. 세로읽기
[입력]
총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다. 
주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다. 
각 줄의 시작과 마지막에 빈칸은 없다.
[출력]
영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다. 
*/
public class Main {
	//솔루션 함수
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] chs = new char[5][15];		// 문자 넣을 char형 배열 선언 ( 세로 5 가로 15)
		
		for(int i = 0 ; i < chs.length; i++)
		{
			String str = br.readLine();		// 문자열을 5번 입력받고 
			
			for(int j = 0 ; j < str.length(); j ++)
			{
				chs[i][j]=str.charAt(j);		// 입력받은 문자열의 한문자 한문자 배열에 순서대로 넣어줌
			}
		}
		
		for(int i = 0 ; i < 15 ; i ++)
		{
			for(int j = 0 ; j < 5 ; j ++)
			{
				if(chs[j][i]==' ' || chs[j][i]=='\0')		// 출력을 할 떄, 참조한 인덱스가 공백 또는 null 문자 일 경우, 넘어가고 계속 진행 ( continue )
					continue;
				
				System.out.print(chs[j][i]);		// 세로로 문자를 하나씩 읽기
			}
		}
	}
}