package 그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 * 49189 / 가장 먼 거리
 *
 * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
 * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
 */
public class 그래프_BFS_가장먼거리_49189 {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, vertex));
    }

    public static int solution(int n, int[][] edge) {
        // 노드 방문 여부 추적. 노드 번호가 1부터 시작하기 때문에 n+1
        boolean[] visited = new boolean[n + 1];

        // 그래프를 인접리스트로 표현하기 위해 2차원 리스트 생성
        // 각 노드에 연결된 다른 노드들의 목록을 저장
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 주어진 간선정보로 그래프 구성
        // 양방향으로 간선을 추가하여 무방향 그래프로 만듦
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // BFS를 위한 큐 생성
        Queue<Integer> q = new LinkedList<>();
        // 큐에 시작노드인 1번 추가하고 방문 표시
        q.offer(1);
        visited[1] = true;

        int[] distance = new int[n + 1];    // 각 노드까지의 거리 저장 배열
        Arrays.fill(distance, -1);  // 모든 값 -1로 초기화
        distance[1] = 0;    // 1번노드는 0으로 초기화

        // 큐가 빌 때까지 BFS를 수행
        // 큐에서 노드를 하나 꺼내 (curr) 해당 노드에 인접한 노드들을 탐색
        // 방문하지 않은 노드를 큐에 추가하며 거리를 업데이트
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    distance[next] = distance[curr] + 1;
                }
            }
        }

        int maxDistance = Arrays.stream(distance).max().getAsInt();
        // distance 배열에서 maxDistance와 같은 값을 가진 요소의 개수 저장(가장 멀리 떨어진 노드의 개수)
        int count = (int)Arrays.stream(distance).filter(d -> d == maxDistance).count();

        return count;
    }
}

/*
이 문제는 주어진 그래프에서 1번 노드로부터 가장 멀리 떨어진 노드의 개수를 찾는 문제입니다.

그래프의 탐색 알고리즘 중 하나인 너비 우선 탐색(BFS)을 사용하는 것이 일반적입니다.

BFS를 사용하면 각 노드까지의 최단 거리를 계산할 수 있으며, 이를 통해 가장 멀리 떨어진 노드들을 찾을 수 있습니다.

1. 각 노드가 연결된 정보를 저장할 수 있는 자료구조를 준비합니다.
    - **`ArrayList<ArrayList<Integer>>`**를 사용하여 각 노드의 인접 리스트를 표현할 수 있습니다.
2. BFS를 위한 큐를 준비하고, 시작 노드인 1번을 큐에 삽입합니다.
3. 1번 노드부터 시작하여 BFS를 수행하면서 각 노드까지의 거리를 저장합니다.
4. 모든 노드를 탐색한 후, 가장 멀리 떨어진 노드들의 거리를 찾고, 해당 거리에 있는 노드의 개수를 계산합니다.
 */