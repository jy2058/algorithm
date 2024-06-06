package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 * 894 / All Possible Full Binary Trees
 *
 * Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
 * Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Example 1:
 * Input: n = 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 *
 * Example 2:
 * Input: n = 3
 * Output: [[0,0,0]]
 */
public class DP_완전이진탐색만들기_894 {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(allPossibleFBT(n));
    }


    // 메모이제이션을 위한 해시맵
    private static HashMap<Integer, List<TreeNode>> memo = new HashMap<>();
    public static List<TreeNode> allPossibleFBT(int n) {

        // 짝수일 때 빈 목록 반환(짝수일 때 완전 이진탐색을 만들 수 없음)
        if (n % 2 == 0) return new ArrayList<>();
        // 이미 계산된 경우 저장된 결과 반환
        if (memo.containsKey(n)) return memo.get(n);

        List<TreeNode> result = new ArrayList<>();
        // n이 1인 경우는 단일 노드 트리만 가능
        if (n == 1) {
            result.add(new TreeNode(0));
        } else {
            // 모든 가능한 왼쪽 및 오른쪽 서브트리 조합 생성
            // n을 두부분으로 나누어 각각 왼쪽, 오른쪽 서브트리의 노드 수로 사용
            for (int i = 1; i < n; i += 2) {
                for (TreeNode left : allPossibleFBT(i)) {
                    // 왼쪽 서브트리에 i개 노드가 있다면, 오른쪽 서브트리에는 n - i - 1개의 노드
                    // -1은 루트노드를 위한 것
                    for (TreeNode right : allPossibleFBT(n - i - 1)) {
                        // 새로운 트리 생성
                        // 새로운 트리의 루트 노드는 항상 값이 0, 왼쪽, 오른쪽 자식으로 서브트리 연결
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }
        // 결과 저장 및 반환
        memo.put(n, result);
        return result;
    }

    // 트리 노드 정의
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}

/*
주어진 정수 **`n`**에 대해 모든 가능한 풀 바이너리 트리(full binary trees)의 목록을 반환하는 것을 요구합니다.
풀 바이너리 트리는 모든 노드가 정확히 0개 또는 2개의 자식을 가지는 이진 트리입니다. 
[각 트리의 노드 값은 0이어야 하며, 결과 목록의 각 요소는 하나의 가능한 트리의 루트 노드입니다](https://leetcode.com/problems/all-possible-full-binary-trees/).
이 문제를 해결하기 위해 재귀적으로 가능한 모든 왼쪽 및 오른쪽 서브트리를 생성하고, 이들을 조합하여 새로운 트리를 형성하는 것입니다. 
**`n`**이 홀수가 아니면 풀 바이너리 트리를 형성할 수 없으므로 빈 목록을 반환해야 합니다.

1. **기본 사례(Base Case)**:
    - **`n`**이 1일 때, 유일한 가능한 트리는 하나의 노드만 있는 트리입니다.
    - **`n`**이 짝수일 때, 풀 바이너리 트리를 만들 수 없으므로 빈 리스트를 반환합니다.
2. **재귀적 구조(Recursive Structure)**:
    - **`n`**이 홀수일 때, **`n`**을 두 부분으로 나누어 각각을 왼쪽과 오른쪽 서브트리의 노드 수로 사용합니다.
    - 왼쪽 서브트리에 **`i`**개의 노드가 있다면, 오른쪽 서브트리에는 **`n - i - 1`**개의 노드가 있어야 합니다(**`i`**는 홀수여야 하며, **`1`**은 루트 노드를 위한 것입니다).
3. **메모이제이션(Memoization)**:
    - 이미 계산된 **`n`**에 대한 결과는 메모리에 저장하여 중복 계산을 방지합니다.
4. **트리 구성(Tree Construction)**:
    - 가능한 모든 왼쪽 및 오른쪽 서브트리 조합을 탐색하며, 각 조합에 대해 새로운 트리를 만듭니다.
    - 새로운 트리의 루트 노드는 항상 값이 0이며, 왼쪽 및 오른쪽 자식으로 서브트리를 연결합니다.
5. **결과 반환(Returning Results)**:
    - 모든 가능한 트리를 리스트에 담아 반환합니다.
 */