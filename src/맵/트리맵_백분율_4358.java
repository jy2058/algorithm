package 맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://www.acmicpc.net/problem/4358
 * 4358 / 생태학
 * 실버2
 *
 * 주어진 각 종의 이름을 사전순으로 출력하고, 그 종이 차지하는 비율을 백분율로 소수점 4째자리까지 반올림해 함께 출력한다
 */

public class 트리맵_백분율_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new TreeMap<>();
        String s = "";
        int cnt = 0;
        while ((s = br.readLine()) != null) {
            cnt++;
            // 맵에 이미 존재하면 + 1 그 외는 1로 추가
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            int value = map.get(key);
            // 백분율 구하기
            double per = value * 100.0 / cnt;
            // String format을 이용해 소숫점 4자리까지 출력
            sb.append(key).append(" ").append(String.format("%.4f", per)).append("\n");
        }

        System.out.println(sb);
    }
}

/*
    해당 문제는 주어지는 값들을 백분율을 구해 정렬하여 출력하는 문제였다.

    해당 값들이 몇 번씩 저장 되는지 구하려면 Map이 필요하고, 정렬이 필요하다 해서 TreeMap을 사용했다.

    1. 맵에 해당 값이 이미 존재하면 + 1 그 외 1을 저장한다.
    2. 전체 값의 갯수를 구하기 위해 cnt 변수를 사용
    3. map.keySet()을 이용하여 각 키에 해당하는 값을 가져온다
    4. 해당 값에 * 100.0을 하여 백분율을 구한다.
    5. String format을 이용하여 소숫점 4자리까지 출력한다.
 */