package to_1005_5;
import java.io.*;
import java.util.*;

class Fish {
    int x, y, move;

    public Fish(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}

public class Main {
    static int N, px, py, time = 0, size = 2;
    static int[][] map;
    static boolean[][] chk;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    // BFS
    static boolean BFS(int x, int y) {
        
    	int eating = 0;
    	Queue<Fish> Q = new LinkedList<>();
        chk = new boolean[N][N];

        List<Fish> preyList = new ArrayList<>();

        Q.offer(new Fish(x, y, 0));
        chk[x][y] = true;

        int minDist = Integer.MAX_VALUE;

        while (!Q.isEmpty()) {
            Fish cur = Q.poll();
            int cur_move = cur.move;

            if (cur_move > minDist) {
                continue; // 현재 거리가 최소 거리보다 크면 종료
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] > size) {
                    continue;
                }

                if (!chk[nx][ny]) {
                    chk[nx][ny] = true;

                    if (map[nx][ny] < size && map[nx][ny] != 0) {
                        preyList.add(new Fish(nx, ny, cur_move + 1));
                        minDist = cur_move + 1; // 최소 거리 갱신
                    }

                    Q.offer(new Fish(nx, ny, cur_move + 1));
                }
            }
        }

        if (preyList.size() == 0) {
            return false; // 먹을 물고기 없음
        }

        Collections.sort(preyList, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if (o1.move == o2.move) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    } else {
                        return o1.x - o2.x;
                    }
                } else {
                    return o1.move - o2.move;
                }
            }
        });

        Fish eat = preyList.get(0);
        time += eat.move;

        map[px][py] = 0;
        px = eat.x;
        py = eat.y;
        map[px][py] = 9;

        if (size == ++eating) {
            size++;
            eating = 0;
        }

        return true; // 먹이를 찾아 먹었음
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st = null;
        int st_x = 0, st_y = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == 9) {
                    st_x = i;
                    st_y = j;
                }
            }
        }

        boolean foundPrey = true;
        while (foundPrey) {
            foundPrey = BFS(st_x, st_y);
        }

        System.out.println(time);
    }
}