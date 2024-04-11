package 문자열;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12903
 * 12903 / 가운데 글자 가져오기
 * 프로그래머스
 *
 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 */
public class 문자열_가운데글자_12903 {
    public static void main(String[] args) throws IOException {

        System.out.println(solution("abcd"));
    }

    public static String solution(String s) {
        int len = s.length();
        if (len % 2 == 0) {
            return s.substring(len / 2 - 1, len / 2 + 1);
        }else {
            return s.substring(len / 2, len / 2 + 1);
        }
    }
}

/*

    문자열의 substring을 이용해서 문자열의 길이를 2로 나눠 가운데를 찾아서 리턴했다.
    짝수일경우와 홀수일경우 위치 계산을 다르게 해줬는데 아래와 같이 표현하면 분기할 필요가 없었다.

    return s.substring((len - 1) / 2, len / 2 + 1);

 */