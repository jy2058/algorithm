package 구현;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * 86491 / 최소직사각형
 *
 * 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
 *
 * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
 *
 * 명함 번호	가로 길이	세로 길이
 * 1	60	50
 * 2	30	70
 * 3	60	30
 * 4	80	40
 * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
 *
 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 */
public class 구현_완전탐색_최소직사각형_86491 {
    public static void main(String[] args) throws IOException {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int xMax = 0;   // 가로길이 최대값
        int yMax = 0;   // 세로길이 최대값

        for (int[] size : sizes) {
            // 가로, 세로 중 작은 값을 min에 저장, 큰 값을 max에 저장
            // 가로와 세로를 바꿀 수 있기 때문에.
            int min = Math.min(size[0], size[1]);
            int max = Math.max(size[0], size[1]);
            // 가로 최대값과 현재 가로 최대값 중 큰 값을 저장
            xMax = Math.max(xMax, min);
            // 세로 최대값과 현재 세로 최대값 중 큰 값을 저장
            yMax = Math.max(yMax, max);
        }

        return xMax * yMax;
    }
}

/*
    모든 명함을 수납할 수 있는 가작 작은 사이즈의 지갑을 만드는 문제이다.
    명함을 회전해서 수납할 수 있기 떄문에 가로와 세로의 길이 중 작은 값을 가로,
    큰 값을 세로에 저장하여 전체 길이의 max 값과 비교한다.
 */