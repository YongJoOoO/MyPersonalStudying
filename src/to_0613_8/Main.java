package to_0613_8;

import java.util.Arrays;
import java.util.Scanner;

/*이분 검색 문제 
 * */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n= kb.nextInt();//개수
		int target = kb.nextInt();
		
		int[] arr= new int[n];
		
		Arrays.sort(arr);
		int lt=0, rt=n-1;
		while(lt<=rt){
			int mid=(lt+rt)/2;
			if(arr[mid]==target){
				System.out.println(mid+1);
				break;
			}
			if(arr[mid]>target) rt=mid-1;
			else lt=mid+1;
		}
	}
}