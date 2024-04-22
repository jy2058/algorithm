package 배열;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * 131128 / 숫자 짝꿍
 * 프로그래머스
 *
 * 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
 *
 * 예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
 * 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
 */
public class 배열_숫자짝꿍_131128 {
    public static void main(String[] args) throws IOException {
        String X = "12321";
        String Y = "42531";
        System.out.println(solution(X, Y));
    }
    public static String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for (int i = 0; i < X.length(); i++) {
            xArr[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            yArr[Y.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        // 제일 큰 수인 9부터 시작하여 0까지
        for (int i = 9; i >= 0; i--) {
            // 나오지 않은 수는 제외
            if(xArr[i] == 0 || yArr[i] == 0) continue;
            // 각 배열의 숫자를 비교하여 갯수가 적은 것이 짝궁의 갯수가 된다.
            int cnt = xArr[i] > yArr[i] ? yArr[i] : xArr[i];
            // 수의 갯수만큼 문자 추가
            while (cnt > 0) {
                sb.append(i);
                cnt--;
            }
        }
        // 짝꿍이 없을 시 '-1' 출력
        if(sb.length() == 0) return "-1";
        // '0'으로 시작할 때는 0 한개만 출력
        if(sb.charAt(0) == '0') return "0";

        return  sb.toString();
    }

}


/*
    해당 문제는 2개의 문자열(숫자) 중 같은 숫자의 개수를 이용하여 푸는 문제였다. 그래서 각 문자열의 숫자 배열을 이용하여 해당 숫자가 몇 번씩 나오는지 체크하였다.

    1. 0 ~ 9 까지의 숫자 배열 두 개를 생성하여 해당 숫자가 있을 때 + 1 해준다.
    2. 큰 수가 앞에 먼저 나와야하기 때문에 9 → 0 순으로 for문을 돌린다.
        - 둘 중 한 개가 0이 나왔을 때는 continue
    3. 두 개의 배열의 숫자를 비교하여 개수가 적은 것이 짝꿍의 개수가 되기 때문에 적은 수를 cnt에 저장한다
        - 같은 수가 여러 개일 수 있다.
    4. cnt가 0이 될 때까지 출력 문자열에 추가한다.
    5. 짝꿍이 없을 땐 ‘-1’ 출력, ‘0’만 있을 때는 ‘0’ 출력
 */