package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1940
 * 1940 / 주몽
 * 실버4
 *
 * 갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다. 갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다. 야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다. 이러한 궁금증을 풀어 주기 위하여
 * N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램
 */

public class 배열_투포인터_배열합_1940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 재료의 개수
        int M = Integer.parseInt(br.readLine());    // 갑옷을 만드는데 필요한 수

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        int cnt = 0;    //  값옷을 만들 수 있는 개수
        int start = 0;  // 시작 포인터 인덱스(배열의 시작 값에서 시작)
        int end = N - 1;    // 끝 포인터 인덱스(배열의 끝에서 시작)

        // 시작 포인터가 끝 포인터 인덱스보다 클때까지 반복
        while (start < end) {
            // 각 배열의 합이 M보다 작을 경우 start 인덱스 증가
            if (arr[start] + arr[end] < M) {
                start++;
            // 각 배열의 합이 M보다 클 경우 end 인덱스 감소
            } else if (arr[start] + arr[end] > M) {
                end--;
            // 각 배열의 합이 M과 같을 때 start 증가, end 감소
            } else {
                cnt++;
                start++;
                end--;
            }
        }
        System.out.println(cnt);
    }

}

/*
    투포인터를 이용하여 두개의 배열의 합이 요청하는 값과 일치하는 개수를 구하는 문제이다.

    완전 탐색으로는 시간 초과가 날 수 있으니 O(N)의 시간 복잡도를 가진 투포인터를 이용한다.

    1. 입력 받을 값을 배열에 저장한다.
    2. 배열을 오름차순으로 정렬한다
    3. 배열의 시작, 배열의 끝에 각각 인덱스를 나타내는 포인터를 생성한다.
    4. 시작 포인터가 끝 포인터 인덱스보다 커질때까지 반복한다.
        - 각 배열의 합이 목표값보다 작을 경우 시작 인덱스 증가
        - 각 배열의 합이 목표값보다 클 경우 끝 인덱스 감소
        - 각 배열의 합이 목표값과 같을 때는 시작 인덱스 증가, 끝 인덱스 감소, 일치하니까 카운트 증가
 */