package to_0605_7;

import java.util.Scanner;
public class Main {
	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String str = sc.next();
	    int[] A = new int[str.length()];
	    for (int i = 0; i < str.length(); i++) {
	      A[i] = Integer.parseInt(str.substring(i, i + 1));
	    }
	    for (int i = 0; i < str.length(); i++) {
	      int Max = i;
	      //i 뒷부분에서 가장 max값 찾고 
	      for (int j = i + 1; j < str.length(); j++) {
	        if (A[j] > A[Max])  //내림차순이므로 최대 값을 찾음
	          Max = j;
	      }
	      //i로 찍은 값보다 max로 찍은값이 더 크면 두 값 swap
	      if (A[i] < A[Max]) {
	        int temp = A[i];
	        A[i] = A[Max];
	        A[Max] = temp;
	      }
	    }
	    //정답 출력 
	    for (int i = 0; i < str.length(); i++) {
	      System.out.print(A[i]);
	    }
	  }
}