package 수학;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120808?language=java
 * 120808 / 분수의 덧셈
 * 프로그래머스
 */
public class 분수_분수의덧셈_120808 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(1, 2, 3, 4)));

    }

    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};

        // 통분하기(최소공배수 LCM)
        int lcm = denom1 * denom2 / gcd(denom1, denom2);

        // 분자 계산
        int numerator1 = numer1 * (lcm / denom1);
        int numerator2 = numer2 * (lcm / denom2);
        int resultNumerator = numerator1 + numerator2;

        // 기약분수로 만들기(최대공약수로 약분)
        int gcdResult = gcd(resultNumerator, lcm);
        int simplifiedNumerator = resultNumerator / gcdResult;
        int simplifiedDenominator = lcm / gcdResult;

        return new int[]{simplifiedNumerator, simplifiedDenominator};
    }

    public static int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }

}
