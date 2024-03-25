package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_쇠막대기_10799 {
    /*
        레이저가 등장 시 쇠 막대기가 잘리는데 그 막대기의 갯수를 구하는 문제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            if (input.charAt(i) == ')') {
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    result += stack.size();
                }else{
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
/*
    해당 문제는 스택 또는 그냥 문자열 방식으로 풀 수 있다.
    괄호가(레이저) 등장하면 지금까지 누적되어 있던 쇠막대기 '(' 가 잘리게 된다.
        -> stack.size() 만큼 결과값을 더하기

    1. '(' 가 등장 시
        - stack.push()
    2. ')' 가 등장 시결과 값 더하기
        - 쇠막대기가 끝나는 경우 => 결과값에 +1
        - 레이저가 나올경우 => stack.size() 만큼
 */
