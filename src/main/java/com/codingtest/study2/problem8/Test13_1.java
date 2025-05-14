package com.codingtest.study2.problem8;

import java.util.Scanner;

public class Test13_1 {
    /**
     * 13. 섬나라 아일랜드(DFS)
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

    private final int[] moveRow = {-1, 1, 0, 0, -1, -1, 1, 1};
    private final int[] moveCol = {0, 0, -1, 1, -1, 1, -1, 1};

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

        System.out.println(new Test13_1().solution(n, map));
    }

    private int solution(int n, int[][] map) {
        int result = 0;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(n, map, visited, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int n, int[][] map, boolean[][] visited, int startRow, int startCol) {
        visited[startRow][startCol] = true;

        for (int i = 0; i < 8; i++) {
            int nextRow = startRow + moveRow[i];
            int nextCol = startCol + moveCol[i];

            if (nextRow >= 0 && nextRow < n
                    && nextCol >= 0 && nextCol < n
                    && !visited[nextRow][nextCol]
                    && map[nextRow][nextCol] == 1
            ) {
                dfs(n, map, visited, nextRow, nextCol);
            }
        }
    }

}
