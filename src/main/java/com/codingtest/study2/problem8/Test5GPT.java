package com.codingtest.study2.problem8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test5GPT {
    /**
     * 5. 동전교환
     * 설명
     * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
     * 각 단위의 동전은 무한정 쓸 수 있다.
     * <p>
     * 입력
     * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
     * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
     * <p>
     * 출력
     * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        in.nextLine();

        int m = in.nextInt();
        in.nextLine();

        System.out.println(new Test5GPT().solution(n, coins, m));
    }

    private int solution(int n, int[] coins, int m) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visits = new boolean[501];
        int level = 0;

        queue.offer(0);
        visits[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int coin : coins) {
                    int next = current + coin;

                    if (next == m) {
                        return level + 1;
                    }

                    if (next <= 500 && !visits[next]) {
                        queue.offer(next);
                        visits[next] = true;
                    }
                }

            }

            level++;
        }

        return level;
    }
}
