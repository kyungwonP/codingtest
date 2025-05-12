package com.codingtest.study2.problem8;

import java.util.Scanner;

public class Test2 {
    /**
     * 2. 바둑이 승차(DFS)
     * 설명
     * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
     * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
     * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
     * 둘째 줄부터 N마리 바둑이의 무게가 주어진다.
     * <p>
     * 출력
     * 첫 번째 줄에 가장 무거운 무게를 출력한다.
     */
    int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
            in.nextLine();
        }

        System.out.println(new Test2().solution(c, n, numbers));
    }

    private int solution(int c, int n, int[] numbers) {
        dfs(c, n, numbers, 0, 0);

        return result;
    }

    private void dfs(int c, int n, int[] numbers, int level, int sum) {
        if (sum > c) {
            return;
        }

        result = Math.max(result, sum);

        if(level >= n){
            return;
        }

        dfs(c, n, numbers, level + 1, sum + numbers[level]);
        dfs(c, n, numbers, level + 1, sum);
    }
}
