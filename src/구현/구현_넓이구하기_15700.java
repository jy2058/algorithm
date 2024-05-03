package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15700
 * 15700 / 타일 채우기 4
 * 브론즈4
 *
 * N×M 크기의 벽에 2×1, 1×2 크기의 타일을 채우려고 한다. 겹치지 않게 놓는다면, 최대 몇 개를 채울 수 있을까?
 */
public class 구현_넓이구하기_15700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        System.out.println(N * M / 2);
    }
}


