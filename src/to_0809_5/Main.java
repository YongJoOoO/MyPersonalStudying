package to_0809_5;
import java.util.*;

/*
[백준] 2583번 - 영역 구하기 (Java)
*/
public class Main {
    static int M, N, K;
    static int A[][];    
    static boolean visited[][];
    static int max = 0;
    
    //4방향 좌표 
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    
    //DFS
    static void DFS(int x, int y, int count) {
        visited[x][y] = true;
        max = Math.max(max, count);
       
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (A[nx][ny] == 1) continue;
            if (visited[nx][ny]) continue;
            DFS(nx, ny, max+1);//다시 돌아갔을 때 stack에는 이전 count값이 사용되므로 최신 max를 count 대신 사용한다.
        }
    }

    //실행 메인 
	public static void main(String[] args) {
		Main m = new Main();
		Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();
        K = in.nextInt();
        
        A = new int[M][N];
        
        for (int i=0; i<K; i++) {//K개 입력받고 
            int y1 = in.nextInt(); //x, y거꾸로 입력받아서 행렬표에 담기 
            int x1 = in.nextInt();
            
            int y2 = in.nextInt(); 
            int x2 = in.nextInt();
            for (int x=x1; x<x2; x++) {//영역 칠하기 
                for (int y=y1; y<y2; y++) {
                    A[x][y] = 1;//좌표의 범위만큼 사각형을 1로 채운다
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        visited = new boolean[M][N];
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (visited[i][j]) continue;
                if (A[i][j] == 1) continue;
                DFS(i, j, 1);
                list.add(max);
                max = 0;
            }
        }

        System.out.println(list.size());
        Collections.sort(list);        
        for (int x : list)
            System.out.print(x+" ");
	}
}