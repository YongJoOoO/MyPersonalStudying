package to_0804_B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//1759번. 암호 만들기 
public class Main {

    public static int L, C;
    public static char[] list;
    static String code = "";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C]; //조합 가능한 문자 개수 

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < C; x++) {
            list[x] = st.nextToken().charAt(0); //대상 문자들 입력받고 
        }
        // 정렬
        Arrays.sort(list);

        makeCode(0,0); //0번쨰로 0레벨에 호출

    }

    public static void makeCode(int x, int lv) {//몇번쨰 값인지, lv 이랑 보냄 
        if (lv == L) {
            // 최소 한개의 모음, 최소 2개의 자음인지 확인
            if (isValid()) {
                System.out.println(code);
            }
            return;
        }

        // 아직 길이 L의 코드를 만들지 않았고 글자도 아직 남았다.
        for (int i = x; i < C; i++) {
            code += list[i]; //누적시켜놓고, 
            makeCode(i+1, lv + 1); //다음 레벨에 대하여. 호출
            code = "";//돌아오면 다시 초기화
        }
    }
    // 최소 모음 1개, 최소 자음 2개인지 확인
    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : code.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}