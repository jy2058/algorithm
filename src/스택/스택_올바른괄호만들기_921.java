package 스택;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 * 921 / Minimum Add to Make Parentheses Valid
 *
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 */
public class 스택_올바른괄호만들기_921 {
    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                // 닫는 괄호가 더 많은 불완전한 상태
                if (stack.empty()) {
                    answer++;
                } else {
                    // 여는 괄호가 존재하여 완전한 괄호 상태
                    stack.pop();
                }
            }
        }
        // 스택에 괄호가 남아있다면 완전하지 않은 경우이므로 size만큼 추가
        answer += stack.size();
        return answer;
    }
}

/*
이 문제는 여는 괄호와 닫는 괄호를 입력으로 받아서 올바른 괄호를 만들기 위해 몇 개의 괄호를 추가해야 하는지 계산하는 문제 입니다.
괄호 문제의 경우 스택을 이용해서 여는 괄호가 나왔을 때, 닫는 괄호가 나왔을 때로 나누어서 풀이를 해줍니다.

1. 입력받은 문자열을 순회합니다.
2. 여는 괄호가 나왔을 때 스택에 넣어줍니다.
3. 닫는 괄호가 나왔을 때
    - 스택이 비어있을 경우
        - 완전한 괄호 형태가 아니기 때문에 여는 괄호가 필요하다는 의미로 카운트를 +1 해줍니다.
    - 그 외의 경우
        - 완전한 괄호 형태이기 때문에 스택에서 꺼내줍니다.
4. 스택에 여는 괄호가 남아있으면 닫는 괄호가 부족하단 의미이므로 스택의 사이즈만큼 카운트를 더해줍니다.
 */


