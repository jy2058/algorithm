package 문자열;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12932
 * 12932 / 자연수 뒤집어 배열로 만들기
 *
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 */
public class 문자열_자연수뒤집어배열로_프로그래머스_12932 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(12345));
    }

    public static int[] solution(long n) {
        String str = Long.toString(n);
        // 입력받은 수를 뒤집기
        StringBuilder sb = new StringBuilder(str).reverse();

        int[] answer = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            // 한글자씩 잘라서 배열에 넣기
            answer[i] = Integer.parseInt(sb.substring(i, i + 1));
        }
        // 배열 출력
        return answer;
    }
}

/*
    입력 받은 수를 뒤집기 위해 reverse 메서드를 사용했다.

    1. 입력 받은 수 뒤집기
    2. 한 글자씩 잘라서 배열에 넣기
    3. 배열 출력
 */