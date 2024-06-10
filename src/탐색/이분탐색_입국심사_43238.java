package 탐색;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * 43238 / 입국 심사
 *
 * n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
 * 처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
 * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
 * 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */
public class 이분탐색_입국심사_43238 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = new int[]{7, 10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        // 탐색 범위 설정
        Arrays.sort(times);
        long left = times[0];   // 가능한 최소 시간
        long right = (long) times[times.length - 1] * n;    // 가능한 최대 시간

        // 이진 탐색 실행
        while (left <= right) {
            long mid = (left + right) / 2;  // 중간 값 게산
            long people = 0;

            // 각 심사대에서 mid 시간동안 심사받을 수 있는 사람 수 누적
            for (int a : times) {
                people += mid / a;
            }

            // 탐색 범위 조정
            // 심사받을 수 있는 사람 수가 n보다 적은 경우 최소시간 증가
            if (people < n) {
                left = mid + 1;
            // 심사받을 수 있는 사람 수가 n보다 많거나 같은 경우 최대시간 감소
            } else {
                answer = mid;   // 답 갱신
                right = mid - 1;
            }
        }
        return answer;
    }
}

/*
n명의 사람들이 입국심사를 모두 받는 데 걸리는 최소 시간을 찾는 문제입니다.
이진 탐색은 정렬된 데이터에서 특정 값을 빠르게 찾는 알고리즘으로, 검색 범위를 반으로 줄여가며 탐색합니다. 이 문제에서는 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하는 것이 목표이므로, 가능한 최소 시간과 최대 시간 사이에서 이진 탐색을 수행하여, 모든 사람이 심사를 받는데 필요한 최소 시간을 찾습니다.
따라서, 이진 탐색 알고리즘을 사용하여 최소 시간을 찾습니다.

1. **변수 초기화**
    - **`answer`** 변수를 0으로 초기화하여 최종 답을 저장합니다.
2. **탐색 범위 설정**
    - **`times`** 배열을 정렬하여 **`left`**에는 가장 작은 심사 시간
    - **`right`**에는 가장 긴 심사 시간에 **`n`**을 곱한 값을 설정합니다.
    - 이는 모든 사람이 가장 느린 심사대만 이용할 때 걸리는 시간입니다.
3. **이진 탐색 실행**
    - **`left`**가 **`right`**보다 작거나 같을 때까지 반복합니다.
    - **`mid`**는 **`left`**와 **`right`**의 중간값으로, 이 시간 동안 심사받을 수 있는 사람 수를 계산합니다.
4. **심사 인원 계산**
    - **`for`** 루프를 사용하여 **`times`** 배열의 각 요소(심사 시간)로 **`mid`**를 나누어, 해당 시간 동안 심사받을 수 있는 사람 수를 누적합니다.
5. **탐색 범위 조정**
    - 심사받을 수 있는 사람 수가 **`n`**보다 적으면 **`left`**를 증가시켜 탐색 범위를 조정
    - **`n`**보다 많거나 같으면 **`answer`**를 **`mid`**로 갱신하고 **`right`**를 감소시켜 탐색 범위를 좁힙니다.
6. **결과 반환**
    - 최종적으로 계산된 **`answer`**를 반환합니다.
    - 이 값은 모든 사람이 심사를 받는 데 걸리는 최소 시간입니다.
 */