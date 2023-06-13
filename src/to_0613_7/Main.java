package to_0613_7;

import java.util.*;

/*10816번, 숫자 카드 2 - 이분 탐색 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();
		int[] arr1 = new int[N];
		
		for(int i=0; i<N; i++) arr1[i] = kb.nextInt();
		
		int M = kb.nextInt();
		int[] arr2 = new int[M];
		
		for(int i=0; i<M; i++) arr2[i] = kb.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		//탐색 대상 데이터 정렬
		Arrays.sort(arr1);
		
		for(int i=0; i<M; i++) {
			int target = arr2[i];
			
			int st = 0;
			int ed = arr1.length -1;
			
			int cnt = 0;//현재타겟값에 대한 카운팅용 
			
			while(st<=ed) {
				int mid = (st+ed)/2;
				int mVal = arr1[mid];
				
				if(target <= mVal) {
					ed = mid;
				}else {
					st = mid+1;
				}
					
			}
			arr.add(cnt);
		}
		
		for(int x : arr) System.out.print(x+" ");
	}

}
