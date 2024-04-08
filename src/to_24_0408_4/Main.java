package to_24_0408_4;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        
        printArray(a);
        
        // 90도 회전
        int[][] rotated_90 = rotated90(a);
        printArray(rotated_90);

        // 180도 회전
        int[][] rotated_180 = rotated180(a);
        printArray(rotated_180);

        // 270도 회전
        int[][] rotated_270 = rotated270(a);
        printArray(rotated_270);
    }

    // 직사각형 90도 회전
    public static int[][] rotated90(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - i - 1] = a[i][j];
            }
        }
        return result;
    }

    // 직사각형 180도 회전
    public static int[][] rotated180(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[n - i - 1][m - j - 1] = a[i][j];
            }
        }
        return result;
    }

    // 직사각형 270도 회전
    public static int[][] rotated270(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[m - 1 - j][i] = a[i][j];
            }
        }
        return result;
    }

    // 배열 출력
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}