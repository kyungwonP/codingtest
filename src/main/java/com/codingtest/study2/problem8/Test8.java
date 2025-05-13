package com.codingtest.study2.problem8;

import java.util.Scanner;

public class Test8 {
    /**
     * 8. 수열 추측하기
     * 설명
     * <p>
     * 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
     * 예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
     * 3 1 2 4
     * 4 3 6
     * 7 9
     * 16
     * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
     * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
     * <p>
     * 입력
     * 첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
     * N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
     * <p>
     * 출력
     * 첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
     * 답이 존재하지 않는 경우는 입력으로 주어지지 않는다.
     */
    int[] result = new int[11];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int f = in.nextInt();
        in.nextLine();

        System.out.println(new Test8().solution(n, f));
    }

    private String solution(int n, int f) {
        StringBuilder sb = new StringBuilder();

        dfs(n, f);

        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        return sb.toString().trim();
    }

    private void dfs(int n, int f) {
        setStartArray(n, f, 0, 0, new int[n]);
    }

    private void setStartArray(int n, int f, int level, int sum, int[] startArray) {
        if (level == n) {
            sum(f, startArray, startArray);
            return;
        }

        boolean[] use = new boolean[n + 1];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (startArray[i] == 0) {
                break;
            }
            use[startArray[i]] = true;
            arr[i] = startArray[i];
        }

        for (int i = 1; i <= n; i++) {
            if (!use[i]) {
                arr[level] = i;

                setStartArray(n, f, level + 1, sum, arr);
            }
        }
    }

    private void sum(int f, int[] startArray, int[] calculationArray) {
        if (calculationArray.length == 1) {
            if (calculationArray[0] == f) {
                changeResult(startArray);
            }
            return;
        }

        int[] temp = new int[calculationArray.length - 1];
        for (int i = 0; i < calculationArray.length - 1; i++) {
            temp[i] = calculationArray[i] + calculationArray[i + 1];
        }

        sum(f, startArray, temp);
    }

    private void changeResult(int[] startArray) {
        boolean status = true;
        for (int i = 0; i < startArray.length; i++) {
            if (result[i] != 0 && result[i] < startArray[i]) {
                status = false;
                break;
            }
        }

        if (status) {
            result = startArray;
        }
    }
}
