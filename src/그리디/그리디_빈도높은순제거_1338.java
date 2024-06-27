package 그리디;

import java.util.*;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/description/
 * 1338 / Reduce Array Size to The Half
 *
 * You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 *
 * Example 1:
 * Input: arr = [3,3,3,3,5,5,5,2,2,7]
 * Output: 2
 * Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
 * Possible sets of size 2 are {3,5},{3,2},{5,2}.
 * Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.

 * Example 2:
 * Input: arr = [7,7,7,7,7,7]
 * Output: 1
 * Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 */
public class 그리디_빈도높은순제거_1338 {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(arr));
    }

    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // 빈도 계산
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // 빈도를 내림차순으로 정렬
        List<Integer> frequencyList = new ArrayList<>(frequencyMap.values());
        frequencyList.sort(Collections.reverseOrder());

        int removeCnt = 0;  // 제거된 요소의 합
        int setSize = 0;    // 제거된 요소의 수
        int halfSize = arr.length / 2;
        // 배열의 크기를 절반 이하로 줄이기 위해 빈도가 높은 요소부터 제거
        for (int frequency : frequencyList) {
            removeCnt += frequency;
            setSize++;
            if (removeCnt >= halfSize) {
                break;
            }
        }
        return setSize;
    }
}

/*
이 문제는 주어진 배열의 크기를 절반 이하로 줄이기 위해 최소한의 고유 요소를 제거해야 합니다.
이 문제는 "Greedy Algorithm"을 사용하여 해결됩니다.
Greedy Algorithm은 각 단계에서 현재 상황에서 가장 최적이라고 생각되는 결정을 내리는 방식으로 문제를 해결하는 알고리즘입니다.
이 문제에서 Greedy Algorithm을 사용하는 이유는 빈도가 높은 요소들을 우선적으로 제거하면 배열의 크기를 더 빨리 줄일 수 있기 때문입니다.
배열의 빈도를 사용하여 이를 달성할 수 있습니다.

1. 배열의 각 요소의 빈도를 계산합니다.
2. 빈도가 높은 요소부터 제거하여 배열의 크기를 절반 이하로 줄입니다.
3. 필요한 최소한의 고유 요소 수를 계산합니다.

시간 복잡도는 O(n log n)입니다.
 */



