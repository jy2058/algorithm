package 배열;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reordered-power-of-2/description/
 * 869 / Reordered Power of 2
 */
public class 정렬_숫자재배열_거듭제곱_869 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(reorderedPowerOf2(n));
    }

    public static boolean reorderedPowerOf2(int n) {
        // n을 문자열로 변환 후 각 자리수를 배열로 만들기
        char[] charArray = String.valueOf(n).toCharArray();
        Arrays.sort(charArray);

        // 2의 거듭제곱 중 int 자료형 범위 내 가장 큰 값이 30이다.
        for (int i = 0; i < 30; i++) {
            // 2의 거듭제곱을 문자열로 변환 후 각 자리수를 배열로 만들기
            char[] powCharArray = String.valueOf(1 << i).toCharArray();
            Arrays.sort(powCharArray);

            // 정렬 된 두 배열이 같은지 비교
            if (Arrays.equals(charArray, powCharArray)) {
                return true;
            }
        }
        return false;
    }

}



/*
이 문제는 주어진 정수 **`N`**을 재배열하여 2의 거듭제곱을 형성할 수 있는지 여부를 판단하는 것입니다.
이 문제를 해결하기 위한 방법은 
1. **`N`**을 문자열로 변환하고, 모든 순열을 생성하여 각각이 2의 거듭제곱인지 확인하는 것입니다.
    하지만 이 방법은 비효율적일 수 있습니다.
2. 더 효율적인 방법은 **`N`**을 문자 배열로 변환하고 정렬한 다음, 2의 거듭제곱을 나타내는 숫자들과 비교하는 것입니다. 이렇게 하면 모든 순열을 생성하지 않고도 가능한 해를 찾을 수 있습니다.

시간 복잡도는 O(1)
공간 복잡도는 O(logN)
 */
