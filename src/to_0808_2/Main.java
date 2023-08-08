package to_0808_2;

import java.util.Scanner;

/*팰린드롬 다시 풀기 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr =new int[n+1];
		
		for(int i=1; i<=n; i++) arr[i] = kb.nextInt();
		
		int[][] dy = new int[n+1][n+1];
		
		for(int i=1; i<n; i++) { //길이 1 ~ n-1까지 존재 
			for(int j=1; j<=n-i; j++) {
				if(arr[j] == arr[j+i]) {
					//양 끝 값 같으면 
					dy[j][j+i] = dy[j+1][j+i-1]; //내부 값 
				}else {
					dy[j][j+i] = Math.min(dy[j][j+i-1], dy[j+1][j+i]) +1;
				}
			}
		}
		System.out.println(dy[1][n]);//출력 
	}

}
