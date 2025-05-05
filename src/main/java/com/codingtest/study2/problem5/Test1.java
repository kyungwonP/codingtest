package com.codingtest.study2.problem5;

import java.util.Scanner;
import java.util.Stack;

public class Test1 {
    /**
     * 1. 올바른 괄호
     * 설명
     * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
     * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
     * <p>
     * 입력
     * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
     * <p>
     * 출력
     * 첫 번째 줄에 YES, NO를 출력한다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        System.out.println(new Test1().solution(line));
    }

    private String solution(String line) {
        String result = "NO";
        char[] chars = line.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (Character.valueOf('(').equals(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return result;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            result = "YES";
        }

        return result;
    }
}
