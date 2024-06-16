package 배열;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/
 * 1282 / Group the People Given the Group Size They Belong To
 */
public class 배열_그룹크기_1282 {
    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        List<List<Integer>> groupedPeople = groupThePeople(groupSizes);

        for (List<Integer> group : groupedPeople) {
            System.out.println(group);
        }
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        // 각 그룹 크기에 해당하는 사람들의 목록 저장
        Map<Integer, List<Integer>> groups = new HashMap<>();
        // 최종적으로 반환할 그룹 목록
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            // map에 size가 없으면 새로운 리스트 추가
            groups.putIfAbsent(size, new ArrayList<>());
            // 현재 사람의 인덱스 i를 해당 그룹 크기의 리스트에 추가
            groups.get(size).add(i);

            // 리스트의 크기가 그룹 크기와 일치하면 그 리스트를 result에 추가하고 리스트 비우기
            if (groups.get(size).size() == size) {
                result.add(new ArrayList<>(groups.get(size)));
                groups.get(size).clear();
            }

        }
        return result;
    }

}

/*
이 문제는 각 사람 i가 **`groupSizes[i]`** 크기의 그룹에 속하도록 그룹 목록을 반환하는 문제입니다.

예를 들어:
- 입력: **`groupSizes = [3,3,3,3,3,1,3]`**
- 출력: **`[[5],[0,1,2],[3,4,6]]`**
설명: 첫 번째 그룹은 **`[5]`**입니다. 크기는 1이고, **`groupSizes[5] = 1`**입니다. 두 번째 그룹은 **`[0,1,2]`**입니다. 크기는 3이고, **`groupSizes[0] = groupSizes[1] = groupSizes[2] = 3`**입니다. 세 번째 그룹은 **`[3,4,6]`**입니다. 크기는 3이고, **`groupSizes[3] = groupSizes[4] = groupSizes[6] = 3`**입니다.

1. **해시맵 사용**: 각 그룹 크기에 해당하는 사람들의 목록을 관리하기 위해 **`HashMap`**을 사용합니다.
2. **배열 순회**: **`groupSizes`** 배열을 순회하면서 각 사람을 올바른 크기의 그룹에 배치합니다.
3. **그룹 추가**: 그룹에 사람을 추가할 때, 그룹의 크기가 충족되면 결과 목록에 그룹을 추가합니다.
 */


