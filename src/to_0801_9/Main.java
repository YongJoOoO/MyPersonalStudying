package to_0801_9;

public class Main {
	
	static int solution(int n, int[] nums) {
		int[][] dy = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i; j++) {
				if(nums[j] == nums[j+i]) {
					
				}
			}
		}
		return dy[1][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
