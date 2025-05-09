package com.codingtest.study2.problem6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test7 {
    /**
     * 7. 좌표 정렬
     * 설명
     * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
     * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
     * <p>
     * 입력
     * 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
     * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
     * <p>
     * 출력
     * N개의 좌표를 정렬하여 출력하세요.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[][] numbers = new int[n][2];

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            numbers[i][0] = Integer.parseInt(line.split(" ")[0]);
            numbers[i][1] = Integer.parseInt(line.split(" ")[1]);
        }
        List<String> solutions = new Test7().solution(n, numbers);

        for (String solution : solutions) {
            System.out.println(solution);
        }
    }

    private List<String> solution(int n, int[][] numbers) {
        List<String> result = new ArrayList<>();

        Arrays.sort(numbers, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int[] row : numbers) {
            result.add(row[0] + " " + row[1]);
        }

        return result;
    }
}
