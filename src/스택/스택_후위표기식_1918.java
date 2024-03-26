package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_후위표기식_1918 {
    public static void main(String[] args) throws IOException {
        /*
            중위 표현식을 후위 표현식으로 바꿔서 계산하는 문제
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            // 문자형식일 때는 그냥 출력
            if(target >= 'A' && target <= 'Z'){
                sb.append(target);
            // '(' 나오면 stack에 추가
            } else if (target == '(') {
                stack.push(target);
            // ')' 나오면 stack에서 '(' 나올때까지 pop 하여 출력
            } else if (target == ')') {
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop == '(') {
                        break;
                    }
                    sb.append(pop);
                }
            // 연산자가 나올 때는 우선순위를 판단하여 우선순위 높은 것은 출력, 낮은 건 stack에 추가
            }else{
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(target)){
                    sb.append(stack.pop());
                }
                stack.push(target);
            }
        }

        // 남은 것 모두 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    /**
     * 연산자의 우선순위를 구하는 메서드
     * @param ch 우선순위를 판단할 문자
     * @return 연산자의 우선순위별 숫자(우선순위가 높을 시 수가 큼)
     */
    public static int priority(char ch) {
        if(ch == '(') {
            return 0;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}

/*
    연산자는 스택에, 피연산자는 바로 출력
     연산자의 우선 순위를 지정해서 스택에 넣기전에, 현재 연산자의 우선순위보다 큰 연산자가
     스택의 맨 위에 있다면 없을때까지 pop 한다. (우선순위가 큰 연산자 먼저 계산)
     ')' 일경우에는 '('가 나올때까지 스택안의 연산자를 pop 한다.
     피연산자는 따로 스택에 넣지 않고 StringBuilder에 append
 */
