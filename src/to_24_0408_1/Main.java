package to_24_0408_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        
        printArray(arr);
        
        // 시계 방향 90 (= 반시계 방향 270)
        int[][] arr_90 = rotate90(arr);
        printArray(arr_90);

        // 시계 방향 180 (= 반시계 방향 180)
        int[][] arr_180 = rotate180(arr);
        printArray(arr_180);

        // 시계 방향 270 (= 반시계 방향 90)
        int[][] arr_270 = rotate270(arr);
        printArray(arr_270);
    }

    // 90도 회전
    public static int[][] rotate90(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotated = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = arr[i][j];
            }
        }

        return rotated;
    }

    // 180도 회전
    public static int[][] rotate180(int[][] arr) {
        return rotate90(rotate90(arr));
    }

    // 270도 회전
    public static int[][] rotate270(int[][] arr) {
        return rotate90(rotate90(rotate90(arr)));
    }

    // 배열 출력
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}