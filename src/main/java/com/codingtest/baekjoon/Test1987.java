package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Test1987 {
    /**
     * 알파벳 다국어
     * 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다.
     * 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.
     * 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
     * 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
     * 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오.
     * 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
     * <p>
     * 입력
     * 첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다.
     * (1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.
     * <p>
     * 출력
     * 첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.
     */

    private static int r;
    private static int c;
    private static char[][] board;
    private static int result = 0;
    private static int[] MOVE_ROW = {-1, 1, 0, 0};
    private static int[] MOVE_COL = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        Set<Character> set = new HashSet<>();
        set.add(board[0][0]);

        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;

        dfs(0, 0, set, visited);

        System.out.println(result);
    }

    private static void dfs(int row, int col, Set<Character> set, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nextRow = row + MOVE_ROW[i];
            int nextCol = col + MOVE_COL[i];

            if (nextRow >= 0 && nextRow < r
                    && nextCol >= 0 && nextCol < c
                    && !visited[nextRow][nextCol]
            ) {
                if (set.add(board[nextRow][nextCol])) {
                    visited[nextRow][nextCol] = true;
                    dfs(nextRow, nextCol, set, visited);
                    set.remove(board[nextRow][nextCol]);
                    visited[nextRow][nextCol] = false;
                } else {
                    result = Math.max(result, set.size());
                }
            }
        }
    }
}
