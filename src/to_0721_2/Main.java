package to_0721_2;
//오답 
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//이 문자가 영어 알파벳 소문자인지 확인 
		
		String tmp = "aABDebsDZDFEege";
		
		for(char x : tmp.toCharArray()) {
			if(Character.isAlphabetic(x)) {
				System.out.println(x+"는 알파벳임");
			}
			if(Character.isUpperCase(x)){
				
			}else if(Character.isLowerCase(x)) {
				
			}
			
			System.out.println();
		}
	}
}