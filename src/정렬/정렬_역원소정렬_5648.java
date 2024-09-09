package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5648
 * 5648 / 역원소 정렬
 * 백준 실버 5
 *
 * 모든 원소가 양의 정수인 집합이 있을 때, 원소를 거꾸로 뒤집고 그 원소를 오름차순으로 정렬하는 프로그램을 작성하세요.
 *
 * 단, 원소를 뒤집었을 때 0이 앞에 선행되는 경우는 0을 생략해야합니다.
 */
public class 정렬_역원소정렬_5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> queue = new PriorityQueue<>();

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());

        while (n > 0) {
            while (!st.hasMoreTokens()) {
                line = br.readLine();
                st = new StringTokenizer(line);
            }
            String token = st.nextToken();
            StringBuilder sb = new StringBuilder(token);
            String reversed = sb.reverse().toString();
            queue.offer(Long.parseLong(reversed));
            n--;
        }

        StringBuilder output = new StringBuilder();
        while (!queue.isEmpty()) {
            output.append(queue.poll()).append("\n");
        }
        System.out.print(output);
    }
}


/*
이 문제는 정렬과 문자 역순 문제이다.
구현 자체는 간단했지만 Long 타입과 Token을 읽어올 때 주의해야 한다.
 */


