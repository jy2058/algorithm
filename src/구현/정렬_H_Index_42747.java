package 구현;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747#
 * 42747 / H-Index
 *
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 */
public class 정렬_H_Index_42747 {
    public static void main(String[] args) throws IOException {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {

        // 내림차순 정렬하기 위해 Integer형식으로 변환
        Integer[] wrapCitations = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        // 내림차순 정렬
        Arrays.sort(wrapCitations, Collections.reverseOrder());

        int cnt = 0;

        /*
            논문 n편 증, a번 이상 인용된 논문이 b편 이상이면 a 와 b중 작은 값이 hIndex 값입니다.
            즉, 내림차순 정렬을 했을 떄 cnt의 값이 해당 값보다 작거나 같을 때 cnt가 최대값인 hIndex가 된다.
         */
        for (int i = 0; i < wrapCitations.length; i++) {
            if (wrapCitations[i] > cnt) {
                cnt++;
            } else if (wrapCitations[i] <= cnt) {
                return cnt;
            }
        }

        return cnt;
    }
}

/*

해당 문제는 학술 논문의 인용 횟수를 분석하여 연구자의 영향력을 평가하는 **h-index**를 계산하는 알고리즘이다.

h-index는 연구자가 발표한 논문 중 최소 h편 이상이 h번 이상 인용된 것을 의미한다.

**논문 n편 증, a번 이상 인용된 논문이 b편 이상이면 a 와 b중 작은 값이 hIndex 값이다.**

예를들면,

- [10, 8, 5, 4, 3] 의 인용횟수를 가진 교수가 있다면
1. 10번 이상 인용 횟수를 가진 논문은 1편이다. 이때 H-Index는 1이다.
2. 8번 이상 인용 횟수를 가진 논문은 2편이다. 이때 H-Index는 2이다.
3. 5번 이상 인용 횟수를 가진 논문은 3편이다. 이때 H-Index는 3이다.
4. 4번 이상 인용 횟수를 가진 논문은 4편이다. 이때 H-Index는 4이다.
5. 3번 이상 인용 횟수를 가진 논문은 5편이다. 이때 H-Index는 3이다.

**여기서 H-Index는 4이다 이 경우에는 논문의 개수와 인용 횟수가 같으니 헷갈릴 수 있다.**

- [9, 7, 6, 2, 1] 의 인용 횟수를 가진 교수가 있다면
1. 9번 이상 인용 횟수를 가진 논문은 1편이다. 이때 H-Index는 1이다.
2. 7번 이상 인용 횟수를 가진 논문은 2편이다. 이때 H-Index는 2이다.
3. 6번 이상 인용 횟수를 가진 논문은 3편이다. 이때 H-Index는 3이다.
4. 2번 이상 인용 횟수를 가진 논문은 4편이다. 이때 H-Index는 2이다.
5. 1번 이상 인용 횟수를 가진 논문은 5편이다. 이때 H-Index는 1이다.

**여기서 H-Index는 3이다.**

따라서, 이 예시를 보고 내림차순을 하여 배열의 값이 cnt보다 작거나 같으면 h-index라고 생각하여 코드를 작성하였다.
 */