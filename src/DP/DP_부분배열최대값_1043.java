package DP;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 * 1043 / Partition Array for Maximum Sum
 */
public class DP_부분배열최대값_1043 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];  // 각 인덱스까지의 최대 합을 저장
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;    // 현재 부분배열의 최대값 저장
            // j는 1부터 k까지, 또는 부분 배열의 길이가 될 수 있는 최대값까지 반복
            // j: 부분배열 길이
            for (int j = 1; j <= Math.min(i, k); j++) {
                // 현재 부분 배열의 최대값 찾기
                max = Math.max(max, arr[i - j]);
                // 이전까지의 최대 합에 현재 부분배열의 최대값을 곱한 값을 더하기
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);

            }
        }
        return dp[n];
    }
}

/*
- 입력 배열 **`arr`**가 주어지고, 배열을 최대 길이 **`k`**의 연속된 부분 배열로 나눕니다.
- 각 부분 배열의 모든 값을 해당 부분 배열의 최대값으로 변경합니다.
- 변경된 배열의 합이 최대가 되도록 합니다.

1. 동적 프로그래밍(Dynamic Programming)을 사용하여 문제를 해결합니다.
2. **`dp[i]`**를 정의하여, 첫 번째 요소부터 i번째 요소까지 최적의 방법으로 나누었을 때의 최대 합을 저장합니다.
3. 각 **`i`**에 대해, 가능한 모든 **`j`** (1 ≤ j ≤ k)를 확인하며, **`i-j`**부터 **`i`**까지의 부분 배열에서 최대값을 찾습니다.
4. 이 최대값을 사용하여 **`dp[i]`**를 업데이트합니다.
 */