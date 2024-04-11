package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1343
 * 1343 / 폴리오미노
 * 실버5
 *
 * 민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB
 * 이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.
 * 폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.
 */
public class 그리디_문자덮기_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] split = s.split("\\.");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            String target = split[i];
            // 문자열이 홀수개라면 -1 출력(AAAA, BB 모두 짝수개이기 때문)
            if (target.length() % 2 != 0) {
                sb = new StringBuilder("-1");
                break;
            }

            // 길이가 4로 나누어떨어질 경우 해당 갯수만큼 반복 출력
            if (target.length() % 4 == 0) {
                sb.append("AAAA".repeat(target.length() / 4));
            // 그 외 길이가 4인 갯수만큼 반복 후 BB 추가 출력
            } else {
                sb.append("AAAA".repeat(target.length() / 4));
                sb.append("BB");
            }
            // '.'을 기준으로 자른 거니까 다시 '.' 붙여주는 작업
            if (i != split.length - 1) {
                sb.append(".");
            }
        }

        // 누락된 '.' 붙이기
        if (!sb.toString().contains("-1")) {
            sb.append(".".repeat(s.length() - sb.length()));
        }

        System.out.println(sb);
    }

}
/*
    해당 문제는 입력 받은 문자를 특정 문자로 변경하는 방식의 그리디 알고리즘 방식의 문제였다.

    처음에는 그냥 replace()를 이용해서 특정 문자로 대체해서 풀었는데 그리디 알고리즘을 이용해서 푸는 방식으로 변경했다.

    1. ‘.’을 기준으로 문자열을 분리
    2. 문자열이 홀수면 -1 출력
    3. 문자열 변경
        1. 4로 나누어 떨어질 경우는 AAAA만 해당 갯수만큼 추가
        2. 4로 나누어 떨어지지 않을 경우는 BB도 추가
        3. 문자열 사이 ‘.’ 추가
    4. 뒤에 있는 ‘.’ 전부 추가
        1. 마침표(.)를 기준으로 문자열을 분리하면 마침표가 뒤에 붙었을 때 (XXXX...) 뒤의 마침표는 문자열에 포함이 안된다. 따라서, 뒤에 나머지 마침표들이 있다면 나머지 마침표들을 붙여준다.
 */