package to_0804_C;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 12894;
		
		String tmp = "1390";
		
		char x = '9';
		
		//char -> int로 
		int b = Character.getNumericValue(x);
		
		System.out.println(b);
		
		//int -> String 으로
		String as = Integer.toString(a);
		
		
		String bs = String.valueOf(a);
		bs += "dflijaei";
		System.out.println(as + " " + bs);
		
		
		
	}

}
