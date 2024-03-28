package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_이중스택_커서_1406 {
    /*
        초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        // 커서에 따라 이동할 스택 2개
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 왼쪽 스택에 문자 저장
        for (char s : str.toCharArray()) {
            leftStack.push(s);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            // 왼쪽으로 커서 이동
            // 왼쪽 스택에서 오른쪽 스택으로 이동
            if (op.equals("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            // 오른쪽으로 커서 이동
            // 오른쪽 스택에서 왼쪽 스택으로 이동
            } else if (op.equals("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            // 커서 왼쪽 삭제
            // 왼쪽 스택 삭제
            } else if (op.equals("B")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            // 왼쪽에 문자 추가
            // 왼쪽 스택에 문자 추가
            } else if (op.equals("P")) {
                leftStack.push(st.nextToken().charAt(0));
            }

        }

        // 스택이기 때문에 순차적인 출력을 위해 왼쪽 스택에서 오른쪽 스택이로 이동
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
/*
    스택 2개을 이용하여 커서를 이동할 때 왼쪽, 오른쪽 스택으로 이동 시키는 방식이다.
    시간 초과를 주의해야 하는 문제였다. LinkedList 이용했더니 시간초과남.

    1. 왼쪽 스택에 문자열을 전부 저장
    2. 왼쪽으로 커서 이동
        - 왼쪽 스택에서 오른쪽 스택으로 이동
    3. 오른쪽으로 커서 이동
        - 오른쪽 스택에서 왼쪽 스택으로 이동
    4. 커서 왼쪽 삭제
        - 왼쪽 스택 삭제
    5. 왼쪽에 문자 추가
        - 왼쪽 스택에 문자 추가
    6. 스택이기 때문에 순차적인 출력을 위해 왼쪽 스택에서 오른쪽 스택으로 이동

  */