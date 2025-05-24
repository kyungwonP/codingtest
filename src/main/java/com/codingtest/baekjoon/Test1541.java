package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1541 {
    /**
     * 잃어버린 괄호 - 그리디 알고리즘
     * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
     * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
     * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
     * <p>
     * 출력
     * 첫째 줄에 정답을 출력한다.
     */

    public static void main(String[] args) throws IOException {
        // 테스트케이스
//        List<String> testCases = List.of("55-50+40", "10+20+30+40", "00009-00009", "1+2-3-4+6-1+2-3");
//        List<Integer> answers = List.of(-35, 100, 0, -16);
//
//        int size = testCases.size();
//        for (int i = 0; i < size; i++) {
//            String line = testCases.get(i);
//            int solution = solution(line);
//            System.out.println(solution + " " + (answers.get(i).equals(solution) ? "pass" : "fail"));
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(solution(line));
    }

    private static int solution(String line) {
        int total = 0;

        // 최소 값이 되도록 괄호 넣기
        // minus로 나눈 뒤 첫 그룹은 더하고 plus로 나눈 값 또는 단일 값은 합쳐서 뺴기
        String[] minusSplits = line.split("-");

        int size = minusSplits.length;
        for (int i = 0; i < size; i++) {
            String minusSplit = minusSplits[i];
            String[] plusSplits = minusSplit.split("\\+");
            int sum = 0;

            for (String plusSplit : plusSplits) {
                sum += Integer.parseInt(plusSplit);
            }

            // 첫번쨰 값은 더하기
            if (i == 0) {
                total += sum;
            } else {
                total -= sum;
            }
        }

        return total;
    }
}
