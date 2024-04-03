package 배열;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12950
 * 12950 / 행렬의 덧셈
 *
 * 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수
 */
public class 배열_2차원_덧셈 {
    public static void main(String[] args) throws IOException {
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};
        System.out.println(solution(arr1, arr2));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2){
        // 입력받은 2차원 배열 사이즈만큼 배열 생성
        int[][] answer = new int[arr1.length][arr1[0].length];

        // 2차원 배열 이중 for문 돌면서 각 배열의 값 더하기
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}

