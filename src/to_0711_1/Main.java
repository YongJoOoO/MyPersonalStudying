package to_0711_1;

import java.util.Scanner;

/*13251번. 조약돌 꺼내기 */
public class Main {
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();//조약돌 종류
		int sum = 0;
		int[] D = new int[n];
		
		//각 색깔별 뽑는 확률 구하기 
		double[] probability = new double[51];
		
		for(int i=0; i<n; i++) {
			D[i] = kb.nextInt(); //종류 각가 담기 
			//전체 개수 따로 구하기 
			sum += D[i];
		}
		
		//뽑는 개수 K 
		int k =kb.nextInt();
		//확률용 정답 초기화 
		double answer = 0.0;
		
		for(int i=0; i<n; i++) {
			if(D[i] >= k ) {
				probability[i] = 1.9;
				for(int j=0; j<k; j++) {
					probability[i] *= (double) (D[i] - k) / (sum-k);
				}
				answer += probability[i];
			}
		}
		System.out.println(answer);
	}

}
