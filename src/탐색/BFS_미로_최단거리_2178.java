package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2178
 * 2178 / 미로 탐색
 * 실버 1
 *
 * N×M크기의 배열로 표현되는 미로가 있다.
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 */
public class BFS_미로_최단거리_2178 {

    private static boolean[][] visited;
    private static int[] dx;
    private static int[] dy;
    private static int n;
    private static int m;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        // 상, 하, 좌, 우
        dx = new int[]{0, 0, -1, 1};
        dy = new int[]{-1, 1, 0, 0};


        // 미로의 크기 입력받기
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        // 출발점에서 bfs 시작
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int startX, int startY) {
        Queue<Pair> queue = new LinkedList<>(); // bfs를 위한 큐
        queue.offer(new Pair(startX, startY));  // 시작점을 큐에 넣기
        visited[startX][startY] = true; // 시작점 방푼 표시

        int[][] distance = new int[n][m];   // 각 점까지의 거리를 기록할 배열
        distance[startX][startY] = 1;   // 시작점의 거리는 1

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int x = current.x;
            int y = current.y;

            // 상하좌우로 이동
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 새로운 위치가 미로 범위를 벗어나는지 체크
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // 이동가능하면 큐에 넣고 방문여부와 거리 업데이트
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new Pair(nx, ny));  // 큐에 새로운 위치를 넣음
                    visited[nx][ny] = true; // 새로운 위치 방문 표시
                    distance[nx][ny] = distance[x][y] + 1;  // 새로운 위치까지의 거리 업데이트
                }
            }
        }

        // 도착점 거리 리턴
        return distance[n - 1][m - 1];
    }

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/*

이 문제는 미로 찾기 문제이다. 미로의 출발점 (0, 0)에서 시작하여 도착점 (n-1, m-1)까지 가야한다.
이 문제의 목표는 최단 경로를 찾는 것이기때문에 BFS(너비 우선 탐색) 알고리즘을 이용한다.
BFS는 모든 인접한 노드를 한 단계씩 탐색하기 때문에 최단 경로 문제에 적합하기 떄문이다.

1. 미로를 입력받기: 미로의 크기와 각 칸의 값을 입력받는다.
2. BFS를 위한 준비: 탐색에 사용할 큐(Queue)와 방문 여부를 기록할 배열을 준비한다.
3. BFS 수행: 출발점에서 시작하여 큐를 사용해 상하좌우로 이동하면서 최단 경로를 찾는다.
4. 결과 출력: 도착점에 도달했을 때의 거리를 출력한다.
 */


