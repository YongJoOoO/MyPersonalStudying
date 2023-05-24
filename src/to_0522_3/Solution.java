package to_0522_3;

import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length;  i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        //맵에 있는 최대값이 k이상인 경우 
        if(Collections.max(map.values()) >= k) {
        	answer = 1;
        }else {
        	//가장 최대의 값 카운팅 --
        	while(k > 0 ) {
        		int max = Collections.max(map.values());
        		for(int key : map.keySet()) {
        			if(map.get(key) == max) {
        				map.put(key, map.getOrDefault(key, 0)-(k-max));
        				k -= max;
        				answer++;
        			}
        		}
        	}
        }
        
        return answer;
    }
}