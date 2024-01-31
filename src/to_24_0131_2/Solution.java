package to_24_0131_2;
import java.util.*;

class Solution {
    static int diceCount;
    static boolean[] visited;
    static List<int[]> A = new ArrayList<>();
    static List<int[]> B = new ArrayList<>();

    static int[] result;
    static List<Integer> AdiceResult;
    static List<Integer> BdiceResult;

    /**
     * 재귀로 모든 주사위 종류 N/2 개로 쪼갠다. (A, B) 에게 나눔
     */
    static void combination(int index, int count) { //N/2개 만큼 깊이 구성 
        if(count == diceCount / 2) {
            int[] Atmp = new int[diceCount / 2];
            int[] Btmp = new int[diceCount / 2];
            int tmpIndex = 0;
            int tmpIndex2 = 0;
            for(int i = 0; i < diceCount; i++) {
                if(visited[i]) { //방문 체크한 쪽은 
                    Atmp[tmpIndex] = i + 1; //A주사위에 담음 
                    tmpIndex++;
                }
                if(!visited[i]) {//방문 X 인 곳은 
                    Btmp[tmpIndex2] = i + 1; //B주사위에 담음 
                    tmpIndex2++;
                }
            }
            A.add(Atmp);
            B.add(Btmp);
            return;
        }
        
        //전체 주사위 순회하면서 
        for(int i = index; i < diceCount; i++) {
            visited[i] = true; //방문 
            combination(i + 1, count + 1);//더 깊이 탐색 
            visited[i] = false; //방문 체크 제거 
        }
    }
    //계산 함수 - 재귀로 합
    static void calculate(int index, int[] dices, int[][] originDices, int sum, List<Integer> team) {
        if(index == dices.length) {
            team.add(sum);
            return;
        }

        for(int i = 0; i < 6; i++) {
            calculate(index + 1, dices, originDices, sum+originDices[dices[index]-1][i], team);
        }
    }
    
    //솔루션 함수 
    public int[] solution(int[][] dice) {
        diceCount = dice.length;//전체 주사위 개수 
        visited = new boolean[diceCount]; //방문 처리용
        
        combination(0, 0); 
        
        //최고 승률 갖는 조합을 발견하기 위해 max, idx 초기화
        int max = Integer.MIN_VALUE;
        int index = 0;
        
        for(int i = 0; i < A.size(); i++) {
            AdiceResult = new ArrayList<>();
            BdiceResult = new ArrayList<>();
            
            //A, B의 조합 각각에 대한 
            calculate(0, A.get(i), dice, 0, AdiceResult);
            calculate(0, B.get(i), dice, 0, BdiceResult);
            
            Collections.sort(AdiceResult);
            Collections.sort(BdiceResult);

            int totalWinCount = 0;

            for(int a : AdiceResult) {
                int left = 0 ;
                int right = BdiceResult.size();
                
                while(left+1<right) {
                    int mid = (left+right) /2 ;
                    
                    if(a > BdiceResult.get(mid)) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                totalWinCount += left;
            }
            if(max < totalWinCount) {
                max = totalWinCount; //max값 갖는 
                index = i;//인덱스 저장용
            }
           
        }
        
        result = A.get(index);
        
        return result;
    }
    
    //실행 메인 
  	public static void main(String[] args) {
  		Solution T = new Solution();
  		int[][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};

  		for(int x : T.solution(dice)) {
  			System.out.print(x+ " ");
  		}
  	}
}