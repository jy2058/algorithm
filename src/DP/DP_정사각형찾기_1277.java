package DP;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 1277 / Count Square Submatrices with All Ones
 */
public class DP_정사각형찾기_1277 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int count = 0;

        // 배열 순회하면서 dp값 갱신하고, 정사각형 개수 세기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    // 행 또는 열이 시작점이면 정사각형은 본인만 만들 수 있음
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 이전에 계산된 위, 왼쪽, 위쪽 대각선의 최소값에 1을 더한다
                        // (i, j) 위치에서 만들 수 있는 정사각형의 최대 크기를 의미
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j-1]), dp[i - 1][j - 1]) + 1;
                    }
                    // 각 위치에서 만들 수 있는 정사각형의 수를 더한다.
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}

/*

2차원 배열에서 1로만 이루어진 정사각형의 수를 세는 문제입니다.
이 문제를 해결하기 위해 **동적 프로그래밍(Dynamic Programming)** 기법을 사용할 수 있습니다.

### 동적프로그래밍
`dp[i][j]`는 `(i, j)` 위치에서 만들 수 있는 **가장 큰 정사각형의 변의 길이**를 나타냅니다. 이 값은 다음과 같이 계산됩니다:
dp[i][j]=min(dp[i−1][j],dp[i][j−1],dp[i−1][j−1])+1
이 공식은 `(i, j)` 위치에서 만들 수 있는 정사각형이 이전 위치의 정사각형 크기에 의존한다는 것을 나타냅니다.
만약 `dp[i-1][j]`, `dp[i][j-1]`, `dp[i-1][j-1]`의 값이 모두 2라면, `(i, j)` 위치에서는 3x3 크기의 정사각형을 만들 수 있습니다.

예를 들어, 다음과 같은 2차원 배열이 있다고 가정해 봅시다:
1 1 1 0
1 1 1 1
1 1 1 1
0 1 1 1

이 배열에서 만들 수 있는 정사각형을 찾기 위해 dp 배열을 다음과 같이 계산할 수 있습니다:
1 1 1 0
1 2 2 1
1 2 3 2
0 1 2 3
 */