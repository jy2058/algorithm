package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1931
 * 1931 / 회의실 배정
 * 실버1
 *
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 */
public class 그리디_회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 회의 시작시간
            arr[i][0] = Integer.parseInt(st.nextToken());
            // 회의 끝나는 시간
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의가 끝나는 시간으로 오름차순 정렬
        // 끝나는 시간이 같을 경우 회의 시작시간으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prevEndTime = 0;    // 이전 회의 종료시간
        for(int i = 0; i < arr.length; i++){
            // 이전 회의 종료시간 보다 회의 시작 시간이 같거나 클때 카운트
            if (prevEndTime <= arr[i][0]) {
                prevEndTime = arr[i][1];    // 이전 회의 종료시간을 현재 값의 회의 종료시간으로 변경
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

/*
    해당 문제는 **활동 선택 문제(Activity Selection problem)'**라고 한다.
    간단하게 설명하자면, 한 사람이 하나의 활동에 대해서만 작업할 수 있을 때 최대한 많은 활동을 할 수 있는 수를 선택하는 문제다. 
    이 문제에서는 각 회의가 겹치지 않게 최대한 많은 회의를 배정하는 것으로 나와있다.
    이러한 문제들의 특징은 '한 사람이 하나의 활동에 대해서만 작업할 수 있다'라는 점이다.
    즉, 하나의 활동을 완료하기 전까지는 다른 활동을 선택할 수 없다는 것이다.
    즉, 하나의 활동을 선택하면 나머지 겹치지 않는 활동에 대해서 독립적이고, '탐욕 선택이 이후의 결과에 영향을 미치지 않는다.’
    따라서 그리디 알고리즘을 사용하여 해결한다.
    **서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다는 것이다.**
    **종료시간을 기준으로 정렬**을 하고, 이전 종료시간에 대해 겹치는 것들은 제외하고 남은 것들 중 선택하면 된다.

    1. 회의시작시간, 회의 종료시간을 배열에 담는다.
    2. 회의가 끝나는 시간으로 오름차순 정렬한다.
        - 시간이 같을 때는 회의 시작시간으로 오름차순 정렬
    3. 이전 회의 종료시간과 현재 회의 시작시간을 비교한다.
        1. 이전 회의 종료 시간보다 현재의 회의 시작 시간이 같거나 클 때 카운트를 증가해준다.
        2. 이전 회의 종료시간을 현재의 회의 종료시간으로 변경해준다.

 */