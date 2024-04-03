package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2164
 * 2164 / 카드2
 * 실버4
 *
 * 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮기는 문제
 */
public class 큐_카드삽입삭제_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        // 순차적으로 번호 N까지 추가
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            q.poll();   // 큐에서 꺼내기
            Integer temp = q.poll();
            q.offer(temp);  // 꺼낸 값을 뒤에 추가하기
        }

        System.out.println(q.peek());
    }
}

/*

    제일 앞에 있는 카드를 꺼내고 그 다음 카드를 뒤에 추가 해주는 간단한 큐 문제였다.

    1. 큐에 N까지의 번호 추가하기
    2. 카드가 한장만 남을때까지 큐에서 카드를 꺼내고, 두 번째 꺼낸 값을 뒤에 추가하기를 반복
 */