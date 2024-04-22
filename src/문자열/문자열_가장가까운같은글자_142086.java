package 문자열;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 * 142086 / 가장 가까운 같은 글자
 * 프로그래머스
 *
 * 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
 * 예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
 *
 * b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 * a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 * n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 * a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
 * n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
 * a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
 * 따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
 *
 * 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
 */
public class 문자열_가장가까운같은글자_142086 {
    public static void main(String[] args) throws IOException {
        String s = "banana";
        System.out.println(Arrays.toString(solution(s)));
    }
    public static int[] solution(String s) {
        // 문자열 길이만큼 배열 생성
        int[] answer = new int[s.length()];

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);  // 현재 문자
            // 현재 문자의 인덱스와 이전에 나온 문자의 인덱스를 뺴주기
            // map에 현재 문자가 없다면 현재 인덱스에 +1을 하기 ( 항상 -1이 나오게 됨)
            answer[i] = i - map.getOrDefault(ch, i + 1);
            // 현재 인덱스로 map에 저장(인덱스 갱신)
            map.put(ch, i);
        }
        return answer;
    }

}

/*
    해당 문제는 문자열 중 같은 글자의 인덱스를 이용해서 풀이하는 문제였다.
    단순히 indexOf 메서드를 사용하기에는 자신의 바로 앞에 있는 문자의 인덱스를 찾아야 하기 때문에 Map을 사용하여 인덱스를 갱신했다.

    1. 문자열 길이만큼의 배열을 생성
    2. 현재 문자의 인덱스와 이전에 나온 문자의 인덱스를 빼주기
        - 인덱스간의 차이를 구해야하기 때문
        - map에 해당하는 문자가 없다면 현재 인덱스에 + 1을한다. ( 항상 -1이 나오게 됨)
    3. 현재 인덱스를 map에 저장하여 인덱스를 갱신
 */


