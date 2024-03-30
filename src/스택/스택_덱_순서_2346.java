package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 스택_덱_순서_2346 {
    /*
        예를 들어 다섯 개의 풍선 안에 차례로 3, 2, 1, -3, -1이 적혀 있었다고 하자. 이 경우 3이 적혀 있는 1번 풍선, -3이 적혀 있는 4번 풍선, -1이 적혀 있는 5번 풍선, 1이 적혀 있는 3번 풍선, 2가 적혀 있는 2번 풍선의 순서대로 터지게 된다
        터진 풍선의 번호를 순서대로 출력하는 문제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 순서가 있는 큐를 사용하기 때문에 ArrayDeque를 이용한다.
        // LinkedList를 사용하게 되면 메모리초과 난다.
        Deque<int[]> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            // 풍선번호와 다음 풍선번호를 배열로 저장
            int[] arr = {i + 1, Integer.parseInt(st.nextToken())};
            q.add(arr);
        }

        //  2개일 때 부터 삽입, 삭제 가능
        while (q.size() > 1) {
            int[] arr = q.pollFirst();
            sb.append(arr[0]).append(" ");
            int n = arr[1]; // 다음 풍선으로 이동하는 값
            // 양수일 때는 앞에서 빼서 뒤에 넣기
            if (n > 0) {
                for (int j = 1; j < n; j++) {
                    q.offerLast(q.pollFirst());
                }
            // 음수일 때는 뒤에서 빼서 앞에 넣기
            } else if (n < 0) {
                for (int j = n; j != 0; j++) {
                    q.offerFirst(q.pollLast());
                }
            }
        }
        // 한개 남았을 때는 그냥 출력
        sb.append(q.poll()[0]);
        System.out.println(sb);
    }
}

/*

    덱을 이용해서 앞, 뒤로 풍선의 위치만큼 넣고 뺴고 해주면 되는 문제이다.
    LinkedList를 이용했더니 메모리 초과가 났다.
    순차적인 데이터 추가, 삭제에는 ArrayDeque을 사용하면 된다.

    1. 풍선번호와 다음 풍선 위치를 배열로 덱에 저장한다.
    2. 다음 풍선위치가 양수일 때는 앞에서 빼서 뒤에 넣어주기
    3. 다음 풍선 위치가 음수일 때는 뒤에서 빼서 앞에 넣어주기
 */