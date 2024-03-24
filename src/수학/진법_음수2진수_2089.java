package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진법_음수2진수_2089 {
    /*
        10진수를 -2진수로 출력하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if (N == 0) {
            sb.append(0);
        }else{
            while (N != 1) {
                sb.append(Math.abs(N % -2));
                N = (int) Math.ceil((double) N / -2);
            }
            sb.append(N);
        }
        System.out.println(sb.reverse());
    }
}
/*
-13을 예시로 하면,
-13 = (-2*7)+1
7 = (-2*-3)+1
-3 = (-2*2)+1
2 = (-2*-1)+0
-1 = (-2*1)+1
1

와 같이 나타낼 수 있다. (110111)
잘 보면 -2로 나누었을 때 몫을 올림한 값이, 다음에 나누어지는 수가 되는 걸 알 수 있다.

ex:
-13/-2 = 6.5 -> 7
7/-2 = -3.5 -> -3

결국 나머지를 양수로 만들기 위해, 몫을 올림처리 하여 다음 나누는 수로 만들면 깔끔하게 해결된다는 의미이다. 또한 애초에 N이 int형 이기 때문에, 나머지에 절대값을 씌워주면 나머지가 양수가 된다.
 */

