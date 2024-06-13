package 그래프;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * 49191 / 순위
 *
 * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
 * 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class 그래프_플로이드워셜_순위_49191 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(n, results));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            graph[result[0]][result[1]] = true;
        }

        // 플로이드-워셜 알고리즘 적용
        // 선수 i가 선수 k를 이기고, 선수 k가 선수 j를 이긴 경우,
        // 선수 i는 선수 j를 이긴 것으로 간주하고 graph[i][j]를 true로 설정
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        // 순위 결정할 수 있는 선수의 수 계산
        // 다른 모든 선수와의 승패 여부를 확인
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                // 선수 i가 선수 j를 이기거나, 선수 j가 선수 i를 이긴 경우 count를 증가
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }
            // 한 선수가 다른 모든 선수와의 경기에서 승리하거나 패배한 기록이 있는지 확인
            // 만약 count가 n-1과 같다면, 선수 i의 순위를 결정할 수 있으므로 answer를 증가
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}

/*
이 문제는 플로이드-워셜 알고리즘을 사용하여 해결할 수 있는 문제입니다.
플로이드-워셜 알고리즘은 모든 정점 쌍 간의 최단 경로를 찾는 알고리즘으로, 이 문제에서는 선수들 간의 승패 관계를 그래프로 표현하여 각 선수가 다른 모든 선수와의 경기에서 승패 여부를 확인할 수 있는지를 판단하는 데 사용됩니다

1. **`graph`** 배열을 사용하여 선수 간의 승패 관계를 인접 행렬로 표현합니다.
2. 플로이드-워셜 알고리즘을 적용하여 각 선수가 다른 선수를 이길 수 있는지 여부를 갱신합니다.
3. 각 선수에 대해 다른 모든 선수와의 승패 여부를 확인하여 순위를 결정할 수 있는지를 계산합니다.
 */