package to_0907_G;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
     public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        for(int i = 0; i<numbers.length; i++) {
        	System.out.print(set.getClass());
        }
        
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }


    
    public static void main(String[] args) {
    	Scanner kb = new Scanner(System.in);
    	
    	Solution T = new Solution();
    	
    	System.out.println( T.solution(new int[] {2, 1, 3, 4, 1} ));
    }
    
}