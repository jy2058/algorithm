package 문자열;

/**
 * https://leetcode.com/problems/minimum-suffix-flips/description/
 * Minimum Suffix Flips
 *
 * You are given a 0-indexed binary string target of length n. You have another binary string s of length n that is initially set to all zeros. You want to make s equal to target.
 * In one operation, you can pick an index i where 0 <= i < n and flip all bits in the inclusive range [i, n - 1]. Flip means changing '0' to '1' and '1' to '0'.
 * Return the minimum number of operations needed to make s equal to target.
 *
 * Example 1:
 * Input: target = "10111"
 * Output: 3
 * Explanation: Initially, s = "00000".
 * Choose index i = 2: "00000" -> "00111"
 * Choose index i = 0: "00111" -> "11000"
 * Choose index i = 1: "11000" -> "10111"
 * We need at least 3 flip operations to form target.
 *
 * Example 2:
 * Input: target = "101"
 * Output: 3
 * Explanation: Initially, s = "000".
 * Choose index i = 0: "000" -> "111"
 * Choose index i = 1: "111" -> "100"
 * Choose index i = 2: "100" -> "101"
 * We need at least 3 flip operations to form target.
 *
 * Example 3:
 * Input: target = "00000"
 * Output: 0
 * Explanation: We do not need any operations since the initial s already equals target.
 */
public class 문자열_최소횟수뒤집기_1529 {
    public static void main(String[] args) {
        String target = "10111";
        System.out.println(minFlips(target));
    }

    public static int minFlips(String target) {
        int flips = 0; // 뒤집기 횟수를 저장할 변수
        char lastChar = '0'; // 마지막으로 뒤집힌 상태를 추적하는 변수

        // target의 각 비트를 확인하면서 필요한 뒤집기 연산 수행
        for (int i = 0; i < target.length(); i++) {
            // 현재 비트가 마지막으로 뒤집힌 상태와 다르면 뒤집기
            if (target.charAt(i) != lastChar) {
                flips++; // 뒤집기 횟수 증가
                lastChar = target.charAt(i); // 마지막으로 뒤집힌 상태 업데이트
            }
        }
        return flips;
    }

}

/*
이 문제는 이진 문자열 **`target`**이 주어지고, 모든 비트가 0으로 설정된 같은 길이의 이진 문자열 **`s`**를 **`target`**과 같게 만들어야 하는 문제입니다

1. **`target`**의 각 비트를 순회하면서 현재 비트가 이전에 뒤집힌 상태와 다른지 확인합니다.
2. 만약 다르다면, 해당 인덱스에서 **`n-1`**까지의 비트를 뒤집어야 합니다
3. 이 때, 뒤집기 연산의 횟수를 증가시키고, 마지막으로 뒤집힌 상태를 업데이트합니다.
 */



