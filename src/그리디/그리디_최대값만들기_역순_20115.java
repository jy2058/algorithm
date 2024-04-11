package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20115
 * 20115 / 에너지 드링크
 * 실버3
 *
 *  에너지 드링크들을 합치는 과정은 다음과 같다.
 *
 * 1. 임의의 서로 다른 두 에너지 드링크를 고른다.
 * 2. 한쪽 에너지 드링크를 다른 쪽 에너지 드링크에 모두 붓는다. 단, 페인은 야근 후유증으로 인해 손이 떨려, 붓는 과정에서 원래 양의 절반을 바닥에 흘리게 된다.
 * 3. 다 붓고 남은 빈 에너지 드링크는 버린다.
 * 4. 1~3 과정을 에너지 드링크가 하나만 남을 때까지 반복한다.
 * 예를 들어, 두 에너지 드링크 a, b가 있고, 양이 각각 xa, xb라 할 때, 다음 둘 중 하나의 선택을 할 수 있다.
 *
 * a의 양을 xa + (xb / 2)로 만들고, b를 버리기
 * b의 양을 xb + (xa / 2)로 만들고, a를 버리기
 * 페인은 합쳐진 에너지 드링크의 양을 최대로 하려 한다
 */
public class 그리디_최대값만들기_역순_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Double[] arr = new Double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.valueOf(st.nextToken());
        }

        // 역순 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // 첫번째 최대 값 추가
            if (i == 0) {
                sum = arr[i];
                continue;
            }
            // 2로 나눈 값 추가
            sum += arr[i] / 2;
        }

        System.out.println(sum);
    }
}
/*
    해당 문제는 정렬을 해서 그리디로 푸는 문제였다.

    계산 후 각 값들의 합이 최댓값이 되려면 나누는 수가 최대한 작게 나누어져야 한다.

    따라서 내림차순으로 값을 정렬하고 순차적으로 값을 나누어줘야한다.

    예를 들면, `3 2 10 9 6` 가 입력 값일 때 순차적으로 계산을 해보면 3 + 1.5 + 5 + 3 + 3 = 15.5

    내림차순으로 정렬해서 `10 9 6 3 2`를 계산해보면 10 + 4.5 + 3 + 1.5 + 1 = 20이 된다.

    1. 역순으로 정렬
    2. 최대값을 sum에 저장
    3. 나머지 값들을 2를 나눈 값을 sum에 추가
 */