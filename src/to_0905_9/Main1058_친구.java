package to_0905_9;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main1058_친구 {
 
    public static int N, MAX_VALUE = 987654321;
    public static int[][] friends;    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new int[N][N];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                if(s.charAt(j)=='N') friends[i][j] = MAX_VALUE; 
                else friends[i][j] = 1;
                if(i==j) friends[i][j] = 0;
            }
        }
        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(friends[i][j]>friends[i][k]+friends[k][j])
                        friends[i][j]=friends[i][k]+friends[k][j];
                }
            }
        }
        int max = 0;
        for(int i=0; i<N; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if(i==j) continue;
                if(friends[i][j]<=2) count++;
            }
            if(max<count) max = count;
        }
        System.out.println(max);
    }
}