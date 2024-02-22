package to_24_0217_1;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;	//회전할 배열
	static int N,M,R;
    public static void main(String[] args) throws IOException {
    	Scanner kb= new Scanner(System.in);
    	N = kb.nextInt();
    	M = kb.nextInt();;
    	R = kb.nextInt();;
    	
    	int space = Math.min(N, M)/2;		//공간 개수
    	arr = new int[N][M];
        //배열 초기화
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			arr[i][j] = kb.nextInt();
    		}
    	}
    	
    	//기준
    	int n = N;
    	int m = M;
        //크기
    	int width = N;
    	int weight = M;
    	for(int i=0;i<space;i++) {
    		rotation(i,n,m,width,weight);
            //기준 감소
    		n-=1;
    		m-=1;
            //크기 감소
    		width-=2;
    		weight-=2;
    	}

    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			System.out.print(arr[i][j] + " ");
    		}
    	}
    }
    //각 범위별 (R%원상태로 돌아오는 회전 횟수)번 회전하는 함수
    static void rotation(int space, int n, int m, int width, int weight) {
    	
    	int repeat = R % (width*2 + weight*2 - 4);		//원상태로 돌아오는 회전 횟수
    	
    	for(int i=0;i<repeat;i++) {
        	int temp = arr[space][space];
    		for(int j=space;j<m-1;j++)		//←
    			arr[space][j] = arr[space][j+1];  		
    		for(int j=space;j<n-1;j++)		//↑
    			arr[j][m-1] = arr[j+1][m-1];
    		for(int j=m-1;j>space;j--)		//→
    			arr[n-1][j] = arr[n-1][j-1];
    		for(int j=n-1;j>space;j--)		//↑
    			arr[j][space] = arr[j-1][space];
    		arr[space+1][space] = temp;
    	}
    	return;
    }
}