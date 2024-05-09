package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1085
 * 1085 / 직사각형에서 탈출
 * 브론즈3
 *
 * 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 */
public class 수학_최소거리_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int xMin = Math.min(x, w - x);
        int yMin = Math.min(y, h - y);

        System.out.println(Math.min(xMin, yMin));
    }
}

/*
    주어지는 변수는 총 4개이다.
    위치를 나타내는 x, y 그리고 직사각형 오른쪽 위 꼭짓점의 위치인 w, h
    그러면 직사각형을 탈출하는 최소 거리는 4가지 방법 중 하나가 된다.
    따라서 위, 아래, 좌, 우 중 최솟값만 찾으면 되는 것이다.

    - 이미지 참고
    !https://blog.kakaocdn.net/dn/cQ81rt/btqDKoXSzVB/cPaewKxgCKrMnSsSY7FbK1/img.png
 */