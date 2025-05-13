package com.codingtest.study2.problem8;

import java.util.Scanner;

public class Test10GPT {
    /**
     * 10. 미로탐색(DFS)
     * 설명
     * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
     * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
     * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
     * S 0 0 0 0 0 0
     * 0 1 1 1 1 1 0
     * 0 0 0 1 0 0 0
     * 1 1 0 1 0 1 1
     * 1 1 0 0 0 0 1
     * 1 1 0 1 1 0 0
     * 1 0 0 0 0 0 D
     * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
     * <p>
     * 입력
     * 7*7 격자판의 정보가 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 경로의 가지수를 출력한다.
     */
    private static final int N = 7;
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = in.nextInt();
            }
            in.nextLine();
        }

        System.out.println(new Test10GPT().solution(board));
    }

    private int solution(int[][] board) {
        boolean[][] visits = new boolean[N][N];
        visits[0][0] = true;
        return dfs(board, visits, 0, 0);
    }

    private int dfs(int[][] board, boolean[][] visits, int row, int col) {
        if (row == N - 1 && col == N - 1) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N && board[nRow][nCol] == 0 && !visits[nRow][nCol]) {
                visits[nRow][nCol] = true;
                count += dfs(board, visits, nRow, nCol);
                visits[nRow][nCol] = false;
            }
        }

        return count;
    }
}
