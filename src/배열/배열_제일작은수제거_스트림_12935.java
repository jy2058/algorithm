package 배열;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12935
 * 12935 / 제일 작은 수 제거하기
 * 프로그래머스
 *
 * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 */
public class 배열_제일작은수제거_스트림_12935 {
    public static void main(String[] args) throws IOException {
        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }
    public static int[] solution(int[] arr) {
        if (arr.length <= 1) return new int[]{ -1 };
        // 최솟값 찾기
        int min = Arrays.stream(arr).min().getAsInt();
        // 최솟값 제거하여 새 배열로 리턴
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}

