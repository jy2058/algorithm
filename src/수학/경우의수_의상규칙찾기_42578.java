package 수학;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * 42578 / 의상
 * 프로그래머스
 *
 * 코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.
 *
 * 예를 들어 코니가 가진 옷이 아래와 같고, 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.
 *
 * -----------
 * 종류	| 이름
 * -----------
 * 얼굴	| 동그란 안경, 검정 선글라스
 * 상의	| 파란색 티셔츠
 * 하의	| 청바지
 * 겉옷	| 긴 코트
 * -----------
 * 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
 * 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
 * 코니는 하루에 최소 한 개의 의상은 입습니다.
 * 코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class 경우의수_의상규칙찾기_42578 {
    public static void main(String[] args) throws IOException {
//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"},{"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // 옷 종류별로 몇 개를 가지고 있는지 체크
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;
        // 경우의 수 구하기
        /*
            headgear에 해당하는 의상이 yellow_hat, green_turban일 경우
            1. yellow_hat을 선택하는 경우
            2. green_turban을 선택하는 경우
            3. 아무것도 선택하지 않는 경우
            총 3가지
         */
        for (int cnt : map.values()) {
            answer *= cnt + 1;  // 아무것도 선택하지 않는 경우를 위해 +1 해줌
        }

        // 공집합 포함 안되므로(최소 한 개의 의상은 입는다) -1을 해준다
        answer -= 1;

        return answer;
    }
}

/*
    옷의 종류 별로 조합을 해서 총 몇 가지의 경우로 입을 수 있는지 계산하는 문제였다.

    조건은 아래와 같다.

    - 매일 다른 옷을 입을 것
    - 한 가지 종류만 입어도 됨
    - 같은 종류의 옷은 반드시 최대 한 개만 입음
    - 이름이 같은 옷은 존재하지 않음

    위의 조건대로 풀이를 하자면,

    1. 옷의 종류 별로 몇 가지인지 체크
    2. 옷의 종류를 한 가지만 입거나, 두 가지를 입거나, … 모든 경우의 수를 구하기
        - 경우의 수 구하기

        **headgear에 해당하는 의상이 yellow_hat, green_turban일 경우**

        1. yellow_hat을 선택하는 경우
        2. green_turban을 선택하는 경우
        3. 아무것도 선택하지 않는 경우

        총 3가지가 된다. 아무것도 선택하지 않는 경우를 포함해야 하기 떄문에 + 1을 같이 해줘야한다.

    3. 구한 경우의 수에서 공집합은 포함 안되므로(최소 한 개의 의상은 입는다)는 조건이 있기 때문에 -1을 해준다.
 */