package to_24_0106_4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2110번. 공유기 설치 - 이분 탐색 문풀
 * @author MYLG
 *
 */
public class Main {
    public static int N;
    public static int C;
    public static int[] arr;
    public static int answer;

    //실행 메인
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        C = kb.nextInt();

        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = kb.nextInt();
        Arrays.sort(arr);

        bsearch(1, 1000000000);
        System.out.println(answer);
    }

    public static void bsearch(int start, int end) {
        if (start > end) return;

        int mid = (start + end) / 2;
        
        if (getMaxC(mid) >= C) {
            answer = mid;
            bsearch(mid + 1, end);
        } else {
            bsearch(start, mid - 1);
        }

    }

    // 공유기 사이의 거리가 distance 일 때, 설치 가능한 공유기의 개수
    public static int getMaxC(int distance) {
        int maxPossibleInstall = 1; // 첫번째 집에는 무조건 설치
        int prevPosition = arr[0];
        for (int i = 1; i < N; i++) {
            // 직전 집이랑 비교를 해서 거리가 괜찮으면 설치 가능하다.
            int curPosition = arr[i];
            if (curPosition - prevPosition >= distance) {
                maxPossibleInstall++;
                prevPosition = curPosition;
            }
        }

        return maxPossibleInstall;
    }

}
