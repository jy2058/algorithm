package 배열;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * 347 / Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class 배열_빈도수역순정렬_347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int n : nums) {
            numMap.put(n, numMap.getOrDefault(n, 0) + 1);
        }

        // 빈도수에 따라 숫자를 정렬하기 위해 우선순위 큐를 생성
        PriorityQueue<Map.Entry<Integer, Integer>> numQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        numQueue.addAll(numMap.entrySet());

        int[] answer = new int[k];
        // 상위 k개의 빈도수를 가진 요소 추출
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = numQueue.poll();
            answer[i] = entry.getKey();
        }

        return answer;
    }

}


/*
이 문제는 배열에서 **`k`**개의 가장 빈번한 요소를 찾는 것이 문제의 요구사항입니다.
결과는 특정 순서로 정렬될 필요가 없습니다.

1. 각 요소의 발생 횟수를 계산하기 위해 **HashMap**을 사용합니다.
2. 빈도수에 따라 요소를 정렬하기 위해 **PriorityQueue** (최대 힙)을 사용합니다.

- **시간 복잡도:** 힙 연산으로 인해 O(N log N)입니다.
- **공간 복잡도:** 빈도 맵과 힙을 저장하기 위해 O(N)입니다.
 */

