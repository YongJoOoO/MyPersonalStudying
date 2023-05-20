package to_0520_2;

class Solution {
    public int solution(int n) {
        int cnt = 1; //자기 자신은 카운팅 하기 
        for(int i=1; i<n; i++){
            int tmp = 0;
            while(tmp > 15){
                tmp += i;
                i++;
                if(tmp == 15){
                    cnt++; 
                }
            }
        }  
        return cnt;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution T = new Solution();
		System.out.println(T.solution(15));
	}
}