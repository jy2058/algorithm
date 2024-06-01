package 탐색;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 * 1302 / Deepest Leaves Sum
 *
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * Example 2:
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 */
public class BFS_가장깊은리프합계_1302 {
    static int maxLevel = 0;  // 가장 깊은 트리레밸을 저장할 변수
    static int sum = 0; // 합계를 저장할 변수

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);


        System.out.println(solution(root));
    }

    public static int solution(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode root, int level) {
        if(root == null) return;

        // 왼쪽 자식노드 탐색
        dfs(root.left, level + 1);
        // 오른쪽 자식노드 탐색
        dfs(root.right, level + 1);

        // 현재 레벨이 maxLevel보다 깊으면 sum을 초기화하고 maxLevel을 업데이트
        if (level > maxLevel) {
            sum = 0;
            maxLevel = level;
        }
        // 현재 레벨이 maxLevel과 같으면 현재 노드의 값을 sum에 더하기
        if (level == maxLevel) {
            sum += root.val;
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/*
가장 깊은 노드의 합계를 구하려면 DFS방식을 사용하여 재귀로 푸는 게 간편하고 효율적이라고 생각했다.

1. 현재 노드와 현재 레벨을 인자로 받는다.
2. 재귀적으로 왼쪽과 오른쪽 서브트리를 탐색한다.
3. 현재 레벨이 maxLevel보다 깊으면 sum을 0으로 초기화하고 maxLevel을 현재 레벨로 업데이트한다.
4. 현재 레벨이 maxLevel과 같으면 현재 노드의 값을 sum에 더해준다.
 */