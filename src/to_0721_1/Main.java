package to_0721_1;
//코테 오답노트 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = {"011001", "101011", "111111", "011001"};
		
		int N= arr.length;
		int M = arr[0].length();
		//얘를 int[][] 로 바꿔주고 싶었음
		int[][] A = new int[N][M];
		
		for(int i=0; i<N; i++) {
			char[] tmp = arr[i].toCharArray();
			for(int j=0; j<M; j++) {
				//Character.getNumericValue() 했으면 끝날 일 
				A[i][j] = Character.getNumericValue(tmp[j]);
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

}
