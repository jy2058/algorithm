package 맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1620
 * 1620 / 나는야 포켓몬 마스터 이다솜
 * 실버4
 *
 * 문자 또는 숫자를 입력받았을 때 해당 되는 값을 출력하는 문제
 */
public class 해시맵_키밸류각각찾기_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 도감갯수
        int M = Integer.parseInt(st.nextToken());   // 출력 갯수

        Map<String, Integer> stringMap = new HashMap<>();   // 문자를 키값으로 저장
        Map<Integer, String> intMap = new HashMap<>();      // 숫자를 키값으로 저장

        // 문자일 경우, 숫자일 경우를 위해 각각 저장
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            stringMap.put(s, i);
            intMap.put(i, s);
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            String s = br.readLine();
            // 숫지인지 확인
            if(Character.isDigit(s.charAt(0))){
                // 숫자일 경우 숫자를 키값으로 가진 map에서 값을 가져와서 출력
                sb.append(intMap.get(Integer.parseInt(s))).append("\n");
            }else{
                // 문자일 경우 문자를 키값으로 가진 map에서 값을 가져와서 출력
                sb.append(stringMap.get(s)).append("\n");
            }

        }
        System.out.println(sb);
    }
}

/*
    입력받는 값이 문자 또는 숫자일 때 해당하는 값을 출력하는 문제여서 맵을 이용해 풀면 됐다.

    1. 문자를 키로 담을 맵, 숫자를 키로 담을 맵 두 개를 생성
    2. 문자인지 숫자인지 확인
    3. 문자일 경우 문자를 키로 가진 맵에서 값을 출력
    4. 숫자일 경우 숫자를 키로 가진 맵에서 값을 출력

 */