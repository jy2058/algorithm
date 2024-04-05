package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21921
 * 21921 / 블로그
 * 실버3
 *
 * 찬솔이는 X일 동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
 * 찬솔이를 대신해서 X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구해주자.
 */
public class 슬라이딩윈도우_누적합_21921 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 블로그 시작 일
        int M = Integer.parseInt(st.nextToken());   // 계산할 기간

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        // 방문자 수를 배열에 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0; // 최대 방문자 수
        int currSum = 0;    // 현재 기간의 방문자 수 합계

        // 처음 시작일부터 특정 기간의 방문자수를 미리 구한다
        for (int j = 0; j < M; j++) {
            currSum += arr[j];
        }

        maxSum = currSum;   // 최대 방문자 수에 현재 구한 방문자 수를 저장

        int samePrior = 1;  // 최대 방문자 수와 같은 기간의 수
        // 특정 기간 부터 시작하여 k를 1씩 증가하면서 계산
        for (int k = M; k < arr.length; k++) {
            // 구간의 합을 구하려면 이전 M 만큼의 구간은 빼고 새로 추가되는 구간을 더한다.
            currSum = currSum - arr[k - M] + arr[k];
            // 현재 구간 합이 더 크면 max에 현재 값을 저장하고 같은 기간의 수를 1로 초기화
            if (currSum > maxSum) {
                maxSum = currSum;
                samePrior = 1;
            // 현재 값과 최대값이 같을 때는 같은 기간의 수를 +1 해준다.
            } else if (currSum == maxSum) {
                samePrior++;
            }
        }

        StringBuilder sb = new StringBuilder();
        // 0이 아닐 때 최대값과 같은 기간의 수를 출력
        if (maxSum != 0) {
            sb.append(maxSum).append("\n");
            sb.append(samePrior);
        } else {
            sb.append("SAD");
        }
        System.out.println(sb);
    }
}
