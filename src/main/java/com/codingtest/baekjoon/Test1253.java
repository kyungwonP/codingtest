package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1253 {
    /**
     * 좋다
     * N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
     * N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
     * 수의 위치가 다르면 값이 같아도 다른 수이다.
     * <p>
     * 입력
     * 첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)
     * <p>
     * 출력
     * 좋은 수의 개수를 첫 번째 줄에 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, numbers));
    }

    private static int solution(int n, int[] numbers) {
        int result = 0;

        for (int i = 2; i < n; i++) {
            boolean isGood = isGood(n, numbers, i);
            if (isGood) {
                result++;
            }
        }

        return result;
    }

    private static boolean isGood(int n, int[] numbers, int index) {
        int sum = numbers[index];
        int left = 0;
        int right = left + 1;

        while (right < n) {
            if (numbers[left] + numbers[right] == sum) {
                return true;
            } else if (numbers[left] + numbers[right] < sum) {
                right++;
            } else {
                left++;
                right = left + 1;
            }
        }

        return false;
    }
}
