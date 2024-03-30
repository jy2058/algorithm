package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/18115
 * 18115 / 카드 놓기
 * 실버3
 *
 * 카드 놓는 기술이 있을 때 그 기술을 사용 후 카드가 순서대로일 때 초기 카드의 순서를 구하는 문제
 */
public class 스택_덱_카드놓기_18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드 기술 순서를 역순으로 저장하기 위해 list 사용
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.reverse(list);

        for (int j = 1; j <= N; j++) {
            int num = list.get(j-1);    // list에는 0부터 저장돼있음
            // 1일때는 맨 앞에 추가
            if (num == 1) {
                q.offerFirst(j);
            // 2일때는 두 번째 카드를 넣어야하니까
            // 이전 카드를 뺴고 현재 카드를 넣고 이전 카드를 다시 넣어준다
            } else if (num == 2) {
                int tmp = q.pollFirst();
                q.offerFirst(j);
                q.offerFirst(tmp);
            // 3일때는 제일 뒤에 넣는다.
            } else if (num == 3) {
                q.offerLast(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}
/*
    앞과 뒤에 데이터를 추가하는 과정이 있어서 덱을 사용했다.

    카드의 마지막 상태인 1,2,...,N 부터 처음의 카드 상태를 구해야 하기 때문에
    기술의 순서를 역순으로 처리를 해줘야 한다.

    1. list를 이용해서 역순으로 기술을 입력받는다.
    2. 1번째 기술일 때 덱 맨 앞에 추가한다.
        -> 1은 제일 위에 있는 카드를 내려놓기 때문
    3. 2번째 기술일 떄 덱 맨 앞에서 두 번째 위치에 추가해준다.
        -> 1) 첫 번쨰 카드 제거
            2) 그 다음 카드 추가
            3) 제거한 카드를 맨 앞에 다시 추가
    4. 3번쨰 기술일 때 덱 맨 뒤에 추가
    5. 모든 과정이 끝나면 덱 앞에서부터 출력
 */