package to_1127_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int max = Integer.MIN_VALUE;
    static int n, m;
    static int count;
    static ArrayList<ArrayList<Integer>> grpah = new ArrayList<>();
    
    //BFS
    public static void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for(int i : grpah.get(v)){
                if(!visit[i]){
                    q.add(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
    }
    
    //실행 메인 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<=n;i++){
        	grpah.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grpah.get(b).add(a); //거꾸로 담는구나
        }
        
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            count = 0;
            BFS(i);
            result[i] = count;
            max = Math.max(count, max);

        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max)
                sb.append(i+" ");
        }
        System.out.println(sb);
    }
}