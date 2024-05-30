package 탐색;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 42839 / 소수 찾기
 *
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 */
public class 완전탐색_순열_소수_42839 {
    public static void main(String[] args) throws IOException {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        // 문자열로 가능한 모든 숫자 조합을 생성하고, 각 조합이 소수인지 확인
        permutation("", numbers, primes);

        return primes.size();
    }

    /**
     * 재귀적으로 숫자 조합을 생성(순열)
     * @param prefix 현재문자
     * @param str 나머지 문자열
     * @param primes 소수가 담긴 set
     */
    private static void permutation(String prefix, String str, Set<Integer> primes) {
        int n = str.length();
        if (!prefix.isEmpty()) {
            int num = Integer.parseInt(prefix);
            // 소수인지 확인하여 소수일경우 set에 추가
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        // str 문자열의 각 문자에 대해 반복
        for (int i = 0; i < n; i++) {
            // 현재 문자를 prefix에 추가하고, 나머지 문자열로 새로운 순열을 생성하기 위해 permutation 메소드를 재귀적으로 호출
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), primes);
        }
    }

    /**
     * 소수인지 확인
     * @param number
     * @return false: 소수가 아닌 경우, true: 소수인경우
     */
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

/*
이 문제를 해결하기 위해 자바에서는 숫자 조합을 생성하고, 각 조합이 소수인지 확인하는 함수를 작성해야 한다. 다음은 이를 위한 접근 방법이다:

1. 숫자 조합 생성: 주어진 숫자 문자열에서 모든 가능한 숫자 조합을 생성한다. 이를 위해 순열 알고리즘을 사용할 수 있다.
2. 소수 판별: 생성된 각 숫자에 대해 소수인지 판별한다. 소수는 1과 자기 자신으로만 나눌 수 있는 1보다 큰 정수이다.
3. 중복 제거: 같은 숫자가 중복되어 소수로 계산되는 것을 방지하기 위해 중복을 제거한다. HashSet 이용
4. 소수 개수 계산: 최종적으로 소수의 개수를 세어 반환한다.
 */