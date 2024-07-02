package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1926
 * 1926 / 그림
 * 실버 1
 *
 * 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.
 */
public class BFS_그림최대넓이_1926 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx, dy;
    static Queue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];


        // 오른쪽, 아래, 왼쪽, 위
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, -1, 0, 1};

        // 배열에 입력받은 값 넣기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그림 개수, 넓이, 최대 넓이
        int count = 0,  max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 0이거나 방문한적 있으면 패스
                if (arr[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                count++;    // 1이고 방문한적 없으니 시작점이 된다

                // bfs 호출
                int area = bfs(i, j);

                if (area > max) {
                    max = area;
                }
            }

        }
        System.out.println(count);
        System.out.println(max);
    }

    private static int bfs(int i, int j) {
        queue = new LinkedList<>();
        queue.offer(new Pair(i, j));    // 큐에 좌표 넣기
        visited[i][j] = true;   // 방문표시

        int area = 0;   // 그림이 끊겼으므로 0으로 셋팅

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            area++; // 넓이 + 1
            for (int k = 0; k < 4; k++) {
                int nx = current.x + dx[k];
                int ny = current.y + dy[k];
                // map 범위를 벗어나는지 체크
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }

                // 새로운 위치를 탐색하고 방문 처리
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return area;
    }

    public static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}

/*
    이 문제는 주어진 2차원 배열에서 1로 이루어진 연결된 영역(그림)의 개수와 각 그림의 넓이를 구하는 문제입니다.
    BFS를 이용하여 문제를 풀 수 있습니다.

    1. 2차원 배열의 크기와 배열의 값을 입력받습니다.
    2. 각 위치가 방문되었는지 확인하는 배열을 초기화합니다.
    3. 배열을 순회하며 방문하지 않은 1을 발견할 때마다 BFS를 시작합니다.
    4. BFS를 통해 해당 그림의 넓이를 계산하고, 방문한 위치를 모두 방문처리를 합니다.
    5. 모든 그림을 탐색하며 그림의 개수와 최대 넓이를 추적합니다.
 */


