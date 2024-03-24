package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_그룹단어_1316 {
    /*
        그룹 단어인지 확인하는 프로그램
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (check()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    /**
     * 그룹단어인지 확인하는 메서드
     * @return 그룹단어일때 true, 그외 false
     * @throws IOException
     */
    public static boolean check() throws IOException {
        // 알파벳 문자 체크할 배열 생성
        boolean[] check = new boolean[26];
        int prev = 0;   // 이전문자 변수
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);    // 현재문자

            // 현재문자와 이전 문자가 같으면 중복된 문자인지 검사 X
            // 현재문자와 이전문자가 다르면 중복 체크
            if (prev != now) {
                // 현재 문자가 배열에 없다면 배열에 추가하고 현재문자를 이전문자로 저장
                // 현재문자가 배열에 있다면 중복된 문자이기 때문에 false 리턴
                if (!check[now - 'a']) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

