package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_갯수_1157 {
    /*
       - 알파벳 대소문자로 된 단어가 주어지면, 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char target = str.charAt(i);
            arr[target - 'A']++;    // 알파벳 순회하면서 해당 문자가 있으면 +1
        }

        int max = 0;
        int ch = 0;
        boolean isDuplicated = false;
        for (int j = 0; j < 26; j++) {
            // 가장 큰 값 체크
            if (arr[j] > max) {
                max = arr[j];
                ch = j;
                isDuplicated = false;
            // 가장 큰 값이 여러개면 중복
            }else if(arr[j] == max){
                isDuplicated = true;
            }
        }
        System.out.println(isDuplicated == false ? (char) (ch + 'A') : "?" );
    }
  
}

