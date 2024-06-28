package 그리디;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/optimal-partition-of-string/description/
 * 2405 / Optimal Partition of String
 *
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
 * Return the minimum number of substrings in such a partition.
 * Note that each character should belong to exactly one substring in a partition.
 *
 * Example 1:
 * Input: s = "abacaba"
 * Output: 4
 * Explanation:
 * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
 * It can be shown that 4 is the minimum number of substrings needed.
 *
 *  Example 2:
 * Input: s = "ssssss"
 * Output: 6
 * Explanation:
 * The only valid partition is ("s","s","s","s","s","s").
 *
 */
public class 그리디_부분문자열로분할_2405 {
    public static void main(String[] args) {
        String s = "eccbbbbdec";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        // 부분 문자열 개수를 1로 초기화. 적어도 1개의 문자렬을 가지기 때문
        int cnt = 1;
        for (char c : s.toCharArray()) {
            // 현재 문자가 해시셋에 이미 존재하면
            // 부분 문자열 개수를 증가시키고 해시셋을 비운다.
            if (set.contains(c)) {
                cnt++;
                set.clear();
            }
            // 현재 문자를 해시셋에 추가
            set.add(c);
        }
        return cnt;
    }

}

/*
이 문제의 목표는 주어진 문자열을 가능한 적은 수의 부분 문자열로 분할하는 것입니다.
각 부분 문자열은 고유한 문자로만 구성되어야 합니다.

예를 들어, 문자열 `"abac"`을 고려해보면 다음과 같이 분할할 수 있습니다:
- 첫 번째 부분 문자열: `"ab"`
- 두 번째 부분 문자열: `"ac"`

1. 해시셋(HashSet)을 사용하여 현재 부분 문자열에 포함된 문자를 추적합니다.
2. 문자열을 순차적으로 탐색하면서 현재 문자가 해시셋에 존재하는지 확인합니다.
    - 존재하지 않으면 현재 부분 문자열에 문자를 추가하고, 해시셋에 문자를 추가합니다.
    - 존재하면 현재 부분 문자열을 종료하고, 새로운 부분 문자열을 시작합니다.
3. 탐색이 끝날 때까지 위 과정을 반복합니다.
 */


