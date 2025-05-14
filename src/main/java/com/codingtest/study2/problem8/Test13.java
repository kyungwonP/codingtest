package com.codingtest.study2.problem8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test13 {
    /**
     * 13. 섬나라 아일랜드(BFS)
     * 설명
     * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
     * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
     * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
     * 1 1 0 0 0 1 0
     * 0 1 1 0 1 1 0
     * 0 1 0 0 0 0 0
     * 0 0 0 1 0 1 1
     * 1 1 0 1 1 0 0
     * 1 0 0 0 1 0 0
     * 1 0 1 0 1 0 0
     * 만약 위와 같다면 섬의 개수는 5개입니다.
     * <p>
     * 입력
     * 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
     * 두 번째 줄부터 격자판 정보가 주어진다.
     * <p>
     * 출력
     * 첫 번째 줄에 섬의 개수를 출력한다.
     */

    private int[] moveRow = {-1, 1, 0, 0, -1, -1, 1, 1};
    private int[] moveCol = {0, 0, -1, 1, -1, 1, -1, 1};

    private static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }

        in.nextLine();

        System.out.println(new Test13().solution(n, map));
    }

    private int solution(int n, int[][] map) {
        int result = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    queue.offer(new Point(i, j));

                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        visited[point.row][point.col] = true;

                        for (int k = 0; k < 8; k++) {
                            int nextRow = point.row + moveRow[k];
                            int nextCol = point.col + moveCol[k];

                            if (nextRow >= 0 && nextRow < n
                                    && nextCol >= 0 && nextCol < n
                                    && !visited[nextRow][nextCol]
                                    && map[nextRow][nextCol] == 1
                            ) {
                                queue.offer(new Point(nextRow, nextCol));
                                visited[nextRow][nextCol] = true;
                            }
                        }

                    }

                    result++;
                }
            }
        }

        return result;
    }

}
