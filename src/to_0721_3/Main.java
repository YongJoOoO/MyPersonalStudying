package to_0721_3;
//오답노트- 구분자로 여러 구분자 자르기 
public class Main {
	//소문자로 된 인지 
	static boolean isName(String name) {
		char[] tmp = name.toCharArray();
		for(int i=0; i<tmp.length; i++) {
			if(!Character.isLowerCase(tmp[i])) { //하나라도 아닌 게 나오면 
				return false; //거짓 
			}
		}
		return true; //다 통과하면 진실 
		
	}
	//뒷 도메인 처리 
	static boolean isDomain(String domain) {
		String[] a = domain.split("\\.");// . 을 기준으로 자르고
		if(a.length == 2) { //두개로 나뉘는 경우에 한해서 
			String dm = a[0]; // 얘는 소문자인지 봐야 하고 
			String td = a[1]; // 얘는 해당되는 애인지만 봐야 하고
			
			if(isName(dm) == true) {
				if(td.equals("com") || td.equals("net") || td.equals("arg")) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"abdxdfc.brmde@net", "abc@br.com" , "abdx.dfc@brm@e.net", "abdxdfc@brm@com.net","woeiq@dalge.com", "abdxdfc.brmde@net"};
		int answer =0;
		
		for(String x : arr) {
			String[] tmp = x.split("@");//일단 골뱅이 기준으로 잘라
			if(tmp.length == 2) { //이 경우에 한해서만 
				String name = tmp[0]; //앞부분 
				String domain = tmp[1];//얘를 따로 처리
				
				if(isName(name) == true && isDomain(domain) == true) {
					answer++;
				}
				
			}else continue;//그 외는 제낌			
		}
		//정답 출력 
		System.out.println(answer);
	}
}