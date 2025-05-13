package com.codingtest.study2.problem8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test11 {
    /**
     * 11. 미로의 최단거리 통로(BFS)
     * 설명
     * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
     * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
     * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
     * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
     * S 0 0 0 0 0 0
     * 0 1 1 1 1 1 0
     * 0 0 0 1 0 0 0
     * 1 1 0 1 0 1 1
     * 1 1 0 1 0 0 0
     * 1 0 0 0 1 0 0
     * 1 0 1 0 0 0 D
     * 위와 같은 경로가 최단 경로의 길이는 12이다.
     * <p>
     * 입력
     * 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
     */
    private static int N = 7;
    private int[] moveRow = {-1, 1, 0, 0};
    private int[] moveCol = {0, 0, -1, 1};

    private class Point {
        int row;
        int col;
        int distance;

        Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = in.nextInt();
            }
            in.nextLine();
        }

        System.out.println(new Test11().solution(board));
    }

    private int solution(int[][] board) {
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.row == N - 1 && point.col == N - 1) {
                return point.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = point.row + moveRow[i];
                int nextCol = point.col + moveCol[i];

                if (isValid(board, visited, nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new Point(nextRow, nextCol, point.distance + 1));
                }
            }
        }

        return -1;
    }

    private boolean isValid(int[][] board, boolean[][] visited, int nextRow, int nextCol) {
        if (nextRow >= 0 && nextRow < N
                && nextCol >= 0 && nextCol < N
                && board[nextRow][nextCol] == 0
                && !visited[nextRow][nextCol]
        ) {
            return true;
        } else {
            return false;
        }
    }

}
