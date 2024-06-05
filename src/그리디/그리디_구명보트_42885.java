package 그리디;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * 42885 / 구명보트
 *
 * 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
 * 예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
 * 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
 * 사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */
public class 그리디_구명보트_42885 {
    public static void main(String[] args) {

        int[] people = {70, 80, 50};
//        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        // 구명 보트는 최대 2명씩밖에 탈 수 없으니 배열을 정렬하여 가장 적은 몸무게인 사람 + 가장 큰 몸무게인 사람을 비교하여 경우의 수를 계산
        Arrays.sort(people);
        int idx = 0;    // 몸무게가 작은 사람의 위치 변수
        for (int i = people.length - 1; i >= idx; i--) {
            // 몸무게가 가장 많이 나가는 사람의 몸무게와 적게 나가는 사람의 몸무게 합이 limit을 넘지 않으면 둘이 탔으니 다음 몸무게 적은 사람으로 idx 증가
            if (people[i] + people[idx] <= limit) {
                answer++;
                idx++;
            } else {
                // 혼자탐
                answer++;
            }
        }
        return answer;
    }

}

/*
    구명 보트는 최대 2명씩밖에 탈 수 없으니 배열을 정렬하여 가장 적은 몸무게인 사람 + 가장 큰 몸무게인 사람을 비교하는 방식으로 접근했다.

    1. 배열 정렬하기
    2. 오름차순으로 정렬된 배열을 마지막 원소부터 idx보다 크거나 같을 때까지 반복문을 돌린다.
    - 두명이 탄 경우 :
        - 만약 몸무게가 가장 많이 나가는 사람의 몸무게와 적게 나가는 사람의 몸무게 합이 limit을 넘지 않을때
        - answer에 1을 더한 후 idx값을 1 증가시킨다.
        - idx는 몸무게가 작은 사람의 위치를 나타내는 변수이기 때문에 다음 몸무게가 적은 사람을 비교하기 위해서 증가시킨다.
    - 혼자 탄 경우:
        - 만약 합이 limit을 넘을때 answer에 1을 증가시킨다.
        - 다음 무거운 사람과 현재 가벼운 사람과 비교
 */