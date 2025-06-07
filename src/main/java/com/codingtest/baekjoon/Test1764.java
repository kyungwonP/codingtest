package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Test1764 {
    /**
     * 듣보잡 - 우선순위힙 자료구조, 시간 O(N + M + K log K), 공간 O(N + K)
     * 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
     * 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
     * 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
     * 듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
     * <p>
     * 출력
     * 듣보잡의 수와 그 명단을 사전순으로 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<String> targets = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (!set.add(name)) {
                targets.add(name);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(targets.size()).append("\n");

        while (!targets.isEmpty()) {
            result.append(targets.poll()).append("\n");
        }

        System.out.println(result.toString().trim());
    }
}
