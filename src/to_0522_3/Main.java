package to_0522_3;

class Main {
    public String solution(String s) {
        String answer = "";
        int len = s.split(" ").length;
        //공백 기준으로 자르고
        for(String x : s.split(" ")){
            int i= 0;
            for(char c : x.toCharArray()){
                if(i %2 == 0){
                    answer += Character.toUpperCase(c);
                    i++;
                }else{
                    answer += Character.toLowerCase(c);
                    i++;
                }
            }
            if(i == len-2) break;
            answer += " "; //공백 구분
        }
        
        return answer;
    }
    
    //실행 메인 
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution("try hello world"));
	}
}