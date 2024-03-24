package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열_스택_단어뒤집기_17413 {
    /*
        문자열 중 단어(알파벳)만 역순으로 출력하기
        '<'로 시작해서 '>'로 끝나는 건 똑바로 출력
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        // 똑바로 넣을지 뒤집을지 확인 변수
        boolean flag = false;

        for (int i = 0; i < str.length(); i++) {
            char target = str.charAt(i);
            // '<'를 만나면 스택에 담았던 것을 모두 거꾸로 출력
            if (target == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(target);
                flag = true;
            // '>'를 만나면 똑바로 출력하게 flag 변경
            } else if (target == '>') {
                sb.append(target);
                flag = false;
            // 똑바로 출력
            } else if (flag) {
                sb.append(target);
            // 거꾸로 출력
            } else if (!flag) {
                // 공백 만났을 때 해당 문자열이 끝난 것이기 때문에 stack에 있는 것들을 모두 거꾸로 출력
                if (target == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(target);
                // 그 외에 스택에 삽입
                }else{
                    stack.push(target);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
  
}

