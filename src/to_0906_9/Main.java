package to_0906_9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*풀이 잘 보기 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int max = Integer.MAX_VALUE / 2;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for(int i = 1 ; i<= N ;i++){
            Arrays.fill(map[i], max);
            map[i][i] = 0;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            map[a][b] = t;
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                for(int k = 1 ; k <= N ; k++){
                    if(map[j][k] > map[j][i] + map[i][k]){ ///풀로이드에서 경유지 거쳐서 갱신 시켜 놔는데 
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
        //친구 명수 
        int K = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> lst = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K ; i++){
            lst.add(Integer.parseInt(st.nextToken()));
        }

        //정답 세팅할 건데 
        int[] answer = new int[N+1];
        for(int i = 1; i <= N ; i++){//모든 정점에 대하여 
            for(int j = 0; j < K ; j++){//각각의 친구 K명 위치를 왕복하는 거리를 answer[i]에 담아줄 건데 
                int idx = lst.get(j);
                answer[i] = Math.max(answer[i], map[i][idx] + map[idx][i]);
            }
        }

        lst = new ArrayList<>();//리스트에 다가 
        int minValue = Integer.MAX_VALUE;//워리는 min값 갖는 거 찾을 거야 
        
        for(int i = 1 ; i <= N ; i++){//다시 모든 정점을 순회하면서 
        	//기존 min보다 더 작은 왕복거리 발견 시 
            if(minValue > answer[i]){
                minValue = answer[i];//갱신해주고 
                lst.clear();//기존 리스트 비워주고 
                lst.add(i);//여기에 해당 정점을 담는다.
            }else if(minValue == answer[i]){ //같은 경우 
                lst.add(i);//후보로서 또 담는다. 
            }
        }
        //여기에 
        StringBuilder sb = new StringBuilder();
        for(int data : lst){
            sb.append(data + " ");//차례로 담아 출력 
        }
        System.out.println(sb);
    }
}