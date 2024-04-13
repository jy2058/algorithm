package 구현;

import java.io.IOException;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12901
 * 12901 / 2016년
 * 프로그래머스
 *
 * 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
 * 입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
 */
public class 요일계산_12901 {
    public static void main(String[] args) throws IOException {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }

    public static String solution(int a, int b) {
        // 월별 일수 1 ~ 12
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 요일 배열(금요일이 1일이어서 금요일부터 시작)
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int sum = 0;
        // 입력월까지의 모든 일자 더하기
        for (int i = 0; i < a - 1; i++) {
            sum += days[i];
        }
        // 1월1일 당일은 제외해야 하므로 총 지난 일 수에서 1을 빼기
        sum += (b - 1);
        // 총 지난 일을 7로 나눈 나머지가 요일이 됨
        return day[sum % 7];
    }
}

/*
    1. 2016년 1월 1일부터 2016년 a월 b일까지는 a - 1 개월이 지나고, b일이 경과한 것.
    2. a - 1 개월을 일로 변환하고, 총 지난 일을 7로 나눈 나머지를 이용해서 요일을 구할 수 있다.
    3. 1월 1일 당일은 제외해야 하므로 총 지난 일 수 에서 1을 뺀다.
 */