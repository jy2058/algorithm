package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_수열_1874 {
    /*
        1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int temp = 1;   // 스택에 추가할 임시 값 변수
        boolean error = false; // 수열이 가능한지 판단 변수

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            // 입력받은 값까지 스택에 넣어준다.
            while(temp <= target){
                stack.push(temp);
                sb.append("+").append("\n");
                temp++;
            }

            // 스택의 값과 입력 받은 값이 같으면 스택에서 pop
            if (target == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
            } else {    // 그 외 수열이 아니라면 error
                error = true;
            }
        }
        System.out.println(error == true ? "NO" : sb);
    }
}
/*
    스택을 이용해서 오름차순으로 저장하고, 임의의 수가 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 확인하는 문제였다.

    만약 입력값이 8이라면 1,2,3,4,5,6,7,8 이런식으로 PUSH가 되어야한다.

    1. 원하는 숫자가 나올 때까지 PUSH 하기
    2. 해당 숫자까지 나왔다면 그 숫자를 pop 해주기
    3. 수열이 되지 않는다면 error 된다면 sb 출력
 */