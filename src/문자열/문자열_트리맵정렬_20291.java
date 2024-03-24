package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class 문자열_트리맵정렬_20291 {
    /*
        파일명의 확장자와 갯수를 오름차순으로 출력하기.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] split = str.split("\\.");

            if(map.containsKey(split[1])){
                map.put(split[1], map.get(split[1]) + 1);
            }else{
                map.put(split[1], 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

}
/*
    tree map을 사용하면 따로 정렬을 안 해도 된다.
 */

