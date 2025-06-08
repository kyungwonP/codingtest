package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2583 {
    /**
     * 영역 구하기 - 구현 + 우선순위 큐 자료구조 + bfs(너비 우선 탐색), 시간 O(n * m), 공간 O(n^2)
     * 눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다.
     * 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
     * 예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.
     * <그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.
     * M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다.
     * 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다.
     * 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다.
     * 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.
     * <p>
     * 출력
     * 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.
     */

    private static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int m;
    private static int n;
    private static int k;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] moveRow = {-1, 1, 0, 0};
    private static int[] moveCol = {0, 0, -1, 1};
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for (int r = leftY; r < rightY; r++) {
                for (int c = leftX; c < rightX; c++) {
                    map[r][c] = 1;
                }
            }
        }

        solution();
    }

    private static void solution() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        result.append(priorityQueue.size()).append("\n");

        while (!priorityQueue.isEmpty()) {
            result.append(priorityQueue.poll()).append(" ");
        }

        System.out.println(result.toString().trim());
    }

    private static void bfs(int row, int col) {
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.offer(new Point(row, col));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + moveRow[i];
                int nextCol = current.col + moveCol[i];

                if (nextRow >= 0 && nextRow < m
                        && nextCol >= 0 && nextCol < n
                        && !visited[nextRow][nextCol]
                        && map[nextRow][nextCol] == 0
                ) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new Point(nextRow, nextCol));
                }
            }

            count++;
        }

        priorityQueue.offer(count);
    }
}
