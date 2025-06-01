package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test11053 {
    /***
     * 가장 긴 증가하는 부분 수열 - 동적 계획법 (DP) + 최장 증가 부분 수열 (LIS), 시간복잡도 O(n^2), 공간복잡도 O(n)
     * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
     * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
     *
     * 입력
     * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
     * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
     *
     * 출력
     * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
     *
     * 테스트케이스
     * 10
     * 10 20 10 30 20 50 30 40 50 60
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
        int[] distances = new int[n];

        distances[0] = 1;

        for (int i = 1; i < n; i++) {
            int number = numbers[i];

            int sum = 0;

            for (int j = i - 1; j >= 0; j--) {
                int prev = numbers[j];

                if (number > prev) {
                    sum = Math.max(sum, distances[j]);
                }
            }

            distances[i] = sum + 1;

            result = Math.max(result, distances[i]);
        }

        return result;
    }
}
