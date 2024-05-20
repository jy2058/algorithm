package 문자열;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * 42577 / 전화번호 목록
 * 프로그래머스
 *
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */
public class 문자열_접두사_42577 {
    public static void main(String[] args) throws IOException {
//        String[] phone_book = {"123","456","789"};
        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"12","123","1235","567","88"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }
        return answer;
    }
}

/*
    입력 받은 문자열 배열에서 접두사가 중복되는 것이 있는지 확인하는 문제였다.

    문자열의 배열이 숫자로 이루어져 있기 때문에 정렬을 하면 바로 다음 문자열과 접두사를 비교할 수 있다.

    1. 오름차순으로 문자열 정렬
    2. 다음 문자와 접두사가 같은지 확인
    3. 접두사가 일치하는 게 있을 시 false, 없을 시 true 리턴
 */