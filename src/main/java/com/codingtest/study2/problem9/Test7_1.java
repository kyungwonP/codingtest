package com.codingtest.study2.problem9;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test7_1 {
    /**
     * 7. 원더랜드(최소스패닝트리 - 프림 : PriorityQueue 활용)
     * 설명
     * 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
     * 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
     * 아래의 그림은 그 한 예를 설명하는 그림이다.
     * 위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.
     * <p>
     * 입력
     * 첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
     * 다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
     * 이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
     * <p>
     * 출력
     * 모든 도시를 연결하면서 드는 최소비용을 출려한다.
     */

    private static class Road implements Comparable<Road> {
        int city;
        int cost;

        Road(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road road) {
            return this.cost - road.cost;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();

        List<List<Road>> graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();

            graph.get(a).add(new Road(b, m));
            graph.get(b).add(new Road(a, m));
        }

        System.out.println(solution(v, graph));
    }

    private static int solution(int v, List<List<Road>> graph) {
        int result = 0;
        PriorityQueue<Road> priorityQueue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];

        priorityQueue.offer(new Road(1, 0));

        while (!priorityQueue.isEmpty()) {
            Road road = priorityQueue.poll();

            if (!check[road.city]) {
                check[road.city] = true;
                result += road.cost;

                List<Road> nextRoads = graph.get(road.city);
                for (Road nextRoad : nextRoads) {
                    if (!check[nextRoad.city]) {
                        priorityQueue.offer(nextRoad);
                    }
                }
            }
        }

        return result;
    }
}
