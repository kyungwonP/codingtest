package com.codingtest.study2.problem3;

import java.util.Scanner;

public class Test6GPT {
    /**
     * 6. 최대 길이 연속부분수열
     * 설명
     * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
     * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
     * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
     * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
     * 이며 그 길이는 8입니다.
     * <p>
     * 입력
     * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
     * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
     * <p>
     * 출력
     * 첫 줄에 최대 길이를 출력하세요.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        int size = Integer.parseInt(firstLine.split(" ")[0]);
        int change = Integer.parseInt(firstLine.split(" ")[1]);
        String line = in.nextLine();
        System.out.println(new Test6GPT().solution(size, change, line));
    }

    private int solution(int size, int change, String line) {
        int result = 0;

        String[] numbers = line.split(" ");

        int changeCount = 0;
        int left = 0;

        for (int right = 0; right < size; right++) {
            int currentNumber = Integer.parseInt(numbers[right]);

            if (currentNumber == 0) {
                changeCount++;
            }

            while (changeCount > change) {
                if (Integer.parseInt(numbers[left++]) == 0) {
                    changeCount--;
                }
            }

            if (changeCount == change) {
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}
