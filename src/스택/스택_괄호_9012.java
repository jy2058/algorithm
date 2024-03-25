package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_괄호_9012 {
    /*
        괄호 문자열이 올바르게 쌍으로 이루어져있는지 확인하는 문제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            System.out.println(check(str));
        }
    }

    /**
     * 괄호가 쌍으로 이루어져있는지 스택으로 확인하는 메서드
     * @param str 확인할 문자열
     * @return 올바른 괄호일경우 'YES' 아닐경우 'NO'
     */
    public static String check(String str) {
        Stack<Character> stack = new Stack<>();

        for (int j = 0; j < str.length(); j++) {
            char target = str.charAt(j);
            // 열린 괄호일경우 stack에 push
            if (target == '(') {
                stack.push(target);
            // 닫는 괄호인데 스택이 비어있을 때는 잘못된 형태
            } else if (stack.empty()) {
                return "NO";
            // 그 외의 닫힌 괄호일때는 스택을 pop
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}

/*
    여는 괄호와 닫는 괄호가 쌍으로 일치하는지 확인할 때는 스택을 사용
 */