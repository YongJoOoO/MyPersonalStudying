package back_0221;

import java.util.Scanner;

public class Main {

	//실행 메인
	public static void main(String[] args) {
	     Scanner in = new Scanner(System.in);
	        int T = in.nextInt();
	        int[] R = new int[T];
	        String[] S = new String[T];

	        for (int i=0;i<T;i++) {
	            R[i]=in.nextInt();
	            S[i]=in.next();
	        }

	        for (int i=0;i<T;i++) {
	            for (int j=0; j<S[i].length();j++) {
	                for (int x=0; x<R[i];x++) {
	                    System.out.print(S[i].charAt(j));
	                }
	            }
	            System.out.println();
	        }
	    }
}