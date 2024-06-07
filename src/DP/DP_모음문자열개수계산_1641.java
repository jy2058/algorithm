package DP;

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/description/
 * 1641 / Count Sorted Vowel Strings
 *
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 *
 * Example 1:
 * Input: n = 1
 * Output: 5
 * Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 *
 * Example 2:
 * Input: n = 2
 * Output: 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 *
 * Example 3:
 * Input: n = 33
 * Output: 66045
 */
public class DP_모음문자열개수계산_1641 {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(countVowelStrings(n));
    }

    public static int countVowelStrings(int n) {
        // 규칙으로 푸는 방법
/*        int a = 1, e = 1, i = 1, o = 1, u = 1;

        while (--n > 0) {
            o += u;
            i += o;
            e += i;
            a += e;
        }

        return a + e + i + o + u;*/

        // DP로 푸는 방법
        int[] dp = new int[]{1, 1, 1, 1, 1};
        int ans = 0;

        while (--n > 0) {
            for (int i = 3; i >= 0; i--) {
                dp[i] += dp[i + 1];
            }
        }

        for (int x : dp) {
            ans += x;
        }

        return ans;
    }


}

/*
### 1. 규칙으로 접근

형성되는 순서를 주의 깊게 관찰하면 다음과 같은 패턴을 발견할 수 있습니다.
n = 1의 경우: a , e , i, o, u
a = 1, e = 1, i = 1, o = 1, u = 1로 시작하는 문자열: 합계 = 5
n = 2인 경우: aa, ae, ai, ao, au, ee, ei, eo, eu, ii, io, iu, oo, ou, uu
a = 5, e = 4, i = 3, o로 시작하는 문자열 = 2, u = 1 : 총 = 15

n = 3인 경우: aaa, aae, aai, aao, aau, aee, aei, aeo, aeu, aii, aio, aiu, aoo, aou, auu, eee, eei, eeo,eeu,eii, eio, eiu, eoo , eou, euu, iii, iio, iiu, ioo, iou, iuu, ooo, oou, ouu, uuu : 합계 = 35

주의 깊게 관찰하면:
n = 2인 경우: 형성된 모든 시퀀스의 개수는 a, e, i, o, u로 시작하는 이전 시퀀스의 합(즉, n = 1)과 같습니다.
a = a + e + i + o + u( 1 + 1 + 1 + 1+ 1) = 5
e = e + i + o +u (1 + 1+ 1+ 1) = 4
i = i + o + u (1 + 1 + 1) = 3
o = o + u (1 + 1) = 2
u = u (1) = 1
합계 = a + e + i + o + u = 5 + 4 + 3 + 2 + 1 = 15

n = 3의 경우: 형성된 모든 시퀀스 개수는 a, e, i, o, u로 시작하는 이전 시퀀스의 합(즉, n = 2)과 같습니다.
a = a + e + i + o + u (5 + 4 + 3 + 2+ 1) = 15
e = e + i + o +u (4 + 3+ 2+ 1) = 10
i = i + o + u (3 + 2 + 1) = 6
o = o + u ( 2 + 1) = 3
u = u (1) = 1
합계 = a + e + i + o + u = 15 + 10 + 6 + 3 + 1 = 35

1. 5개의 변수를 사용합니다 ***.***
2. 각 모음으로 끝나는 문자열의 개수를 나타내는 변수 a, e, i, o, u를 1로 초기화합니다.
3. 루프를 사용하여 n-1에서 0까지 반복하고 다음과 같이 각 모음의 개수를 업데이트합니다.
    - 'o'(o += u)로 끝나는 문자열의 개수를 늘립니다.
    - 'i'(i += o)로 끝나는 문자열의 개수를 늘립니다.
    - 'e'(e += i)로 끝나는 문자열의 개수를 늘립니다.
    - 'a'(a += e)로 끝나는 문자열의 개수를 늘립니다.
4. 루프 후 모든 모음 개수의 합(a+e+i+o+u)은 모음으로만 구성되고 사전순으로 정렬된 길이 n의 문자열의 총 개수를 나타냅니다.

- 시간 복잡도: 이 솔루션의 시간 복잡도는 O(n)입니다. 여기서 알고리즘은 루프를 n 번 반복하고 각 반복에는 일정한 시간 작업이 포함됩니다.
- 공간 복잡도: 입력 크기에 관계없이 변수에 일정한 양의 공간을 사용하므로 공간 복잡도는 O(1)입니다.

### 2.  동적 프로그래밍(DP) 사용

1. ***동적 프로그래밍(dp)을*** 사용합니다 .
2. 모든 요소가 1로 설정된 크기 5(모음을 나타냄)의 벡터 dp를 초기화합니다. 이 벡터는 각 모음으로 끝나는 문자열의 개수를 저장합니다.
3. n-1번 반복합니다(n=1에 대한 개수가 이미 있으므로).
4. 각 반복에서 각 모음으로 끝나는 문자열의 개수를 오른쪽에서 왼쪽으로 합산하여 dp 벡터의 개수를 업데이트합니다. 이 단계는 문자를 하나 더 추가하여 문자열을 확장하는 것과 같습니다.
5. 반복 후 dp 벡터의 개수 합계는 모음을 사용하여 구성할 수 있는 길이 n의 문자열의 총 개수를 나타냅니다.
6. 합계를 결과로 반환합니다.

- 시간 복잡도: 이 솔루션의 시간 복잡도는 O(3n)입니다. 알고리즘은 n-1회 반복되며 각 반복에는 일정한 시간에 벡터를 업데이트하는 작업이 포함됩니다.
- 공간 복잡도: 입력 크기에 관계없이 변수에 일정한 양의 공간을 사용하므로 공간 복잡도는 O(1)입니다.
 */