package to_0427_1;

public class Main {
	public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        return answer;
    }
}
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        
        for(int i=1; i<=n; i++){
            answer[i-1] = x * i; 
        }
        
        return answer;
    }
}