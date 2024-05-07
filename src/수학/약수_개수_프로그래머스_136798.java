package 수학;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * 136798 / 기사단원의 무기
 *
 * 약수의 개수를 구해 각 조건에 따라 철의 무게를 구하는 문제
 */
public class 약수_개수_프로그래머스_136798 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(10, 3, 2));
    }

    public static int solution(int number, int limit, int power){

        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int divCnt = divisionCnt(i);
            // 약수의 개수가 제한 값보타 클경우 power 값으로 더하기
            if (divCnt > limit) {
                answer += power;
            // 그 외에는 약수의 개수로 power 값 더하기
            }else{
                answer += divCnt;
            }

        }

        return answer;
    }

    /**
     * 약수의 개수를 구하는 메서드
     * @param n 약수의 개수를 구할 숫자
     * @return  약수의 개수
     */
    public static int divisionCnt(int n) {
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
    약수의 개수를 구해 각 조건에 따라 철의 무게를 구하는 문제였다.
    약수를 구할 때 합성수의 특징에 따라 제곱근을 사용해야 시간초과가 나지 않는다.
와
    1. i가 제곱근일 때까지 반복
    2. i가 num의 제곱근일 경우 cnt + 1
    3. i가 제곱근이 아닌 약수일 경우 cnt + 2
    4. 리턴받은 약수의 개수를 제한 값 보다 클 경우 power  값으로 더하기
    5. 그 외에는 약수의 개수로 power 값에 더하기
 */