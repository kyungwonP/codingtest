package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1197 {
    /**
     * 최소 스패닝 트리 - prim 알고리즘, 시간복잡도 O(E log V), 공간복잡도 O(V + E)
     * 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.
     * 최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
     * <p>
     * 입력
     * 첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다.
     * 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
     * 이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.
     * 그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다.
     * 최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.
     * <p>
     * 출력
     * 첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.
     */

    private static class Node implements Comparable<Node> {
        int number;
        int cost;

        Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Map<Integer, List<Node>> map = new HashMap<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            List<Node> aList = map.getOrDefault(a, new ArrayList<>());
            aList.add(new Node(b, cost));

            List<Node> bList = map.getOrDefault(b, new ArrayList<>());
            bList.add(new Node(a, cost));

            map.put(a, aList);
            map.put(b, bList);
        }

        System.out.println(solution(v, e, map));
    }

    private static int solution(int v, int e, Map<Integer, List<Node>> map) {
        int result = 0;

        boolean[] visited = new boolean[v + 1];

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(1, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (!visited[node.number]) {
                visited[node.number] = true;
                result += node.cost;
                List<Node> nextNodes = map.get(node.number);

                for (Node nextNode : nextNodes) {
                    priorityQueue.offer(nextNode);
                }
            }
        }

        return result;
    }
}
