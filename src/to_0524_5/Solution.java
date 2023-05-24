package to_0524_5;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        for(int x : numbers){
            answer += String.valueOf(x);
        }
        
        Integer[] tmp = new Integer[answer.length()];
        int i=0;
        for(char x : answer.toCharArray()) {
        	tmp[i] = Character.getNumericValue(x);
        	i++;
        }
        
        Arrays.sort(tmp, (a,b)->(b-a));
        answer = "";
        for(int k=0; k<tmp.length; k++) {
        	answer += String.valueOf(tmp[k]);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution T = new Solution();
    	
    	System.out.println(T.solution(new int[] {6, 10, 2}));
    }
}