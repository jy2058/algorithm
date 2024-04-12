package 수학;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 * 92335 / k진수에서 소수 개수 구하기
 * 프로그래머스
 *
 * 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
 *
 * 0P0처럼 소수 양쪽에 0이 있는 경우
 * P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
 * 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
 * P처럼 소수 양쪽에 아무것도 없는 경우
 * 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
 * 예를 들어, 101은 P가 될 수 없습니다.
 * 예를 들어, 437674을 3진수로 바꾸면 211020101011입니다. 여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.) 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.
 *
 * 정수 n과 k가 매개변수로 주어집니다. n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.
 */
public class 진법_소수_92335 {
    public static void main(String[] args) throws IOException {
        int n = 437674;
        int k = 3;
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        // n을 k진법으로 변환 후 0을 기준으로 분리
        String[] split = Integer.toString(n, k).split("0");

        for (int i = 0; i < split.length; i++) {
            if (split[i].length() == 0) continue;   // 공백문자 제거
            // 소수일경우 answer + 1
            if (isPrime(Long.parseLong(split[i]))) {
                answer++;
            }
        }
        return answer;
    }

    /**
     * 소수인지 판별하는 메서드
     * @param n 소수판별할 숫자
     * @return true: 소수, false: 소수 X
     */
    private static boolean isPrime(long n) {
        // 0, 1은 소수가 아님
        if (n == 1 || n == 0) {
            return false;
        }
        // 2부터 제곱근의 수까지 반복
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // i로 나누어 떨어지면 소수가 아님
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/*
    해당 문제는 진법 변환과 소수 판별 문제가 혼합된 형태였다.
    소수를 판별할 문자들은 0을 기준으로 분리하면 해당 값들을 구할 수 있었다.

    1. Integer.toString()을 이용해 n을 k로 진법 변환
    2. 0을 기준으로 문자 분리
    3. 분리된 문자열을 소수인지 판별
        - 0, 1은 소수가 아님
        - 2부터 시작하여 n의 제곱근까지 소수 판별
        - n이 i로 나누어 떨어진다면 소수가 아님
 */