package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_후위표기식_계산_1935 {
    /*
        후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Stack<Double> stack = new Stack<>();

        Double[] arr = new Double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.valueOf(br.readLine());
        }

        for (int j = 0; j < str.length(); j++) {
            char target = str.charAt(j);
            if ('A' <= target && target <= 'Z') {
                stack.push(arr[target - 'A']);
            }else{
                Double d1 = stack.pop();
                Double d2 = stack.pop();
                Double result = 0.0;
                if (target == '+') {
                    result = d2 + d1;
                } else if (target == '-') {
                    result = d2 - d1;
                } else if (target == '*') {
                    result = d2 * d1;
                } else if (target == '/') {
                    result = d2 / d1;
                }
                stack.push(result);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
/*
    스택을 이용하여 후위 표기식의 연산 결과를 출력하는 문제였다.
    1. 소숫점 둘째자리 까지 출력해야하기 때문에 double 형식 사용
    2. 알파벳에 따른 값 찾기
    3. 후위 표기식 계산
        - 스택에 차례대로 값을 추가하면서 연산자가 나오면 추가했던 피연산자 두 개를 뽑아
        현재 연산자에 맞게 계산을 하고, 계산한 값을 다시 스택에 넣어주는 것을 반복한다.
        마지막에 남은 스택의 값이 최종 결과 괎이 된다.
 */