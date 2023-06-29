package to_0629_1;
class Solution {
    static int answer =0;
    //dfs
    static void dfs(int idx, int sum , int[] numbers, int target){
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }
        }
        else{
            dfs(idx+1, sum+numbers[idx], numbers, target);
            dfs(idx+1, sum-numbers[idx], numbers, target);
        }
    }
    
    //솔루션 함수 
    public int solution(int[] numbers, int target) {
            
        dfs(0, 0, numbers, target);
        
        return answer;
    }
}