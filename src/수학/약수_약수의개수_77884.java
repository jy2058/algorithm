package 수학;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 * 77884 / 약수의 개수와 덧셈
 * 프로그래머스
 *
 * 두 정수 left와 right가 매개변수로 주어집니다.
 * left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 */
public class 약수_약수의개수_77884 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(13, 17));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        // left부터 right까지 for문
        for (int i = left; i <= right; i++) {
            int cnt = divisionCnt(i);   // i값 약수 개수 구하기
            // 약수의 개수가 짝수일 경우 i 값 더하기, 그 외 홀수일경우 빼기
            answer = cnt % 2 == 0 ? answer + i : answer - i;
        }

        return answer;
    }

    /**
     * 약수의 개수를 구하는 메서드
     * @param n 약수의 개수를 구할 숫자
     * @return  약수의 개수
     */
    private static int divisionCnt(int n) {
        int cnt = 0;

        //num이 16일 경우 약수는 1, 2, 4, 8, 16
        //합성수의 특징에 따라
        //16의 제곱근인 4 전까지는 약수의 개수가 하나 더 있음이 보장
        //따라서 for문은 i가 제곱근일때 까지 반복
        for (int i = 1; i * i <= n; i++) {
            // i가 num의 제곱근일 경우
            if (i * i == n) {
                cnt++;
                // i가 제곱근이 아닌 약수일 경우
            }else if (n % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
    }

}

/*
    특정 수의 구간을 각각 약수의 개수를 구해 약수의 개수가 홀수, 짝수에 따라 그 수를 더하고 빼는 문제였다.
    제곱근을 이용하여 약수를 구하는 방식을 사용하여 시간을 줄였다.

    1. left부터 right까지 for문을 돌면서 각 수의 약수의 개수를 구한다.
    2. 약수의 개수를 구한다.
        1. i가 제곱근일 때까지 반복
        2. i가 num의 제곱근일 경우 cnt + 1
        3. i가 제곱근이 아닌 약수일 경우 cnt + 2
    3. 약수의 개수가 짝수일 경우 그 수를 더하고, 홀수일 경우 그 수를 뺀다.
 */