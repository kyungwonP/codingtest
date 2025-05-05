package com.codingtest.study2.problem5;

import java.util.Scanner;
import java.util.Stack;

public class Test4 {
    /**
     * 4. 후위식 연산(postfix)
     * 설명
     * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
     * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
     * <p>
     * 입력
     * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
     * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
     * <p>
     * 출력
     * 연산한 결과를 출력합니다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        System.out.println(new Test4().solution(line));
    }

    private int solution(String line) {
        int result = 0;
        int calculationCount = 0;

        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> characterStack = new Stack<>();

        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                integerStack.push(Character.getNumericValue(c));
            } else {
                Integer calculationAfter = integerStack.pop();
                Integer calculationBefore = result;

                if (!integerStack.isEmpty() && calculationCount == 0) {
                    calculationBefore = integerStack.pop();
                }

                result = calculation(calculationBefore, calculationAfter, c);

                calculationCount++;
            }
        }

        return result;
    }

    private int calculation(int before, int after, char prefix) {
        if (prefix == '+') {
            return before + after;
        } else if (prefix == '-') {
            return before - after;
        } else if (prefix == '*') {
            return before * after;
        } else if (prefix == '/') {
            return before / after;
        } else if (prefix == '%') {
            return before % after;
        } else {
            return after;
        }
    }
}
