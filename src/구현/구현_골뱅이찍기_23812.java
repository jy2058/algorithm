package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/23812
 * 23812 / 골뱅이 찍기 - 돌아간 ㅍ
 * 브론즈3
 *
 * 서준이는 아빠로부터 골뱅이가 들어 있는 상자를 생일 선물로 받았다. 상자 안에는 반시계 방향으로 90도 돌아간 ㅍ자 모양의 골뱅이가 들어있다. 돌아간 ㅍ자 모양은 가로 및 세로로 각각 5개의 셀로 구성되어 있다. 상자에는 정사각형 모양의 셀의 크기를 나타내는 숫자 하나가 적혀있다. 셀의 크기 N이 주어지면 예제 출력과 같은 방식으로 골뱅이 모양을 출력하시오.
 */
public class 구현_골뱅이찍기_23812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int cnt = 1;    // cnt가 N과 같은지 비교 변수
        boolean flag = true;    // 전체 @ 출력인지 확인 변수
        // N에 5를 곱한 만큼 반복 ( 행,열 모두 )
        for (int i = 1; i <= N * 5; i++) {
            for (int j = 1; j <= N * 5; j++) {
                // @ 전체 출력 X
                if (flag) {
                    // j가 N과 같을때까지, 마지막 N의 개수만큼 @출력
                    if (j <= N || j > N * 5 - N) {
                        sb.append("@");
                    } else {
                        sb.append(" ");
                    }
                } else {
                    sb.append("@");
                }
            }
            // cnt가 N과 같아지면 @ 전체 출력
            if (cnt == N) {
                flag = !flag;
                cnt = 0;
            }
            cnt++;

            sb.append("\n");
        }
        System.out.println(sb);
    }

}

/*
    1. 각 행과 열은 입력 받은 N의 * 5를 한 만큼 반복이 된다
    2. N만큼 행을 반복하면 전체 ‘@’를 출력하는 것과 공백을 같이 출력하는 것으로 나뉜다.
    3. 열은 시작부터 N만큼, 마지막 N만큼  ‘@’ 출력하며 나머지는 공백을 출력한다.
 */
