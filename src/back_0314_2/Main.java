package back_0314_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*백준. 23881번. 선택 정렬 1
*/
class Main {
	  public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int N=Integer.parseInt(st.nextToken());
	    int K=Integer.parseInt(st.nextToken());
	    int [] arr = new int[N+1];

	    st=new StringTokenizer(br.readLine());
	    for (int i=1;i<=N;i++){
	    	arr[i]=Integer.parseInt(st.nextToken());
	    }

	    int cnt = 0;

	    for (int last=N; last>1; last--){
	      int max = arr[0];
	      int maxIdx = 0;
	      for (int i=1;i<=last;i++){
	        if(max < arr[i]){
	          max = arr[i];
	          maxIdx = i;
	        }
	      }
	      if(last!=maxIdx){
	        int temp = arr[last];
	        arr[last] = arr[maxIdx];
	        arr[maxIdx] = temp;
	        cnt ++;
	        
	        if(cnt == K){
	          System.out.println(arr[maxIdx]+" "+arr[last]);
	          System.exit(0);
	        }
	      }
	    }
	    
	    if(cnt!=K){
	      System.out.println(-1);
	    }
	  }
	
}