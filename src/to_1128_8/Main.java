package to_1128_8;
/**
 * 부분집합 구하기 - DFS
 * @author MYLG
 *
 */
import java.util.*;

class Main {
	static int n;
	static int[] ch;
	//DFS
	public void DFS(int L){
		if(L==n+1){
			String tmp="";
			for(int i=1; i<=n; i++){
				if(ch[i]==1) tmp+=(i+" ");
			}
			if(tmp.length()>0) System.out.println(tmp);
		}
		else{
			//처음에는 포함시키기 
			ch[L]=1; //포함 시킴
			DFS(L+1);
			//복귀 후에는 포함 안시키기  
			ch[L]=0; //포함 안시킴
			DFS(L+1);
		}
	}
	//main
	public static void main(String[] args){
		Main T = new Main();
		n=3;
		ch=new int[n+1];
		T.DFS(1);
	}	
}