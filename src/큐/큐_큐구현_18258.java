package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐_큐구현_18258 {
    /*
        정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 문제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 맨 뒤의 요소를 반환하는 메서드를 사용하기 위해 덱 사용
        Deque<Integer> queue = new LinkedList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer item = queue.poll();
                    if(item == null){
                        sb.append(-1);
                    }else{
                        sb.append(item);
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(queue.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(queue.peek());
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    }else{
                        sb.append(queue.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }


}

/*
    큐는 뒤의 요소를 반환하는 메서드가 없음
    반면에 덱은 튀의 요소를 반환하는 메서드가 있기 때문에 더 사용하기 좋다.
 */