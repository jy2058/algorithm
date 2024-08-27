package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/2667
 * 2667 / 단지번호붙이기
 * 백준 실비1
 *
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 */
public class DFS_단지번호붙이기_2667 {
    private static int[][] arr;
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n;
    static List<Integer> sizes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j] && arr[i][j] == 1) {
                    int size = dfs(i, j);
                    sizes.add(size);
                }
            }
        }

        Collections.sort(sizes);
        System.out.println(sizes.size());
        for (int size : sizes) {
            System.out.println(size);
        }
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    size += dfs(nx, ny);
                }
            }

        }
        return size;
    }
}

/*
이 문제는 연결된 집들을 찾아 단지별로 번호를 붙이는 분제로 DFS로 해결할 수 있다.

1. 지도를 순회하면서 아직 방문하지 않은 집을 발견하면 DFS를 시작한다.
2. DFS를 통해 연결된 모든 집을 방문하고, 단지에 속하는 집의 수를 센다.
3. 모든 단지를 찾은 후, 단지별 집의 수를 정렬하여 출력한다.
 */