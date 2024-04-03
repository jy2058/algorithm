package 맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10816
 * 10816 / 숫자 카드 2
 * 실버4
 *
 * 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램
 */
public class 해시맵_키의갯수_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 숫자카드 개수

        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 이미 존재하는 키일경우 + 1, 처음 등장하는 키일경우 0 + 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());    // 출력 갯수
        st = new StringTokenizer(br.readLine());    // 출력 키값
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            int target = Integer.parseInt(st.nextToken());
            // 해당 키가 있을 경우 해당 값 출력, 없을 경우 0 출력
            sb.append(map.getOrDefault(target, 0)).append(" ");
        }

        System.out.println(sb);
    }
}

/*
    해시 맵을 이용하여 해당 키의 갯수를 출력하면 되는 간단한 문제였다.

    1. 맵에 넣을 때 이미 존재하는 키일경우 키의 값을 +1, 처음 넣을경우 0 + 1
    2. 맵에 해당 키가 있을 경우 해당 값 출력, 없을 경우 0 출력
 */