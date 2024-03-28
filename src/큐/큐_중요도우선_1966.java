package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐_중요도우선_1966 {
    /*
        현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 문제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 문서 개수
            int num = Integer.parseInt(st.nextToken());
            // 문서 위치
            int target = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < num; j++) {
                // 우선순위
                int n = Integer.parseInt(st.nextToken());
                // 문서의 위치와 우선순위를 배열로 큐에 저장
                queue.add(new int[]{j, n});
            }

            int cnt = 0;
            while (true) {
                int[] cur = queue.poll();
                // 우선순위가 제일 높은지 체크 변수
                boolean check = true;

                for (int[] curQueue : queue) {
                    // 우선순위 비교
                    // 현재 큐 > 꺼낸 큐 값
                    if (curQueue[1] > cur[1]) {
                        check = false;
                        break;
                        // 꺼낸 비교 큐 값이 이미 작으면 더 확인할 필요 없음
                    }
                }

                // 우선순위가 제일 높을 경우
                if (check) {
                    cnt++;
                    // 찾고자 하는 문서일 경우에만 break. 그외는 횟수만 추가해준다.
                    if (cur[0] == target) break;
                // 우선순위가 높지 않다면 큐에 추가
                } else {
                    queue.add(cur);
                }
            }
            System.out.println(cnt);
        }
    }
}

/*
    큐를 이용해서 중요도가 높은 게 있으면 해당 문서를 먼저 출력
    그 외에는 맨 뒤로 다시 옮겨준다. 이를 반복하여 중요도가 높은 문서가 맨 앞에 배치 되도록 하는 것

    1. 문서의 초기 위치와 우선순위를 배열로 큐에 저장한다.
    2. 큐에서 하나씩 꺼내며 큐에 있는 값들과 우선순위를 비교한다.
    3. 우선 순위가 제일 높을 경우
        - 탐색 횟수를 +1 하고
        - 탐색하고자 한 문서일 경우 출력한다.
    4. 우선 순위가 제일 높지 않을 경우 큐에 다시 추가한다.
 */