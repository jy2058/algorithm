package 맵;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * 160586 / 대충 만든 자판
 * 프로그래머스
 *
 * 같은 규칙을 적용해 아무렇게나 만든 휴대폰 자판이 있습니다. 이 휴대폰 자판은 키의 개수가 1개부터 최대 100개까지 있을 수 있으며, 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열되어 있습니다. 또, 같은 문자가 자판 전체에 여러 번 할당된 경우도 있고, 키 하나에 같은 문자가 여러 번 할당된 경우도 있습니다. 심지어 아예 할당되지 않은 경우도 있습니다. 따라서 몇몇 문자열은 작성할 수 없을 수도 있습니다.
 *
 * 이 휴대폰 자판을 이용해 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지 알아보고자 합니다.
 */
public class 해시맵_문자횟수_160586 {
    public static void main(String[] args) throws IOException {

        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        System.out.println(Arrays.toString(solution(keymap, targets)));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] rtn = new int[targets.length];

        // keymap에서 문자별 최솟값을 HashMap에 넣기
        for(String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (!map.containsKey(c) || i < map.get(c)) {
                    map.put(c, i + 1);
                }
            }
        }

        // 각 문자를 HashMap의 키값과 비교
        // 해당 키값이 있으면 값을 cnt에 더해주기
        // 값이 없다면 cnt 0
        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (!map.containsKey(c)) {
                    cnt = 0;
                    break;
                } else {
                    cnt += map.get(c);
                }
            }
            rtn[i] = cnt == 0 ? -1 : cnt;
        }
        return rtn;
    }
}

/*
    해시맵을 이용하여 자판의 값을 키로, 인덱스를 값으로 사용하는 문제였다.

    1. keymap의 각 문자들을 HashMap 키로 설정, 인덱스를 값으로 설정
        - 존재하지않는 키일때 또는 인덱스가 더 작을 때 put
    2. target의 문자열을 각 문자별로 해당 키가 있는지 체크
        1. 키가 있다면 HashMap의 값을 cnt에 추가
        2. 키가 없다면 cnt에 0추가
 */