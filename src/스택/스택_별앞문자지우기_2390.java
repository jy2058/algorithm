package 스택;

import java.util.Stack;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/description/
 * 2390 / Removing Stars From a String
 *
 * You are given a string s, which contains stars *.
 * In one operation, you can:

 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 *
 * Note:
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 *
 * Example 1:
 * Input: s = "leet**cod*e"
 * Output: "lecoe"
 * Explanation: Performing the removals from left to right:
 * - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
 * - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
 * - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
 * There are no more stars, so we return "lecoe".
 *
 * Example 2:
 * Input: s = "erase*****"
 * Output: ""
 * Explanation: The entire string is removed, so we return an empty string.
 *
 */
public class 스택_별앞문자지우기_2390 {
    public static void main(String[] args) {
//        String s = "leet**cod*e";
        String s = "erase*****";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

/*
이 문제는 ‘*’ 특수문자와 앞의 특수문자가 아닌 글자를 같이 지우는 문제입니다.
스택을 이용하여 ‘*’이 입력 됐을 때 스택에서 이전 글자를 꺼내는 방식으로 풀이를 할 수 있습니다.

1. 스택을 선언하고 입력 받은 문자열을 스캔합니다.
2. 특수문자가 아닌 일반 문자가 들어오면 스택에 추가합니다.
3. 특수문자인 ‘*’가 들어오고, 스택이 비어있지 않다면 스택에서 이전 문자를 꺼냅니다.
4. 입력받은 문자열을 모두 스캔 후 StringBuilder에 스택에 담긴 문자들을 추가합니다.
5. 스택에서 문자를 꺼낼 때는 역순으로 담기기 때문에 reverse 메서드를 이용해 반전 시켜줍니다.
 */



