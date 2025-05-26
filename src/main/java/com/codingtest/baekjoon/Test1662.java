package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test1662 {
    /**
     * 압축
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
        int result = 0;

        char[] chars = line.toCharArray();

        Stack<String> stack = new Stack<>();

        for (char ch : chars) {

            if (ch == ')') {
                StringBuilder sb = new StringBuilder();
                boolean isEnd = false;
                while (!stack.isEmpty()) {
                    String str = stack.pop();

                    // 괄호가 닫힌 경우 다음 루프때 종료 세팅
                    if ("(".equals(str)) {
                        isEnd = true;
                        continue;
                    }

                    // 괄호 앞 정수일 경우 sb에 저장된 문자열 수 곱하기
                    if (isEnd) {
                        int divide = Integer.parseInt(str);
                        StringBuilder sum = new StringBuilder();

                        for (int i = 0; i < divide; i++) {
                            sum.append(sb);
                        }

                        stack.push(sum.toString());
                        break;
                    }

                    sb.append(str);
                }

            } else {
                stack.push(String.valueOf(ch));
            }
        }

        for (String word : stack) {
            result += word.length();
        }

        return result;
    }
}
