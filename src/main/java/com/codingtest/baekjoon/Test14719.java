package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14719 {
    /**
     * 빗물
     * 2차원 세계에 블록이 쌓여있다. 비가 오면 블록 사이에 빗물이 고인다.
     * 비는 충분히 많이 온다. 고이는 빗물의 총량은 얼마일까?
     * <p>
     * 입력
     * 첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)
     * 두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.
     * 따라서 블록 내부의 빈 공간이 생길 수 없다. 또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.
     * <p>
     * 출력
     * 2차원 세계에서는 한 칸의 용량은 1이다. 고이는 빗물의 총량을 출력하여라.
     * 빗물이 전혀 고이지 않을 경우 0을 출력하여라.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] blocks = new int[w];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(h, w, blocks));
    }

    private static int solution(int h, int w, int[] blocks) {
        int result = 0;

        int max = blocks[0];
        int sum = 0;

        // 왼쪽 -> 오른쪽
        for (int i = 1; i < w; i++) {
            int currentBlock = blocks[i];

            // max보다 크면 합계 더하고 초기화, 작으면 버리고 진행
            if (max <= currentBlock) {
                result += sum;
                sum = 0;
                max = currentBlock;
                continue;
            }

            sum += max - currentBlock;
        }

        max = blocks[w - 1];
        sum = 0;

        // 왼쪽 <- 오른쪽
        for (int i = w - 2; i >= 0; i--) {
            int currentBlock = blocks[i];

            if (max <= currentBlock) {
                result += sum;
                sum = 0;
                max = currentBlock;
                continue;
            }

            sum += max - currentBlock;
        }

        return result;
    }
}
