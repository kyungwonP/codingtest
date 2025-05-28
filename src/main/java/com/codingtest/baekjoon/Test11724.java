package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Test11724 {
    /**
     * 연결 요소의 개수 - Union-Find 알고리즘 DSU(Disjoint Set Union), 시간복잡도 O(n + m), 공간복잡도 O(N)
     * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
     * (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
     * (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
     * <p>
     * 출력
     * 첫째 줄에 연결 요소의 개수를 출력한다.
     */

    private static int n;
    private static int m;
    private static int[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graphs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graphs[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        System.out.println(solution());
    }

    private static int solution() {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            set.add(find(i)); // 핵심
        }

        return set.size();
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            graphs[findA] = findB;
        }
    }

    private static int find(int number) {
        if (graphs[number] == number) {
            return graphs[number];
        }

        return graphs[number] = find(graphs[number]);
    }
}
