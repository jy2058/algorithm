package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수판별_에라토스테네스의체_1929 {
    /*
        에라토스테네스의 체를 사용하여 소수인지 확인하는 프로그램
     */
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        isPrime(N);

        // 소수인 것 출력
        for (int i = 0; i < prime.length; i++) {
            if(!prime[i]){
                System.out.println(i);
            }
        }

    }

    /**
     * N 이하 소수 생성 메서드.
     * 에라토스테네스의 체 기법을 사용.
     * " k=2 부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외시킨다"
     * @param n 소수 찾을 값
     */
    public static void isPrime(int n) {
        prime = new boolean[n + 1];
        /*
        소수가 아닐 경우 index = true
        소수일 경우 index = false
         */
        // 0과 1은 소수가 아님
        prime[0] = prime[1] = true;

        // 제곱근 이용
        for (int i = 2; i <= Math.sqrt(n); i++) {

            if(prime[i]) continue;  // 이미 체크된 건 skip

            // i의 배수들을 필터링(i의 배수는 모두 소수가 아님)
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}


/*
    소수를 판별할 때 에라토스테네스의 체를 사용하는 것이 중요
 */