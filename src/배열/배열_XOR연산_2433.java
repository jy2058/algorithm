package 배열;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
 * 2433 / Find The Original Array of Prefix Xor
 *
 * You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * Note that ^ denotes the bitwise-xor operation.
 * It can be proven that the answer is unique.
 *
 * Example 1:
 * Input: pref = [5,2,0,3,1]
 * Output: [5,7,2,3,2]
 * Explanation: From the array [5,7,2,3,2] we have the following:
 * - pref[0] = 5.
 * - pref[1] = 5 ^ 7 = 2.
 * - pref[2] = 5 ^ 7 ^ 2 = 0.
 * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
 * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
 *
 * Example 2:
 * Input: pref = [13]
 * Output: [13]
 * Explanation: We have pref[0] = arr[0] = 13.
 */
public class 배열_XOR연산_2433 {
    public static void main(String[] args) {
        int[] pref = {5,2,0,3,1};

        System.out.println(Arrays.toString(findArray(pref)));
    }

    public static int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i - 1] ^ pref[i];
        }
        return arr;
    }

}

/*
이 문제는 주어진 배열 pref에서 원래 배열 arr을 찾는 문제입니다.
**`pref[i]`**는 **`arr[0] ^ arr[1] ^ ... ^ arr[i]`**로 정의됩니다. [즉,](https://leetcode.com/problems/find-the-original-array-of-prefix-xor/) **`pref`**의 각 요소는 [**`arr`**](https://leetcode.com/problems/find-the-original-array-of-prefix-xor/) 배열의 첫 번째 요소부터 해당 인덱스까지의 XOR 연산 결과입니다
 XOR 연산은 자기 자신과의 XOR이 0이 되는 속성이 있습니다. 이를 이용하면, **`pref`** 배열의 이전 요소와 현재 요소를 XOR 연산하여 **`arr`**의 현재 요소를 찾을 수 있습니다.

예를 들어, **`pref = [5,2,0,3,1]`**이 주어졌을 때, **`arr`** 배열을 다음과 같이 찾을 수 있습니다:
1. **`arr[0]`**은 **`pref[0]`**과 같으므로, **`arr[0] = 5`**입니다.
2. **`arr[1]`**을 찾기 위해, **`pref[0] ^ pref[1]`**을 계산합니다: **`5 ^ 2 = 7`**, 따라서 **`arr[1] = 7`**입니다.
3. **`arr[2]`**을 찾기 위해, **`pref[1] ^ pref[2]`**을 계산합니다: **`2 ^ 0 = 2`**, 따라서 **`arr[2] = 2`**입니다.
4. 이런 식으로 계속해서 **`arr[i] = pref[i-1] ^ pref[i]`**를 계산하여 나머지 요소들을 찾습니다.
 */


