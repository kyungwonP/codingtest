package com.codingtest.study2.problem5;

import java.util.Scanner;
import java.util.Stack;

public class Test2 {
    /**
     * 2. 괄호문자제거
     * 설명
     * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
     * <p>
     * 출력
     * 남은 문자만 출력한다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        System.out.println(new Test2().solution(line));
    }

    private String solution(String line) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : line.toCharArray()) {
            stack.push(c);
            if (c == ')') {
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop == '(') {
                        break;
                    }
                }
            }
        }

        for (Character c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
