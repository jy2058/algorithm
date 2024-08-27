package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1260
 * 1260 / DFS와 BFS
 * 실버2
 *
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 */
public class DFS_BFS_DFS와BFS_1260 {
    private static boolean[] check;
    private static StringBuilder sb;
    private static int n;
    private static int[][] arr;
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점
        int m = Integer.parseInt(st.nextToken()); // 간선
        int v = Integer.parseInt(st.nextToken()); // 시작점

        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int curr = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            arr[next][curr] = arr[curr][next] = 1;
        }

        sb = new StringBuilder();

        // DFS
        dfs(v);
        sb.append("\n");

        Arrays.fill(check, false);

        // BFS
        queue = new LinkedList<>();
        bfs(v);

        System.out.println(sb.toString());

    }

    private static void bfs(int num) {
        queue.add(num);
        check[num] = true;
        while (!queue.isEmpty()) {
            num = queue.poll();
            sb.append(num + " ");

            for (int i = 1; i <= n; i++) {
                if (arr[num][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }

    private static void dfs(int num) {
        check[num] = true;
        sb.append(num + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[num][i] == 1 && !check[i]) {
                dfs(i);
            }
        }

    }
}
