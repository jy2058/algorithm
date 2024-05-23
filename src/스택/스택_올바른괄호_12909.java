package 스택;

import java.io.IOException;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909/
 * 12909 / 올바른 괄호
 *
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
 *
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 */
public class 스택_올바른괄호_12909 {
    public static void main(String[] args) throws IOException {
        String s = "(()(";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            // '(' 일때 스택에 push, ')'일 때 스택 pop을 하면 올바른 괄호일 때 스택이 비게 된다.
            if (ch == '(') {
                stack.push('(');
            } else if (ch == ')') {
                // 스택이 비어있는 상태에서 ')'가 먼저 나오면 잘못된 괄호
                if(stack.empty()) return false;
                stack.pop();
            }
        }

        // 스택이 비어있지 않으면 괄호가 제대로 안 닫긴 것
        if(!stack.empty()) return false;

        return answer;
    }
}

/*
    올바른 괄호를 찾는 문제의 경우 보통 스택을 많이 이용한다.

    - ‘(’ 일 때 스택에 push, ‘)’일 때 스택에서 pop을 하게 되면 올바른 괄호일 때 최종적으로 스택이 비게 된다.
    - 만약 스택이 빈 상태에서 ‘)’가 먼저 나오거나, 최종적으로 스택에 ‘(’가 남아있다면 올바르지 않은 괄호 형태이다.
 */