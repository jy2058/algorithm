package 배열;

import java.io.IOException;
import java.util.Arrays;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/12910
 * 12910 / 나누어 떨어지는 숫자 배열
 *
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 */
public class 배열_스트림_필터_정렬_12910 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[] {5, 9, 7, 10};
        int divisor = 5;
        System.out.println(solution(arr, divisor));
    }
    public static int[] solution(int[] arr, int divisor) {
        // 스트림을 이용하여 2로 나누어 떨어지는 수를 필터링하고 배열로 반환
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        // 길이가 0일 때는 -1 리턴
        if(answer.length == 0) answer = new int[] {-1};
        // 오름차순 정렬
        Arrays.sort(answer);
        return answer;
    }
}
/*
    입력 받은 수의 배열 중 특정 수로 나누어 떨어지는 수들을 오름차순으로 정렬하여 배열로 리턴하는 문제였다.

    1. stream을 생성하여 입력 받은 수로 나누어 떨어지는 수만 필터링하여 배열로 리턴한다.
    2. 배열의 길이가 0일때는 -1를 리턴한다.
    3. 오름차순으로 배열을 정렬 후 리턴한다.

 */