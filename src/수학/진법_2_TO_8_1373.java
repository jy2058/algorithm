package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 진법_2_TO_8_1373 {
    /*
        2진수를 8진수로 변환하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        //형변환을 해주면서 옆에 2를 적어주면 10진수로 바꿔준다.
        BigInteger N = new BigInteger(S, 2);

        //BigInteger.toString이 String으로 형변환 해주는 것이고, 옆에 괄호안에 원하는 진수를 적어주면 된다.
        String result = N.toString(8);

        System.out.println(result);
    }
}

/*
    BigInteger를 사용하여야 하며, 형변환도 같이 가능한 것을 배웠음
 */