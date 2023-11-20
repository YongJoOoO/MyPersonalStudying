package to_1120_B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 7568번. 덩치 - 
 * @author MYLG
 *
 */
class Person implements Comparable<Person>{
	int num;
	int h, w;
	Person(int num, int h, int w){
		this.num = num;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.w - o.w;//몸무게 작은 거 우선 정렬 
	}
}
class Tuple implements Comparable<Tuple> {
    int personNum;
    int answerValue;

    Tuple(int personNum, int answerValue) {
        this.personNum = personNum;
        this.answerValue = answerValue;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.personNum - o.personNum;
    }
}

public class Main {
	static int N;
	static List<Person> arr;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		
		arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int a = kb.nextInt();//키
			int b = kb.nextInt();//무게
			arr.add(new Person(i, b, a));
		}
		
		Collections.sort(arr);
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=i+1; j<N; j++) {
				if(arr.get(i).h < arr.get(j).h) {
					cnt++;
				}
			}
			answer.add(cnt);
		}
		 ArrayList<Tuple> tuples = new ArrayList<>();
	        for (int i = 0; i < N; i++) {
	            tuples.add(new Tuple(arr.get(i).num, answer.get(i)));
	        }

	        Collections.sort(tuples);

	        for (Tuple tuple : tuples) {
	            System.out.print(tuple.answerValue + " ");
	        }
		
	}
	
}
