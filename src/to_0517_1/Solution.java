package to_0517_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String x = Long.toString(n);
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<x.length(); i++) {
        	arr.add(Integer.valueOf(x.charAt(i)).intValue());
        }
        //내림차순 정렬 
        Collections.sort(arr, Collections.reverseOrder());
        
        String tmp = "";
        for(int i=0; i<arr.size(); i++) {
        	tmp += Integer.toString(arr.get(i));
        }
        
        answer = Long.parseLong(tmp);
        
        return answer;
    }
    public static void main(String[] args){
    	Solution T = new Solution();
    	Scanner kb = new Scanner(System.in);
    	long n = kb.nextLong();
    	
    	System.out.println(T.solution(n));
    }
    
}