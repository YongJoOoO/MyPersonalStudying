package to_0519_3;
// 제일 작은 수만 제거한 배열 리턴하는 문제
import java.util.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[] {-1};
        }
        
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(min > arr[i]) {
                min = arr[i];
            }
        }
    
        for(int i=0; i<arr.length; i++){
            if(arr[i] != min){
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}