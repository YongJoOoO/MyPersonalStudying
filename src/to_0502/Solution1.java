package to_0502;
/* 3-3. 현관문 출입 순서 | 진짜 개어렵다. ..  */
import java.util.*;
class Solution1 {
	//솔루션 함수 
	public int[] solution(int[] arrival, int[] state){
		//들어오는 대기열 
		Queue<Integer> enter = new LinkedList<>();
    	//나가는 대기열 
		Queue<Integer> exit = new LinkedList<>();
    	int n = arrival.length, prev = 1;
    	int[] answer = new int[n];
    	for(int t = 0, i = 0, cnt = 0; ; t++){
        	if(enter.isEmpty() && exit.isEmpty() && i < n) {
            		if(t < arrival[i]){
                			t = arrival[i];
                			prev = 1;
            		}
        	}
        	while(i < n && arrival[i] <= t) {
            		if (state[i] == 0) enter.offer(i);
            		else exit.offer(i);
           		i++;
       		}
        	if(prev == 1) {
            		if(!exit.isEmpty()) {
                			answer[exit.poll()] = t;
                			prev = 1;
           	 	}
            		else{
                			answer[enter.poll()] = t;
                			prev = 0;
            		}
        	}else if(prev == 0) {
            		if(!enter.isEmpty()) {
                			answer[enter.poll()] = t;
                			prev = 0;
            		}else{
                			answer[exit.poll()] = t;
               			 prev = 1;
            		}
        	}
        	cnt++;
        	if(cnt == n) break;
    	}
    	
    	return answer;
	}
		
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
		System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
		System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
	}
}