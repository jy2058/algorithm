package 탐색;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 43165 / 타겟 넘버
 *
 * n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class DFS_타겟넘버_43165 {
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0); // dfs 탐색 시작
        return answer;
    }

    /**
     * 깊이우선탐색을 사용하여 타겟 넘버를 만드는 방법의 수를 찾는 재귀 메소드
     * @param numbers 숫자 배열
     * @param target 목표 값
     * @param idx 인덱스
     * @param sum 총합
     */
    private static void dfs(int[] numbers, int target, int idx, int sum) {
        // 모든 숫자를 사용했을 때
        if (idx == numbers.length) {
            // 현재까지의 합계가 타겟 값과 같으면 answer 값 증가
            if (sum == target) answer++;
            return; // 탐색 중단하고 이전 단계로 돌아가기
        }

        // 현재 숫자를 더하는 경우 탐색
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        // 현재 숫자를 뺴는 경우 탐색
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}

/*
    주어진 숫자 배열을 사용하여 타겟 넘버를 만드는 모든 가능한 방법의 수를 찾는 문제이다.
    그렇기 때문에 DFS 알고리즘을 선택하였다.
    DFS는 모든 가능한 조합을 탐색하는 데 적합하며, 재귀적 구조를 통해 간결하게 구현할 수 있기 때문이다.

    1. **재귀 함수 정의**: 현재 인덱스와 현재까지의 합을 매개변수로 받는 **`dfs`** 함수를 정의한다.
    2. **베이스 케이스**: 모든 숫자를 사용했을 때(**`index == numbers.length`**), 현재 합이 타겟 넘버와 같은지 확인한다.
    3. **재귀 케이스**: 현재 숫자를 더하거나 빼는 두 가지 경우로 재귀 호출을 진행한다.
 */