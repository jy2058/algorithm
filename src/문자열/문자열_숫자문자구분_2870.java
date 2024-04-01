package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2870
 * 2870 / 수학숙제
 * 실버4
 *
 * 소문자와 숫자로 이루어진 문자에서 숫자를 찾아 오름차순으로 출력하는 문제
 */
public class 문자열_숫자문자구분_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<BigInteger> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            // 문자일경우 " " 로 변경하여 숫자만 생성
            String onlyDigit = s.replaceAll("[^0-9]", " ");
            // 공백과 섞여있는 문자열을 숫자만 출력
            st = new StringTokenizer(onlyDigit, " ");
            while (st.hasMoreTokens()){
                // 리스트에 숫자 추가
                list.add(new BigInteger(st.nextToken()));
            }
        }

        // 오름차순을 위한 list 정렬
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}

/*
    문자열에서 숫자와 문자를 구분하는 문제였다.
    1. replace와 정규식을 써서 문자일 경우 공백으로 변환
    2. 공백을 기준으로 숫자 잘라서 list에 추가
        -> 리스트를 이용하는 이유는 정렬을 하기 위함.
    3. 오름차순으로 정렬

    숫차 런타임 오류가 발생했다. 숫자의 길이가 길 수 있기 때문에
    Bigint를 사용해줘야 한다.

 */
