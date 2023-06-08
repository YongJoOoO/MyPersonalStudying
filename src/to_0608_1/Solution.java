package to_0608_1;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        //중복 제거 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        //HashMap에 존재하는 key값을 사이즈만큼 돌면서 asnwer에 담으면 됨 
        int[] answer = new int[map.size()];
        int k =0;
        for(int key : map.keySet()) {
        	answer[k] = key;
        	k++;
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
}
