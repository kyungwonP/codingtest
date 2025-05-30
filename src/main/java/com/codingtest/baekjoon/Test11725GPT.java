package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test11725GPT {
    /**
     * 트리의 부모 찾기 - BFS(너비 우선 탐색), 시간/공간 O(N)
     * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
     * <p>
     * 출력
     * 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
     */

    private static int n;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(bfs());
    }

    private static String bfs() {
        StringBuilder result = new StringBuilder();
        int[] parents = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        boolean[] visited = new boolean[n + 1];

        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            List<Integer> connectList = graph[current];

            for (int connect : connectList) {
                if (!visited[connect]) {
                    visited[connect] = true;
                    parents[connect] = current;
                    queue.offer(connect);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            result.append(parents[i]).append("\n");
        }

        return result.toString().trim();
    }
}
