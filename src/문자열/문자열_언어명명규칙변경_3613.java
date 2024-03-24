package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_언어명명규칙변경_3613 {
    /*
        변수명을 C++ -> JAVA 형식으로
        JAVA -> C++ 형식으로 변환하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        // '_'로 시작하는 경우
        // '_'로 끝나는 경우
        // 대문자로 시작하는 경우
        if(str.charAt(0) == '_'
                || str.charAt(str.length() -1) == '_'
                || Character.isUpperCase(str.charAt(0))
                || str.contains("__")){
            System.out.println("Error!");
            return;
        }

        boolean isJava = true;
        boolean isCpp = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                isJava = false;
            }else if (Character.isUpperCase(str.charAt(i))) {
                isCpp = false;
            }
        }

        // 대문자와 '_'를 혼용하여 쓴 경우
        if (!isJava && !isCpp) {
            System.out.println("Error!");
            return;
        }

        // C++ to java
        if(isCpp){
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '_'){
                    sb.append(String.valueOf(str.charAt(++i)).toUpperCase());
                }else{
                    sb.append(str.charAt(i));
                }
            }
        // java to C++
        }else{
            for (int i = 0; i < str.length(); i++) {
                if (Character.isUpperCase(str.charAt(i))) {
                    sb.append("_")
                    .append(Character.toLowerCase(str.charAt(i)));

                }else{
                    sb.append(str.charAt(i));
                }
            }
        }
        System.out.println(sb);
    }

}

/*
    반례를 추가하는 것을 신경써야함.
 */