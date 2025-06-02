package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Test1920 {
    /**
     * 수 찾기 - 해쉬탐색, 시간/공간 O(N + M)
     * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
     * 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
     * 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
     * <p>
     * 출력
     * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            hashSet.add(number);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (hashSet.contains(number)) {
                result.append(1).append("\n");
            } else {
                result.append(0).append("\n");
            }
        }

        System.out.println(result.toString().trim());
    }
}
