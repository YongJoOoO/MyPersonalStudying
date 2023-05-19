package to_0519_2;

import java.util.ArrayList;
import java.util.Arrays;

/*나누어 떨어지는 숫자 배열 (통과 ) */
class Solution {
	//솔루션 함수 
    public int[] solution(int[] arr, int divisor) {
        //기본 오름차순 정렬 
    	Arrays.sort(arr);
    	
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	for(int x : arr) {
    		if(x % divisor == 0) {
    			list.add(x);
    		}
    	}
        
        int[] answer = new int[list.size()];
    	System.out.println(list.size());
    
        return answer;
    }
}