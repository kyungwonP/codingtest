package com.codingtest.study2.problem9;

import java.util.Scanner;

public class Test7 {
    /**
     * 7. 원더랜드(최소스패닝트리)
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

    private static int[] union;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();

        union = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            union[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();
        }

        System.out.println();
    }

    private static void union(int a, int b){
        int findA = find(a);
        int findB = find(b);

        if(findA != findB){
            union[findA] = findB;
        }
    }

    private static int find(int number){
        if(union[number] == number){
            return union[number];
        }

        return union[number] = find(union[number]);
    }
}
