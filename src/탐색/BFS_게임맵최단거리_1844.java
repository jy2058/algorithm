package 탐색;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 1844 / 게임 맵 최단거리
 *
 * ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
 * 지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
 * 최단거리1_sxuruo.png
 * 위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
 * 아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.
 * 첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.
 * 최단거리2_hnjd3b.png
 * 두 번째 방법은 15개의 칸을 지나서 상대팀 진영에 도착했습니다.
 * 최단거리3_ntxygd.png
 * 위 예시에서는 첫 번째 방법보다 더 빠르게 상대팀 진영에 도착하는 방법은 없으므로, 이 방법이 상대 팀 진영으로 가는 가장 빠른 방법입니다.
 * 만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다. 예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.
 * 최단거리4_of9xfg.png
 * 게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
 */
public class BFS_게임맵최단거리_1844 {
    public static int n,m;    // 맵의 가로,세로길이
    public static int answer = -1;    // 목적지에 도달하지 못했을 때 반환 값 -1로 초기화

    public static int[] dx = {-1, 1, 0, 0};   // 상, 하 이동
    public static int[] dy = {0, 0, -1, 1};   // 좌, 우 이동

    public static boolean[][] visited;    // 방문 여부 체크

    public static void main(String[] args) throws IOException {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];

        return bfs(0, 0, maps);
    }

    private static int bfs(int x, int y, int[][] maps) {
        // 팀색을 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        // 시작점을 큐에 추가하고 방문처리
        queue.add(new int[]{x, y, 1});
        visited[x][y] = true;

        // 큐가 빌때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 현재 위치와 이동거리 가져오기
            int[] temp = queue.poll();
            x = temp[0];
            y = temp[1];
            int cnt = temp[2];

            // 목적지에 도달했다면 answer를 갱신하고 반복 종료
            if (x == n - 1 && y == m - 1) {
                answer = cnt;
                break;
            }

            // 상, 하, 좌, 우 이동 가능한 위치 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵의 범위가 벗어나거나 벽(0)인 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0) continue;
                // 아직 방문하지 않은 경로(1)인 경우에만 큐에 추가하고 방문처리
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return answer;
    }
}

/*
2차원 맵에서 주어진 시작점에서 목적지까지의 최단 경로를 찾는 것입니다.

**사용된 알고리즘:** BFS (Breadth-First Search, 너비 우선 탐색)

**BFS 알고리즘**

- BFS는 가장 가까운 노드부터 차례대로 탐색하는 방법입니다.
- 큐(Queue)를 사용하여 구현하며, FIFO(First In First Out) 원칙에 따라 동작합니다.
- 모든 경로를 탐색하며, 최단 경로를 보장합니다.

1. **초기화**:
    - 맵의 크기(**`n`**, **`m`**)를 결정하고, **`visited`** 배열을 모두 **`false`**로 초기화하여 방문하지 않은 상태로 설정합니다.
    - 시작점을 큐에 추가하고, 해당 위치를 방문했다고 표시합니다(**`visited[0][0] = true`**).
2. **큐(Queue) 사용**:
    - BFS는 너비 우선 탐색이므로, FIFO(First In First Out) 원칙을 따르는 큐를 사용합니다.
    - 큐에서 노드(위치)를 하나씩 꺼내어 해당 노드에서 이동할 수 있는 모든 방향을 탐색합니다.
3. **노드 탐색**:
    - 현재 노드에서 상하좌우로 이동할 수 있는지 확인합니다. 이동할 수 있는 노드는 **`maps[nx][ny] == 1`**인 경우입니다.
    - 벽(**`0`**)이거나 맵의 범위를 벗어나는 경우는 탐색하지 않습니다.
4. **방문 체크**:
    - 이동할 수 있는 노드를 발견하면, 해당 노드를 방문했다고 표시합니다(**`visited[nx][ny] = true`**).
    - 이동한 노드와 현재까지 이동한 거리(**`cnt + 1`**)를 큐에 추가합니다.
5. **목적지 도달 여부 확인**:
    - 만약 현재 노드가 목적지(**`n-1`**, **`m-1`**)라면, 현재까지의 거리(**`cnt`**)를 **`answer`**에 저장하고 탐색을 종료합니다.
6. **결과 반환**:
    - 모든 탐색이 끝나면 **`answer`**를 반환합니다. 만약 목적지에 도달하지 못했다면 **`1`**이 반환됩니다.
 */