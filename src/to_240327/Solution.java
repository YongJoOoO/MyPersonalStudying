package to_240327;

import java.util.*;
class Info implements Comparable<Info>{
    int time;
    String name;
    Info(int time, String name){
        this.time= time;
        this.name =name;
    }
    public int compareTo(Info o){
        return o.time - this.time;
    }
}
class Solution {
    static int getTime(String str){
        int H = Integer.parseInt(str.split(":")[0]);
        int M = Integer.parseInt(str.split(":")[1]);

        return 60 * H + M;//분
    }

    static boolean equalsString(String a, String b){ //b는 항상
        String tmp = "";

        if(a.charAt(0) != b.charAt(0)){
            int ed = b.indexOf(a.charAt(0));//그 시작 ed를 찾기
            tmp = b.substring(ed);
            tmp += b.substring(0, ed);
            b = tmp;
        }

        if(a.equals(b) || a.contains(b) || b.contains(a)) return true;

        return false;
    }

    //솔루션 함수
    public String solution(String m, String[] musicinfos) {
        String answer ="(None)";

        m = m.replaceAll("A#", "1")
                .replaceAll("C#", "2")
                .replaceAll("D#", "3")
                .replaceAll("G#", "4")
                .replaceAll("F#", "5");

        PriorityQueue<Info> pQ = new PriorityQueue<>();
        int max = 0;
        for(String x : musicinfos){
            String[] tmp = x.split(",");

            int st = getTime(tmp[0]);
            int ed = getTime(tmp[1]);
            int time = ed - st;

            String name = tmp[2];
            String melody = tmp[3];

            melody = melody.replaceAll("A#", "1")
                    .replaceAll("C#", "2")
                    .replaceAll("D#", "3")
                    .replaceAll("G#", "4")
                    .replaceAll("F#", "5");

            boolean flag = equalsString(m, melody);
            if(flag) {
                if(max < time){
                    pQ.offer(new Info(time, name));
                }
            }
        }

        if(!pQ.isEmpty()) answer = pQ.poll().name;

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("A",new String[] { "12:00,12:01,Song,A#" }));
    }
}