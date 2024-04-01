package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10773
 * 10773 / 제로
 * 실버4
 *
 * 0이 들어왔을 때 기존 입력한 값을 빼는 문제
 */
public class 스택_합_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 0이면 스택에서 제거
            if(num == 0){
                st.pop();
            // 그 외 스택에 푸시
            }else{
                st.push(num);
            }
        }
        int result = 0;
        while (!st.isEmpty()) {
            result += st.pop(); // 스택의 합
        }

        System.out.println(result);
    }
}
/*
    기본적인 스택문제이다.

    1. 0이 입력되면 기존 스택에서 제거
    2. 그 외는 스택에 푸시
    3. 스택의 합을 구해 출력

 */
