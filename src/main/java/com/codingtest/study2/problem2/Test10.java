package com.codingtest.study2.problem2;

import java.util.Scanner;

public class Test10 {
    /**
     * 10. 봉우리
     * 설명
     * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
     * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
     * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
     * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
     * <p>
     * 입력
     * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
     * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     * <p>
     * 출력
     * 봉우리의 개수를 출력하세요.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String[][] inputList = new String[count][count];

        for (int i = 0; i < count; i++) {
            inputList[i] = in.nextLine().split(" ");
        }

        System.out.println(new Test10().solution(count, inputList));
    }

    private int solution(int count, String[][] inputList) {
        int result = 0;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int current = Integer.parseInt(inputList[i][j]);
                int top = i == 0 ? 0 : Integer.parseInt(inputList[i - 1][j]);
                int bottom = i == count - 1 ? 0 : Integer.parseInt(inputList[i + 1][j]);
                int left = j == 0 ? 0 : Integer.parseInt(inputList[i][j - 1]);
                int right = j == count - 1 ? 0 : Integer.parseInt(inputList[i][j + 1]);

                if (current > top
                        && current > bottom
                        && current > left
                        && current > right) {
                    result++;
                }
            }
        }

        return result;
    }
}
