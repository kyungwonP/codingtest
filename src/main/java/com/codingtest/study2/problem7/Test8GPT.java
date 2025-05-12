package com.codingtest.study2.problem7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test8GPT {
    /**
     * 8. 송아지 찾기 1(BFS : 상태트리탐색)
     * 설명
     * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
     * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
     * 송아지는 움직이지 않고 제자리에 있다.
     * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
     * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
     * <p>
     * 출력
     * 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();
        in.nextLine();

        System.out.println(new Test8GPT().solution(s, e));
    }

    private int solution(int s, int e) {
        int[] moves = {-1, 1, 5};
        boolean[] visited = new boolean[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == e) {
                    return level;
                }

                for (int move : moves) {
                    int next = current + move;
                    if (next >= 1 && next <= 10000 && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
