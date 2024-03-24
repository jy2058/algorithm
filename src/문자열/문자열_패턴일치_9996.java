package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_패턴일치_9996 {
    /*
     특정 패턴과 문자열이 일치하는지 확인하는 프로그램
     '*'를 기준으로 확인
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String[] split = str.split("\\*");

        for (int i = 0; i < N; i++) {
            String targetStr = br.readLine();

            // 패턴의 길이보다 짧으면 안됨.
            if(split[0].length() + split[1].length() > targetStr.length()){
                sb.append("NE").append("\n");
                continue;
            }

            // 문자열의 각 패턴의 앞뒤 길이만큼 일치하는지 확인하기 위해 문자열 자르기
            String t1 = targetStr.substring(0, split[0].length());
            String t2 = targetStr.substring(targetStr.length() - split[1].length());

            // 각 패턴의 앞뒤와 일지하는 지 확인
            if (t1.equals(split[0]) && t2.equals(split[1])) {
                sb.append("DA");
            }else{
                sb.append("NE");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
  
}

