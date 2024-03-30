package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2504
 * 2504 / 괄호의 값
 * 골드5
 * 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것
 */
public class 스택_괄호_여러개_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        boolean flag = true;
        int result = 0; // 결과값
        int temp = 1;    // 임시 저장 값
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            // 괄호가 열릴 때 임시변수에 각 값을 곱해준다.
            if (curr == '(') {
                stack.push(curr);
                temp *= 2;
            } else if (curr == '[') {
                stack.push(curr);
                temp *= 3;
            } else {
                if (curr == ')') {
                    // 올바른 괄호가 아닐 경우 break
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }

                    // 바로 이전 문자 값이 '(' 이면 임시값을 더해준다.
                    if (s.charAt(i - 1) == '(') {
                        result += temp;
                    }

                    stack.pop();    // 여는 괄호 제거
                    // 괄호가 닫힐때는 곱했던 값을 다시 복구
                    temp /= 2;
                } else if (curr == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    if (s.charAt(i - 1) == '[') {
                        result += temp;
                    }
                    stack.pop();
                    temp /= 3;

                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}

/*
 괄호를 이용하여 푸는 문제이기 때문에 스택을 이용한다.

  1. '(', '['를 만나면 stack에 해당 괄호를 넣고 temp 값에 각각의 2, 3의 값을 곱해준다.
  2. ')'을 만나면?
    1) 스택이 비어있거나, 스택에 '('이 없으면
      -> 플래그 변경 후 반복문 탈출
    2) 바로 이전의 값이 '('이면
      -> temp 값을 result 에 더해준다.
    3. stack에서 한개 빼기
  3. ']'을 만나면
    -> 2번과 동일!
  4. 만약 스택이 비어있다면 0출력 그렇지 않으면 결과값 출력
 */