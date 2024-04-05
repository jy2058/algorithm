package 맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/19583
 * 19583 / 싸이버 개강총회
 * 실버2
 *
 * 입장부터 퇴장까지 모두 확인된 학회원은 전부 몇 명인가?
 */
public class 해시셋_값유무체크_19583 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String startTime = st.nextToken();  // 개강총회 시작시간
        String endTime = st.nextToken();    // 개강총회 종료시간
        String streamTime = st.nextToken(); // 스트리밍 종료시간

        Set<String> startCheck = new HashSet<>();   // 시작 전 출석체크
        Set<String> endCheck = new HashSet<>();     // 종료 후 출석체크

        int count = 0;  // 출석 인원
        String temp;
        while ((temp = br.readLine()) != null) {
            String[] split = temp.split(" ");
            String time = split[0]; // 채팅 시간
            String name = split[1]; // 이름
            // 시작 시간 전에 채팅을 썼다면 시작 전 출석체크에 이름 추가
            if(startTime.compareTo(time) >= 0){
                startCheck.add(name);
            // 총회 종료시간과 스트리밍 종료시간에 채팅을 썼다면 종료 출석체크에 이름 추가
            } else if (endTime.compareTo(time) <= 0 && streamTime.compareTo(time) >= 0) {
                endCheck.add(name);
            }

        }
        // 출석 체크를 하려면 종료 출석에 이름이 무조건 있어야 하기 때문에 종료 출석으로 for문
        for (String s : endCheck) {
            // 시작 출석에 종료 출석에 있는 이름이 있다면 출석인원 + 1
            if (startCheck.contains(s)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
/*
두개의 해시셋을 이용하여 양쪽 모두 포함이 된 사람을 찾으면 되는 문제였다.

    1. 시작 전 출석체크 용 해시셋, 종료 후 출석체크 용 해시셋을 만든다
    2. 입력받은 값을 채팅 시간과 이름으로 분리한다.
    3. 입력받은 시간이 시작 시간 전일 경우 시작 전 출석체크에 추가한다.
    4. 입력받은 시간이 총회 종료시간과 스트리밍 종료시간 동안일 경우 종료 후 출석시간에 추가한다.
    5. 출석 체크를 하기 위해선 종료 후 출석 set에 이름이 무조건 있어야 하기 때문에 종료 후 출석 체크로 for문을 돌린다.
    6. 종료 출석체크에 있는 이름이 시작 출석체크 set에 있는지 확인 후 count를 +1 해준다.
 */