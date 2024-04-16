package 수학;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12928
 * 12928 / 약수의 합
 * 프로그래머스
 *
 * 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
 */
public class 약수_약수의합_12928 {
    public static void main(String[] args) throws IOException {
        int n = 12;
        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int answer = 0;
        // n의 제곱근만큼만 반복
        for (int i = 1; i <= Math.sqrt(n); i++) {
            // 약수 중 작은 수
            if (n % i == 0) {
                answer += i;
                // 약수 중 큰 수
                if (n / i != i) {
                    answer += (n / i);
                }
            }
        }
        return answer;
    }
}

/*
    해당 문제는 약수의 합을 구하는 문제이다.
    입력 받은 수의 전체를 for문 돌기보단 제곱근을 이용하여 범위를 줄이는 것이 중요하다.
    n의 제곱근인 마지막 약수를 한번 더 넣지 않게 주의해야 한다.

    - for 문 조건을 sqrt 메소드를 사용한 변수로 정의한다.
    - 원래라면 1 ~ 100까지 돌아야할 for문이 1 ~ 10 까지만 돌아도 약수 추출이 가능해졌다.
    - 입력 값 100의 약수는 1, 2, 4, 5, 10, 20, 25, 50, 100 이렇게 9개이다.
    - 10 번의 for 문을 돌며 9개의 약수 중 1을 구한다 (약수 중 작은 수)
    - 1이 100의 약수라는 것을 알게 된 순간 100이라는 약수도 구할 수 있게 된다.
    - 그 부분이 if(n / i != i) 부분이다. 100 / 1 != 1 이라면 arr 리스트에 100 / 1 의 값을 넣어준다(약수 중 큰수)
    - 이 과정을 반복한다.
    - 10 번의 for 문을 돌며 9개의 약수 중 2을 구한다 (약수 중 작은 수)
    - 2이 100의 약수라는 것을 알게 된 순간 50이라는 약수도 구할 수 있게 된다.
    - 그 부분이 if(n / i != i) 부분이다. 100 / 2 != 2 이면 arr 리스트에 100 / 2 의 값을 넣어준다(약수 중 큰수)
    - 해당 부분은 약수 10을 주의 깊게 봐야한다 10 * 10이 100 이므로 10은 한번만 더해줘야 한다.
    - 그 부분이 if(n / i != i) 부분이다. 100 / 10 != 10 false 이기 때문에 배열에 한번만 들어간다.
    - for 문을 한번 돌 때 약수 중 작은 수 , 큰 수를 모두 더해주기 때문에  for 문이 끝난 뒤 결과값은 1, 100, 2, 50, 4, 25, 5, 20, 10 이런 식으로 값이 더해진다.
 */