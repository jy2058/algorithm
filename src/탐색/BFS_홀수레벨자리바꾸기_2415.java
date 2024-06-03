package 탐색;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
 * 2415 / Reverse Odd Levels of Binary Tree
 *
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 * For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
 * Return the root of the reversed tree.
 * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
 * The level of a node is the number of edges along the path between it and the root node.
 *
 * Example 1:
 * Input: root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 * Explanation:
 * The tree has only one odd level.
 * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
 *
 * Example 2:
 * Input: root = [7,13,11]
 * Output: [7,11,13]
 * Explanation:
 * The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
 *
 * Example 3:
 * Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 * Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * Explanation:
 * The odd levels have non-zero values.
 * The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
 * The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.
 */
public class BFS_홀수레벨자리바꾸기_2415 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.right = new TreeNode(21);
        root.left.left.left = new TreeNode(34);

        System.out.println(solution(root));
    }

    public static TreeNode solution(TreeNode root) {
        // 트리가 비어있는지 확인
        if (root == null) {
            return root;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        // root노드를 큐에 추가
        q.offer(root);

        int level = 0; // 현재 레벨 추적 변수

        // 큐가 비어있지 않을때까지 반복
        while (!q.isEmpty()) {
            int size = q.size();    // 현재 레벨의 노드 수
            while (size-- > 0) {    // 현재 레벨의 모든 노드를 처리
                TreeNode node = q.poll();   // 큐에서 노드 하나 꺼내기
                if(node.left != null) q.offer(node.left);   // 왼쪽 자식이 있으면 큐에 추가
                if(node.right != null) q.offer(node.right); // 오른쪽 자식이 있으면 큐에 추가
            }

            level++;    // 다음레벨

            // 현재 레벨이 홀수이고, 큐가 비어있지 않으면 노드값 뒤집기
            if (level % 2 == 1 && !q.isEmpty()) {
                // 현재 레벨의 노드 값 저장할 배열
                int[] nums = new int[q.size()];
                int i = 0;
                // 배열에 노드 값 저장
                for (TreeNode node : q) {
                    nums[i++] = node.val;
                }

                // 배열을 뒤집어서 노드 값들을 업데이트
                int k = q.size() - 1;
                for (TreeNode node : q) {
                    node.val = nums[k--];
                }
            }
        }

        return root;
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
    완벽한 이진 트리가 주어졌을 때, 모든 홀수 레벨의 노드 값을 뒤집는 문제이다.
    완벽한 이진 트리란 모든 레벨이 노드로 가득 찬 트리를 의미한다.

    1. 너비 우선 검색(BFS) : 트리의 각 레벨을 순회하여 노드를 탐색한다.
    2. 레벨 추적 : 현재 레벨이 홀수인지 짝수인지 추적한다.
    3. 데이터 저장 : 홀수 레벨의 노드 값을 배열에 저장한다.
    4. 데이터 뒤집기 : 저장된 배열을 뒤집어서 노드 값들을 업데이트 한다.
 */