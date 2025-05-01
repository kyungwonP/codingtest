package com.codingtest.study2.session3;

import java.util.Scanner;

public class Test9GPT {
    /**
     * 9. 격자판 최대합
     * 설명
     * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
     * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
     * <p>
     * 입력
     * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
     * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     * <p>
     * 출력
     * 최대합을 출력합니다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String[][] inputList = new String[count][count];

        for (int i = 0; i < count; i++) {
            inputList[i] = in.nextLine().split(" ");
        }

        System.out.println(new Test9GPT().solution(count, inputList));
    }

    private int solution(int count, String[][] inputList) {
        int result = 0;
        int leftDiagonal = 0; // (0,0)에서 (n,n)
        int rightDiagonal = 0; // (n,0)에서(0,n)

        for (int i = 0; i < count; i++) {
            int sumColunm = 0;
            int sumRow = 0;

            for (int j = 0; j < count; j++) {
                int column = Integer.parseInt(inputList[i][j]); // i번째 줄에 j번째 열
                int row = Integer.parseInt(inputList[j][i]); // j번째 줄에 i번째 행

                sumColunm += column;
                sumRow += row;

                if (i == j) {
                    leftDiagonal += column; // (0,0) => (n,n)
                }

                if (i + j == count - 1) {
                    rightDiagonal += column; // (n,0) => (0,n)
                }
            }

            result = Math.max(result, sumColunm);
            result = Math.max(result, sumRow);
        }

        result = Math.max(result, leftDiagonal);
        result = Math.max(result, rightDiagonal);

        return result;
    }
}
