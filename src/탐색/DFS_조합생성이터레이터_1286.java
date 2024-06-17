package 탐색;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/iterator-for-combination/
 * 1286 / Iterator for Combination
 *
 * Design the CombinationIterator class:
 * CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 * next() Returns the next combination of length combinationLength in lexicographical order.
 * hasNext() Returns true if and only if there exists a next combination.
 *
 * Example 1:
 * Input
 * ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [["abc", 2], [], [], [], [], [], []]
 * Output
 * [null, "ab", true, "ac", true, "bc", false]
 *
 * Explanation
 * CombinationIterator itr = new CombinationIterator("abc", 2);
 * itr.next();    // return "ab"
 * itr.hasNext(); // return True
 * itr.next();    // return "ac"
 * itr.hasNext(); // return True
 * itr.next();    // return "bc"
 * itr.hasNext(); // return False
 */
public class DFS_조합생성이터레이터_1286 {
    public static void main(String[] args) {
        String characters = "abc";
        int combination = 2;
        CombinationIterator itr = new CombinationIterator(characters, combination);
        System.out.println(itr.next());    // return "ab"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "ac"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "bc"
        System.out.println(itr.hasNext()); // return False
    }

    public static class CombinationIterator {
        String characters;
        int combinationLength;
        LinkedList<String> combinations;    // 생성된 조합 저장

        public CombinationIterator(String characters, int combinationLength) {
            this.characters = characters;
            this.combinationLength = combinationLength;
            this.combinations = new LinkedList<>();

            // 초기 조합 생성
            dfs(0, new StringBuilder());
        }

        /**
         * 백트래킹을 이용한 조합 생성 메서드
         * @param start 현재 인덱스
         * @param sb 문자
         */
        private void dfs(int start, StringBuilder sb){
            // 조합의 길이가 목표 길이에 도달하면 리스트에 추가
            if(sb.length() == combinationLength){
                combinations.add(sb.toString());
                return;
            }

            // 현재 인덱스부터 시작하여 조합 생성
            for(int i = start; i < characters.length(); i++){
                sb.append(characters.charAt(i));    // 문자 추가
                dfs(i + 1, sb); // 다음 문자로 넘어가기
                sb.deleteCharAt(sb.length() - 1);   // 마지막 문자 제거하고 다시 시도
            }
        }

        /**
         * 다음 조합을 반환하는 메서드
         * @return 리스트의 첫번째 조합
         */
        public String next() {
            return combinations.poll(); // 리스트의 첫번째 조합을 반환하고 제거
        }

        /**
         * 다음 조합이 있는지 확인하는 메서드
         * @return 리스트가 비어있지 않으면 true 반환
         */
        public boolean hasNext() {
            return !combinations.isEmpty();
        }

    }

}
/*
이 문제는 조합을 생성하는 이터레이터를 구현하는 것입니다.
여기서 중요한 것은 모든 가능한 조합을 미리 생성하지 않고, 요청이 있을 때마다 다음 조합을 생성하는 것입니다.

이를 위해 다음과 같은 접근 방법을 사용할 수 있습니다:
1. 초기화: 생성자에서 문자열 characters를 받아들이고, 각 문자에 대한 인덱스를 저장합니다. 또한, 첫 번째 조합을 생성하기 위해 가장 앞쪽의 combinationLength 개의 문자를 선택합니다.
2. 조합 생성: next() 메소드가 호출될 때마다, 현재 조합을 반환하고, 사전순으로 다음 조합을 찾습니다. 이를 위해 현재 조합의 마지막 문자부터 시작하여, 다음으로 올 수 있는 문자를 찾고, 조합을 업데이트합니다.
3. 조합 검증: hasNext() 메소드는 아직 반환하지 않은 조합이 남아 있는지 확인합니다. 만약 현재 조합이 가능한 마지막 조합이라면 false를 반환합니다.
 */




