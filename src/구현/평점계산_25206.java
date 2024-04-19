package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/25206
 * 25206 / 너의 평점은
 * 실버5
 *
 * 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
 * 치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
 * 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
 * P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
 * 과연 치훈이는 무사히 졸업할 수 있을까?
 */
public class 평점계산_25206 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalSum = 0.0;  // 전공과목별 합
        double scoreSum = 0.0;  // 학점 총합

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();    // 과목명
            double score = Double.parseDouble(st.nextToken());  // 학점
            String grade = st.nextToken();  // 등급(알파벳)

            // 전공과목별 합 구하기
            totalSum += score * convertGrade(grade);

            // 'P'일 경우 계산에서 제회
            if (!"P".equals(grade)) {
                scoreSum += score;
            }
        }
        // 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값
        System.out.printf("%.6f", totalSum / scoreSum);

    }

    /**
     * 알파벳으로 된 학점을 double 형식의 점수로 변경
     * @param grade 학점("A", "B"...)
     * @return 변환된 학점
     */
    public static double convertGrade(String grade) {
        if (grade.equals("A+")) {
            return 4.5;
        } else if (grade.equals("A0")) {
            return 4.0;
        } else if (grade.equals("B+")) {
            return 3.5;
        } else if (grade.equals("B0")) {
            return 3.0;
        } else if (grade.equals("C+")) {
            return 2.5;
        } else if (grade.equals("C0")) {
            return 2.0;
        } else if (grade.equals("D+")) {
            return 1.5;
        } else if (grade.equals("D0")) {
            return 1.0;
        } else if (grade.equals("F")) {
            return 0.0;
        } else {
            return 0.0;
        }
    }
}


