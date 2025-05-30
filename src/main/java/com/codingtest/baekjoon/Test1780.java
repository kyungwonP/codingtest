package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1780 {
    /**
     * 종이의 개수 - 분할 정복 알고리즘, 시간복잡도 O(n^2), 공간복잡도 O(n^2)
     * N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다.
     * 우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
     * 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
     * (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
     * 이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
     * <p>
     * 출력
     * 첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
     */

    private static int n;
    private static int[][] papers;
    private static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        papers = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);

        for (int count : result) {
            System.out.println(count);
        }
    }

    private static void divide(int row, int col, int repeat) {
        int first = papers[row][col];

        if (isSame(row, col, repeat, first)) {
            result[first + 1]++;
            return;
        }

        int nextRepeat = repeat / 3;

        for (int i = row; i < row + repeat; i += nextRepeat) {
            for (int j = col; j < col + repeat; j += nextRepeat) {
                divide(i, j, nextRepeat);
            }
        }
    }

    private static boolean isSame(int row, int col, int repeat, int first) {
        for (int i = row; i < row + repeat; i++) {
            for (int j = col; j < col + repeat; j++) {
                if (papers[i][j] != first) {
                    return false;
                }
            }
        }

        return true;
    }
}
