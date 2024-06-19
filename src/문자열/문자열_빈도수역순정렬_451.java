package 문자열;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * 451 / Sort Characters By Frequency
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 * Return the sorted string. If there are multiple answers, return any of them.

 * Example 1:
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

 * Example 2:
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 */
public class 문자열_빈도수역순정렬_451 {
    public static void main(String[] args) {
        String target = "Aabb";
        System.out.println(frequencySort(target));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        // 문자열의 빈도수를 map에 추가
        for (char c : s.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        // map을 리스트로 변경
        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(frequencies.entrySet());
        // 문자의 빈도수별로 역순 정렬
        entryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        StringBuilder sb = new StringBuilder();
        // 문자의 빈도수만큼 출력
        for (Map.Entry entry : entryList) {
            Integer value = (Integer) entry.getValue();

            while (value > 0) {
                sb.append(entry.getKey());
                value--;
            }
        }
        return sb.toString();
    }

}

/*
이 문제는 문자열에서 각 문자의 빈도수에 따라 문자를 정렬하는 것입니다.
가장 많이 등장하는 문자부터 적게 등장하는 문자 순으로 정렬해야 합니다.

1. Map을 사용하여 문자열의 각 문자의 빈도수를 계산합니다.
2. 우선순위 큐를 사용하여 빈도수에 따라 문자를 내림차순으로 정렬합니다.
3. 큐에서 문자를 하나씩 꺼내면서 해당 문자를 빈도수만큼 추가합니다.

### 배운점
map을 List로 변경해서 역순 정렬을 하는 방식을 사용했었는데 이 방식보다는
우선순위 큐를 사용하여 내림차순으로 정렬하는 방식이 더 효율적이다.
```java
// 빈도수에 따라 내림차순으로 정렬하기 위한 우선순위 큐(최대 힙)
PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
maxHeap.addAll(frequencyMap.entrySet());

```
 */


