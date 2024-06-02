package 탐색;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 * 797 / all-paths-from-source-to-target
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 * Example 1:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 * Example 2:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */
public class BFS_모든경로탐색_797 {
    public static void main(String[] args) throws IOException {

//        int[][] graph = {{1,2},{3},{3},{}};
        int[][] graph = {{4,3,1},{3,2,4},{3},{4}, {}};
        System.out.println(solution(graph));
    }

    public static List<List<Integer>> solution(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);    // 시작 노드 추가
        dfs(graph, 0, path, paths);

        return paths;
    }

    private static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        // 목표 노드에 도달하면 현재 경로를 결과에 추가
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        // 현재 노드에서 갈 수 있는 모든 노드에 대해 DFS 수행
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(graph, nextNode, path, paths);
            // path 리스트의 마지막 요소를 제거
            // 목표 노드에 도달하거나 더 이상 탐색할 노드가 없을 때, 마지막에 추가된 노드를 제거함으로써 이전 분기점으로 “되돌아가는” 것
            path.remove(path.size() - 1);
        }

    }


}

/*
모든 노드를 탐색, 백트래킹 필요하기 때문에 DFS를 사용한다1. DFS를 사용하여 시작 노드에서 목표 노드까지 가능한 모든 경로를 찾습니다.

1. 각 노드에서 이동할 수 있는 다음 노드들을 순회하면서 경로를 구성하고, 목표 노드에 도달하면 해당 경로를 결과 목록에 추가합니다.
2. 백트래킹을 통해 이미 방문한 노드를 경로에서 제거하고 다른 가능한 경로를 탐색합니다.
 */
