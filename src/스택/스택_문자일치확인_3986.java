package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_문자일치확인_3986 {
    /*
        같은 글자와 짝지을 수 있는지 확인하는 문제
     */
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            check(s);
        }
        System.out.println(cnt);
    }

    /**
     * 좋은 문자(같은 글자끼리 있는지)인지 확인하는 메서드
     * @param s 확인할 문자
     */
    public static void check(String s) {
        if (s.length() % 2 != 0) return;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }

        }
        if(stack.isEmpty()) cnt++;
    }
}
/*

    A와 B로만 주어진 단어가 있고 같은 글자끼리(A는 A끼리, B는 B끼리) 쌍을 지어 아치형 곡선을 만든다.
    만약 선끼리 교차하지 않으면서 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을 수 있다면,
    그 단어는 '좋은 단어'가 되고 좋은 단어의 개수만 파악하면 되는 문제이다.

    스택을 이용해서 풀면된다.

    1. 단어의 첫글자를 스택에 push하고 시작한다.
    2. 인덱스 1부터 끝까지 스택에서 peek 한것과 비교
        - stack.peek() == 비교하는 글자와 같다면 스택에서 pop()
        - stack이 비었거나 비교하는 글자와 다르다면 스택에 push()
    3. 비교 후 스택이 비어있으면 좋은 단어, 비어있지 않으면 좋은단어가 아니다.
 */