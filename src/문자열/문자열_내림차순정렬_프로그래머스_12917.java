package 문자열;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12917
 * 12917 / 문자열 내림차순으로 배치하기
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수
 * 대문자는 소문자보다 작은 것으로 간주
 */
public class 문자열_내림차순정렬_프로그래머스_12917 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution("Zbcdefg"));
    }


    public static String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder(new String(chars));
        return sb.reverse().toString();
    }
}

/*
    1. 문자열을 순서대로 정렬
    2. 역순으로 출력
 */