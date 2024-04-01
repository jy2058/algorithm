package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2960
 * 2960 / 에라토스테네스의 체
 * 실버4
 *
 * 소수를 판별하는 문제, 소수까지 카운트 하는 문제
 */
public class 수학_에라토스테네스의체_특정값까지_2960 {
    public static boolean[] prime;  // 소수 체크 배열
    public static int cnt = 0;  // 소수 확인 횟수
    public static int num = 0;  //  해당하는 횟수의 소수 값
    public static int K;    // 입력받은 소수 확인 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isPrime(N);

        System.out.println(num);
    }

    /**
     * 소수를 판별하는 메서드
     * @param n 소수를 판별 할 수
     */
    public static void isPrime(int n) {
        prime = new boolean[n + 1];

        // 0, 1은 소수가 아니다.
        prime[0] = prime[1] = true;

        // 소수판별은 2부터
        for (int i = 2; i <= n; i++) {
            // k번째에 지워진 모든 수를 체크해야하기 때문에 1부터 i씩 증가하면서 체크
            for (int j = i; j <= n; j = j + i) {
                // 이미 체크된 건 건너뛰기
                if(prime[j]) continue;

                prime[j] = true;    // 소수 확인 체크
                cnt++;  // 카운트 증가

                // 입력받은 횟수와 같아지면 종료
                if(cnt == K) {
                    num = j;
                    break;
                }
           }
        }
    }
}
/*

    참고: https://www.acmicpc.net/problem/1929
    기존에 풀었던 에라토스테네스의 체는 숫자의 배수만 지웠었다.
    하지만 현재 문제에서는 소수까지 카운트를 하기 때문에 해당 부분까지 신경써야한다.
    -> 기존: 2의 배수만 지움, 현: 2, 2의 배수까지 지움

    1. 2부터 N까지 모든 정수를 적는다.
    2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
    3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
    4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
 */