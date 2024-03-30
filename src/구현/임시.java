package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    https://www.acmicpc.net/problem/2840
    2840 / 행운의 바퀴
    실버 4
 */
public class 임시 {
    /*
        바퀴를 회전하면서 각 바퀴의 문자를 알아내는 문제
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 바퀴 칸 수
        int N = Integer.parseInt(st.nextToken());
        // 회전 수
        int M = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');

        // 화살표
        int target = 0;
        boolean[] str = new boolean[26];
        boolean check = true;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int rotation = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);

            // 화살표 위치
            target = (target + rotation) % N;

            /*
                행운의 바퀴가 없으면 종료
                1. 바퀴에 이미 다른 문자가 들어있는 경우
                2. 같은 문자가 이미 존재하는 경우
            */
            if (wheel[target] != '?' && wheel[target] != ch
                    || wheel[target] != ch && str[ch - 'A']
            ) {
                check = false;
                break;
            }
            wheel[target] = ch; // 바퀴에 해당 문자 저장
            str[ch - 'A'] = true;   // 이미 사용된 문자 표시
        }

        StringBuilder sb = new StringBuilder();
        if (check) {
            // 입력 방향과 반대 방향으로 출력
            for (int i = 0; i < N; i++) {
                int a = target - i;
                if(a < 0) a += N;
                sb.append(wheel[a]);
            }
        }else{
            sb.append('!');
        }
        System.out.print(sb);
    }
}
/*
    단순 구현문제로 생각하고 배열을 이용해서 해당 문제를 풀었다.
    행운의 바퀴가 될 수 없는 조건은 2가지
    1. 바퀴에 이미 다른 문자가 들어있는 경우
    2. 같은 문자가 이미 존재하는 경우

    그 외에는 바퀴에 해당 문자를 저장하고, 그 문자를 사용했다고 표시를 해준다.

    출력방향과 입력방향이 반대이기 때문에 출력할 때 주의를 해야한다.

 */