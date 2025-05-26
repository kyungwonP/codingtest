package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test1662GPT {
    /**
     * 압축 - 시뮬레이션, 시간복잡도 O(n) 공간복잡도 O(n)
     * 압축되지 않은 문자열 S가 주어졌을 때, 이 문자열중 어떤 부분 문자열은 K(Q)와 같이 압축 할 수 있다.
     * K는 한자리 정수이고, Q는 0자리 이상의 문자열이다. 이 Q라는 문자열이 K번 반복된다는 뜻이다.
     * 압축된 문자열이 주어졌을 때, 이 문자열을 다시 압축을 푸는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 압축된 문자열 S가 들어온다. S의 길이는 최대 50이다. 문자열은 (, ), 0-9사이의 숫자로만 들어온다.
     * <p>
     * 출력
     * 첫째 줄에 압축되지 않은 문자열의 길이를 출력한다. 이 값은 2,147,473,647 보다 작거나 같다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        System.out.println(solution(line));
    }

    private static int solution(String line) {
        Stack<Integer> length = new Stack<>();
        Stack<Integer> repeat = new Stack<>();

        int size = line.length();

        for (int i = 0; i < size; i++) {
            char ch = line.charAt(i);

            if (Character.isDigit(ch)) {
                int digit = Character.getNumericValue(ch);

                // 다음 문자가 '(' 이면 반복자, 아니면 일반 문자
                if (i + 1 < size && line.charAt(i + 1) == '(') {
                    repeat.push(digit);
                } else {
                    length.push(1); // 일반 문자 1개 길이
                }

            } else if (ch == '(') {
                length.push(-1);
            } else if (ch == ')') {
                int segmentLength = 0;

                // '(' 이전까지 길이 합산
                while (!length.isEmpty()) {
                    int top = length.pop();
                    if (top == -1) {
                        break;
                    }

                    segmentLength += top;
                }

                int k = repeat.pop();
                length.push(segmentLength * k);
            }
        }

        int result = 0;
        while (!length.isEmpty()) {
            result += length.pop();
        }

        return result;
    }
}
