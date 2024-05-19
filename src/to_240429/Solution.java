package to_240429;
import java.util.*;

public class Solution {
    // 각 메뉴의 구성을 담을 배열과 방문 여부를 나타낼 배열 선언
    static char[] arrChar;
    static boolean[] visited;
    // 메뉴 구성과 등장 횟수를 저장할 Map
    static Map<char[], Integer> map;

    // DFS를 통해 메뉴 구성을 조합하는 함수
    static void DFS(String str, int lv, int targetLv) {
        if (lv == targetLv) {
            // 조합된 메뉴 구성을 String으로 변환하여 Map에 저
            map.put(arrChar, map.getOrDefault(arrChar, 0) + 1);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrChar[lv] = str.charAt(i);
                DFS(str, lv + 1, targetLv);
                visited[i] = false;
            }
        }
    }

    // 솔루션 함수
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>(); // 정답을 저장할 리스트 생성
        map = new HashMap<>(); // 매번 새로운 메뉴 구성을 조합할 때마다 Map 초기화

        for (int x : course) { // course 배열의 요소를 하나씩 확

            // 모든 주문 메뉴에 대해 DFS를 통해 조합
            for (String menu : orders) {
                if (menu.length() < x) continue; // 메뉴 길이가 x보다 작으면 건너뜀
                arrChar = new char[x];
                visited = new boolean[menu.length()];
                DFS(menu, 0, x);
            }



        }

        // 정답 리스트를 배열로 변환하여 반환
        String[] answer = new String[answerList.size()];
        answerList.toArray(answer);
        Arrays.sort(answer); // 정답을 사전식 순서대로 정렬
        return answer;
    }

    // 실행 메인
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        for (String x : T.solution(orders, course)) {
           System.out.print(x + " ");
        }
    }
}