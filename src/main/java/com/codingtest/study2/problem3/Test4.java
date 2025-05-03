package com.codingtest.study2.problem3;

import java.util.Scanner;

public class Test4 {
    /**
     * 4. 연속 부분수열
     * 설명
     * N개의 수로 이루어진 수열이 주어집니다.
     * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
     * 만약 N=8, M=6이고 수열이 다음과 같다면
     * 1 2 1 3 1 1 1 2
     * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
     *
     * 입력
     * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
     * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
     *
     * 출력
     * 첫째 줄에 경우의 수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        int count = Integer.parseInt(firstLine.split(" ")[0]);
        int total = Integer.parseInt(firstLine.split(" ")[1]);
        String line = in.nextLine();
        System.out.println(new Test4().solution(count, total, line));
    }

    private int solution(int count, int total, String line) {
        int result = 0;
        String[] numbers = line.split(" ");

        for (int i = 0; i < count; i++) {
            int sum = 0;
            for(int j = i; j < count; j++){
                sum += Integer.parseInt(numbers[j]);

                if(sum == total){
                    result++;
                    break;
                } else if (sum > total){
                    break;
                }
            }
        }

        return result;
    }
}
