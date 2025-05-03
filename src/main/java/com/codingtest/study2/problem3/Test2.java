package com.codingtest.study2.problem3;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    /**
     * 2. 공통원소 구하기
     * 설명
     * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
     * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
     * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
     * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
     * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
     * <p>
     * 출력
     * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int firstCount = in.nextInt();
        in.nextLine();
        String firstLine = in.nextLine();
        int secondCount = in.nextInt();
        in.nextLine();
        String secondLine = in.nextLine();
        System.out.println(new Test2().solution(firstCount, firstLine, secondCount, secondLine));
    }

    private String solution(int firstCount, String firstLine, int secondCount, String secondLine) {
        StringBuilder result = new StringBuilder();

        int[] firstArray = Arrays.stream(firstLine.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] secondArray = Arrays.stream(secondLine.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstCount && secondIndex < secondCount) {
            if (firstArray[firstIndex] > secondArray[secondIndex]) {
                secondIndex++;
            } else if (firstArray[firstIndex] < secondArray[secondIndex]) {
                firstIndex++;
            } else {
                result.append(firstArray[firstIndex]).append(" ");
                firstIndex++;
                secondIndex++;
            }
        }

        return result.toString().trim();
    }
}
