package to_0525_6;
import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        int len = strings.length;
        String[] answer = new String[len];
        
        ArrayList<Character> arr = new ArrayList<>();
        for(String x : strings){
            arr.add(x.charAt(n));
        }
        
        int a = 0;
        for(char x : arr){
            for(int i=0; i<len; i++){
            	if(strings[i].charAt(n) == x) {
            		answer[a] = strings[i];
            		a++;
            	}
            } 
        } 
        return answer;
    }
}