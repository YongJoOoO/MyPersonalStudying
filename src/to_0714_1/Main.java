package to_0714_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*백준 문풀 LCS */
public class Main {
	static long[][] DP;
	static char[] A;
	static char[] B;
	static ArrayList<Character> Path;
	//실행 메인 
	 public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    A = br.readLine().toCharArray();
		    B = br.readLine().toCharArray();
		    
		    DP = new long[A.length + 1][B.length + 1];
		    Path = new ArrayList<Character>();
		    ///값 세팅할 건데 
		    for (int i = 1; i <= A.length; i++) {
		      for (int j = 1; j <= B.length; j++) {
		        //두 값이 같다며ㅏㄴ 왼쪽 대각선 +1
		    	if (A[i - 1] == B[j - 1]) {
		          DP[i][j] = DP[i - 1][j - 1] + 1; // 같은 문자열일 경우 왼쪽 대각선 값 +1
		        }else { //다르다면 더 큰 값으로 세팅 
		          DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]); // 다르면 왼쪽과 위의 값 중 큰수
		        }
		      }
		    }
		    System.out.println(DP[A.length][B.length]);
		   
		    getText(A.length, B.length);
		    
		    for (int i = Path.size() - 1; i >= 0; i--) {
		      System.out.print(Path.get(i));
		    }
		    System.out.println();
		  }
		  
		  private static void getText(int r, int c) { // LCS 출력함수
		    if (r == 0 || c == 0) return;
		    if (A[r - 1] == B[c - 1]) { // 같으면 LCS에 기록하고 왼쪽 위로 이동
		      Path.add(A[r - 1]);
		      getText(r - 1, c - 1);
		    } else {
		      if (DP[r - 1][c] > DP[r][c - 1]) // 다르면 왼쪽과 중 큰 수로 이동
		        getText(r - 1, c); 
		      else
		        getText(r, c - 1);
		    }
		  }
		}