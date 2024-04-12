package 맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16165
 * 16165 / 걸그룹 마스터 준석이
 * 실버3
 *
 * 정우는 소문난 걸그룹 덕후이다.
 * 정우의 친구 준석이도 걸그룹을 좋아하지만 이름을 잘 외우지 못한다는 문제가 있었다.
 * 정우는 친구를 위해 걸그룹 개인과 팀의 이름을 검색하여 외우게 하는 퀴즈 프로그램을 만들고자 한다.
 */
public class 해시맵_그룹_멤버_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 입력 개수
        int M = Integer.parseInt(st.nextToken());   // 출력 개수

        HashMap<String, String[]> group = new HashMap<>();  // 그룹별 멤버 목록
        HashMap<String, String> names = new HashMap<>();    // key: 멤버이름, value: 그룹명

        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            String[] nameArr = new String[cnt]; // 멤버이름 배열

            for (int j = 0; j < cnt; j++) {
                String name = br.readLine();
                names.put(name, groupName); // 멤버 이름에 어떤 그룹인지 put
                nameArr[j] = name;  // 배열에 멤버 이름 추가
            }
            Arrays.sort(nameArr);   // 이름 오름차순으로 정렬
            group.put(groupName, nameArr);  // 해당 그룹에 멤버 put
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            int flag = Integer.parseInt(br.readLine());
            if (flag == 0) {    // 멤버 출력
                String[] targetNames = group.get(target);
                for (int j = 0; j < targetNames.length; j++) {
                    sb.append(targetNames[j]).append("\n");
                }
            } else if (flag == 1) { // 그룹명 출력
                sb.append(names.get(target)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
/*
    해당 문제는 Map과 배열 또는 TreeSet을 이용하는 문제였다.
    멤버 이름 정렬을 위해 배열과 Arrays.sort를 썼는데 TreeSet을 이용해도 좋았을 것 같다.

    1. 그룹의 멤버명들을 저장할 배열, 맵 생성
    2. 멤버가 어떤 그룹인지 저장할 맵 생성
    3. 멤버맵에 (key: 멤버명, value: 그룹명) 저장
    4. 배열에 멤버명을 추가
    5. 멤버명 배열 오름차순 정렬
    6. 그룹맵에 (그룹명, 멤버명 배열) 저장
    7. 0일 때 멤버 맵에서 해당 멤버명 배열을 가져와 출력
    8. 1일 때 해당 그룹 명 출력
 */