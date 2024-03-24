package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_0의개수_2004 {
    /*
        조합을 이용해서 0의 개수를 확인하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int twoCnt = get(N, 2) - get(M, 2) - get(N - M, 2);
        int fiveCnt = get(N, 5) - get(M, 5) - get(N - M, 5);

        System.out.println(Math.min(twoCnt, fiveCnt));
    }

    private static int get(int n, int k) {
        int cnt = 0;

        while(n >= k) {
            cnt += n / k;
            n /= k;
        }

        return cnt;
    }
}

/*
    아직 이핵가 되지 않았음.
    조합이라는 수학공식 이해가 잘 안됨.
 */