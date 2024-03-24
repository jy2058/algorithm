package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수_최소공배수_2609 {
    /*
        유클리드 호제법을 사용하여 최대 공약수와 최소 공배수를 출력하는 프로그램
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int returnGcd = gcd(num1, num2);
        System.out.println(returnGcd);
        // 최소공배수는 a * b / 최대공약수
        System.out.println(num1 * num2 / returnGcd );
    }

    /*
    - 유클리드 호제법을 이용하여 최대공약수를 구하는 방식
    - 이 방식은 큰 수를 작은 수로 나눈 나머지를 반복적으로 취하여 나머지가 0이 될때까지 작동하여 최대공약수를 구하는 방식이다.

    - b가 0이라면 a가 최대공약수가 되고, 그렇지 않으면 b와 a % b의 최대공약수를 구한다.
    - 이를 재귀적으로 반복하여 최대공약수를 구한다
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

