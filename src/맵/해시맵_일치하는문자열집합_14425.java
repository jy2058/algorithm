package 맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14425
 * 14425 / 문자열 집합
 * 실버4
 *
 * 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
 */
public class 해시맵_일치하는문자열집합_14425 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 집합의 개수
        int M = Integer.parseInt(st.nextToken());   // 문자열 개수

        Map<String, Integer> map = new HashMap<>();
        // 입력받은 집합을 map의 키 값으로 저장
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        int count = 0;  // 일치하는 개수

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            // 문자열이 map의 키값으로 존재하면 집합에 포함된 것
            if (map.containsKey(s)) {
                count++;
            }
        }

        System.out.println(count);
    }
}

/*
    입력받은 문자열이 기존 집합에 포함이 되는지 확인하는 문제였다.
    처음에는 단순히 집합 문자열을 배열로 받아 해당 배열에 입력받는 문자열이 일치하는지 확인을 헀었는데 for문이 2중으로 들어가다보니 비효율적이었다.
    그래서 Map에 집합 문자열을 키 값으로 넣어 입력받는 문자열이 키로 존재하는지 확인하는 방법으로 바꿨다.

    1. 입력받는 집합 문자들을 Map에 키로 저장한다.
    2. 입력받는 문자열을 Map의 containsKey 메서드를 이용해서 키값으로 존재하는지 확인한다.
    3. 키값으로 존재하면 count 증가

    💡 HashMap 보다는 HashSet을 이용하면 더 효율적일 것 같다.

 */