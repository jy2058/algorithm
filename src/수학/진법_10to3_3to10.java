package 수학;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 * 68935 / 3진법 뒤집기
 * 프로그래머스
 *
 * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 */
public class 진법_10to3_3to10 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(45));

    }

    public static int solution(int n) {
        int answer = 0;
        // 3진수
        String changeThree = Integer.toString(n, 3);
        // reverse
        String reverse = new StringBuilder(changeThree).reverse().toString();
        // 10진수
        answer = Integer.parseInt(reverse, 3);
        return answer;
    }
}

/*
    진법을 변환하는 문제와 reverse를 사용하는 문제였다.

    1. 10진수에서 3진수로 변경한다.
        - Integer.toString(n, 3) 을 이용하여 3진수로 변경한다.
    2. 3진수 문자를 뒤집는다.
        - StringBuilder의 reverse 메서드를 이용
    3. 뒤집은 3진수를 10진수로 변환한다.
        - Integer.parseInt(n, 3)을 이용한다.
 */