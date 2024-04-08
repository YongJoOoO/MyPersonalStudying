package to_24_0408_3;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = 3;
        
        printArray(arr);

        // 시계 방향 90 (= 반시계 방향 270)
        int[][] new_90 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                new_90[j][n - i - 1] = arr[i][j];
            }
        }
        printArray(new_90);

        // 시계 180 & 반시계 180
        int[][] new_180 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                new_180[n - i - 1][n - j - 1] = arr[i][j];
            }
        }
        printArray(new_180);

        // 시계 270 & 반시계 90
        int[][] new_270 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                new_270[n - 1 - j][i] = arr[i][j];
            }
        }
        printArray(new_270);
    }

    // 배열 출력
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}