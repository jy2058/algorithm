package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1158
 * 1158 / 요세푸스 문제
 * 실버4
 *
 * (N, K)-요세푸스 순열 문제 (K번째 제거되는 순서)
 */
public class 큐_요세푸스_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 인원
        int K = Integer.parseInt(st.nextToken());   // 몇 번째 제거할지

        Queue<Integer> q = new LinkedList<>();

        // N명의 순서 번호 추가
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        // 큐에 한 사람 남을때까지
        while (q.size() != 1) {
            // K 번째의 전 까지 큐에서 빼서 뒤에 추가하기
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            // K번째 사람 큐에서 빼고 출력
            sb.append(q.poll()).append(", ");
        }

        // 마지막 남은 사람 빼서 출력
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}

/*
    N명 중 반복하여 K번째에 제거 되는 사람을 구하는 문제였다. 그래서 큐를 이용해 간단하게 풀었다.

    1. N 명의 순서 번호를 추가
    2. K번째의 전 까지 큐에서 빼서 뒤에 넣기
    3. K번째 사람은 큐에서 빼고 출력
    4. 2, 3번을 큐에 한 사람만 남을때까지 반복
    5. 마지막 남은 사람 큐에서 빼서 출력
 */