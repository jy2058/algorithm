package 문자열;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 * 72410 / 신규 아이디 추천
 * 프로그래머스
 *
 * 신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.
 */
public class 문자열_정규식_72410 {
    public static void main(String[] args) throws IOException {

        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }

    public static String solution(String new_id){
        String answer = "";
        // 1. 소문자 치환
        answer = new_id.toLowerCase();
        // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자 제거
        // [^] - [] 내부에서 ^는 부정(NOT)의 의미로 사용
        // [a-z] - 소문자, [0-9] - 숫자
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        // 3. 두 개 이상 연속된 마침표(.)를 하나로 치환
        // .{2,} 두 개 이상인 마침표
        answer = answer.replaceAll("\\.{2,}", ".");
        // 4. 마침표가 처음이나 끝에 위치할 경우 제거
        // ^ - 문자열의 시작, [] 밖에서는 부정(NOT)이 아님
        // $ - 문자열의 끝
        // | - OR 연산
        answer = answer.replaceAll("^[.]|[.]$", "");
        // 5. 빈 문자열일 경우 a 입력
        answer = answer.equals("") ? "a" : answer;
        // 6. 15자를 넘을 때 15자로 제한 후 4단계 다시 적용(마지막이 마침표(.)가 안 나오게)
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        // 7. 2자 이하일 경우, 3자리가 될 때까지 마지막 글자 붙이기
        int moreLen = 3 - answer.length();
        if (moreLen > 0) {
            char last = answer.charAt(answer.length() - 1);
            answer += String.valueOf(last).repeat(moreLen);
        }

        return answer;
    }
}

/*
해당 문제는 여러 단계로 문자열을 변경하는 문제였는데 정규식을 써보기 아주 좋은 문제였다.

    1. 소문자 치환
    2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자 제거
        - [^] - [] 내부에서 ^는 부정(NOT)의 의미로 사용
        - [a-z] - 소문자
        - [0-9] - 숫자
    3. 두 개 이상 연속된 마침표(.)를 하나로 치환
        - .{2,} 두 개 이상인 마침표
    4. 마침표가 처음이나 끝에 위치할 경우 제거
        - ^ - 문자열의 시작, [] 밖에서는 부정(NOT)이 아님
        - $ - 문자열의 끝
        - | - OR 연산
    5. 빈 문자열일 경우 a 입력
    6. 15자를 넘을 때 15자로 제한 후 4단계 다시 적용(마지막이 마침표(.)가 안 나오게)
    7. 2자 이하일 경우, 3자리가 될 때까지 마지막 글자 붙이기

 */