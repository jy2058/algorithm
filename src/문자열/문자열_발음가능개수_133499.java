package 문자열;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 * 133499 / 옹알이 (2)
 * 프로그래머스
 *
 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다. 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */
public class 문자열_발음가능개수_133499 {
    public static void main(String[] args) throws IOException {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            // 연속해서 발음 제외
            s = s.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            s = s.replaceAll("aya|ye|woo|ma", "");
            // 문자 전체가 발음 가능하면 공백만 존재
            if (s.equals("")) answer++;
        }
        return answer;
    }
}
