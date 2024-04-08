package to_24_0408_2;

import java.util.Arrays;

public class Main {
	
    // 90도 회전
    public static void rotate90(int[][] arr, int[][] new_arr, int sy, int sx, int length) {
        // 정사각형을 시계방향으로 90도 회전
        for (int y = sy; y < sy + length; y++) {
            for (int x = sx; x < sx + length; x++) {
                // 1단계 : (0,0)으로 옮겨주는 변환을 진행함
                int oy = y - sy;
                int ox = x - sx;
                // 2단계 : 90도 회전했을때의 좌표를 구함
                int ry = ox;
                int rx = length - oy - 1;
                // 3단계 : 다시 (sy,sx)를 더해줌
                new_arr[sy + ry][sx + rx] = arr[y][x];
            }
        }

        // new_arr 값을 현재 board에 옮겨줌
        for (int y = sy; y < sy + length; y++) {
            for (int x = sx; x < sx + length; x++) {
                arr[y][x] = new_arr[y][x];
            }
        }
    }
    
    public static void printArray(int[][] arr) {
        for(int[] row : arr) {
        	System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    //실행 메인 
    public static void main(String[] args) {
        int[][] arr = new int[7][7];
        int[][] new_arr = new int[7][7];
        int sy = 2, sx = 2;
        int length = 3;

        // 배열 초기화
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 7; i++) {
                arr[j][i] = 7 * j + i + 1;
                new_arr[j][i] = 0;
            }
        }
        printArray(arr);

        // 배열의 특정 부분(정사각형)을 회전시킴
        rotate90(arr, new_arr, sy, sx, length);

        // 결과 출력
        printArray(arr);
    }

}