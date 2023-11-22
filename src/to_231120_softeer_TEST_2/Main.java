package to_231120_softeer_TEST_2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DNS{
	String name;
	String ip;
	DNS(String name, String ip){
		this.name = name;
		this.ip = ip;
	}
}
class Main {
	
	static List<DNS> arr = new ArrayList<>();
	
	//등록 기능
	static void saveIn(String name, String ip) {
		arr.add(new DNS(name, ip));
	}
	//검색 기능
	static String search(String target) { //도메인 이름 or 주소로 들어옴
		String answer = "";
		if(Character.isAlphabetic(target.charAt(0))) {
			//도메인
			for(DNS x : arr) {
				if(x.name.equals(target)) {
					answer = x.ip;
				}
			}
		}
		if(Character.isDigit(target.charAt(0))) {
			
			//ip 주소
			for(DNS x : arr) {
				String[] range = x.ip.split("-");
				if(range.length == 1) {
					if(range[0].equals(target)) {
						answer = x.name;
					}
				}
				if(range.length == 2) { //영역
					if(range[0].compareTo(target) <= 0 && range[0].compareTo(target) >= 0) {
						answer = x.name;
					}
				}
				
			}
		}
		
		return answer;
	}
	
	//자동 완성 기능
	static List<String> autoSearch(String name){ //일부 이름값을 받아서 찾아 반환
		List<String> ans = new ArrayList<>();
		
		for(DNS x : arr) {
			if(x.name.contains(name)) {
				ans.add(x.name);
			}
		}
		return ans;
	}
	
	//모든 입력은 R입력 선행되어야 정상 동작함
	//실행 메인 
	public static void main(String[] args) throws Exception {
		Scanner kb= new Scanner(System.in);
		
		List<String> answer = new ArrayList<>();
		while(kb.hasNext()){ //입력이 존재하는 동안 while문 돌기 
		
			String tmp = kb.next();
			String[] strArr = tmp.split(" ");
			
			String question = strArr[0];
			
			
			if(question.equals("R")) {
				//등록 기능 
				saveIn(strArr[1], strArr[2]);
				
			}
			
			if(question.equals("S")) {
				//검색 기능
				String ans = search(strArr[1]);
				answer.add(ans);
			}
			
			if(question.equals("A")) {
				//자동 완성 기능
				List<String> ansList = autoSearch(strArr[1]);
				//ans에 담기
				
				answer = ansList;
			}
			
		}
		
		//답 출력 
		for(String x : answer) {
			System.out.println(x);
		}
		
	}
}