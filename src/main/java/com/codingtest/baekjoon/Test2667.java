package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test2667 {
    /**
     * 단지번호붙이기 - bfs + 우선순위 큐 자료구조, 시간/공간 O(n2)
     * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
     * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
     * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
     * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
     * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
     * <p>
     * 출력
     * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
     */

    private static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] moveRow = {-1, 1, 0, 0};
    private static int[] moveCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        solution();
    }

    private static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    getHouses(i, j);
                }
            }
        }

        System.out.println(priorityQueue.size());

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    private static void getHouses(int row, int col) {
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = point.row + moveRow[i];
                int nextCol = point.col + moveCol[i];

                if (nextRow >= 0 && nextRow < n
                        && nextCol >= 0 && nextCol < n
                        && !visited[nextRow][nextCol]
                        && map[nextRow][nextCol] == 1
                ) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new Point(nextRow, nextCol));
                }
            }

            result++;
        }

        priorityQueue.offer(result);
    }
}
