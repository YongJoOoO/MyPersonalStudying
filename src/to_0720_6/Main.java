package to_0720_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//문자열 사전 정렬 기준 적용해보기 
class Market implements Comparable<Market>{
	String name;
	String phoneNum;
	String address;
	Market(String name, String phoneNum, String address){
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	@Override 
	public int compareTo(Market o ) {
		//name은 사전 순, name이 같다면 -> 폰넘버 역순 
		
		int name_result = this.name.compareTo(o.name);
		
		int phone_result = this.phoneNum.compareTo(o.phoneNum);
		
		if(name_result <0 ) {//음수 this가 앞순 
			return -1; //오름차순 
		}else if(name_result > 0) {
			return 1;
		}else if(name_result == 0){
			//두 name 같은 경우 phone 역순 정렬 
			if(phone_result < 0) { //음수 나왔는데 
				return 1;//양수 리턴하면 내림차순 역순 정렬 
			}else if(phone_result > 0) {
				return -1;
			}else {
				return 0;
			}
		}
		return 0;
	}
}

public class Main {
		//실행 메인 
		public static void main(String[] args) {
			Scanner kb= new Scanner(System.in);
			
			PriorityQueue<Market> pQ = new PriorityQueue<>();
			// name 기준 사전 순 정렬되는지 확인 
			
			ArrayList<Market> arr = new ArrayList<>();
			arr.add(new Market("A", "a", "3"));
			arr.add(new Market("E", "e", "3"));
			arr.add(new Market("S", "z", "3"));
			arr.add(new Market("A", "b", "3"));
			arr.add(new Market("Z", "c", "3"));
			
			Collections.sort(arr);//정렬
			for(int i=0; i<arr.size(); i++) {
				System.out.println(arr.get(i).name + " " + arr.get(i).phoneNum);
			}
			System.out.println("-------역순 정렬---------");
			Collections.sort(arr, Collections.reverseOrder());//정렬
			for(int i=0; i<arr.size(); i++) {
				System.out.println(arr.get(i).name + " " + arr.get(i).phoneNum);
			}
		}
}