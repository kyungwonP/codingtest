package com.codingtest.study2.problem3;

import java.util.Arrays;
import java.util.Scanner;

public class Test1GPT {
    /**
     * 1. 두 배열 합치기
     * 설명
     * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
     * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
     * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
     * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
     * <p>
     * 출력
     * 오름차순으로 정렬된 배열을 출력합니다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int firstCount = in.nextInt();
        in.nextLine();
        String firstLine = in.nextLine();
        int secondCount = in.nextInt();
        in.nextLine();
        String secondLine = in.nextLine();
        System.out.println(new Test1GPT().solution(firstCount, firstLine, secondCount, secondLine));
    }

    private String solution(int firstCount, String firstLine, int secondCount, String secondLine) {
        StringBuilder result = new StringBuilder();

        int[] firstArray = Arrays.stream(firstLine.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArray = Arrays.stream(secondLine.split(" ")).mapToInt(Integer::parseInt).toArray();

        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstCount && secondIndex < secondCount) {
            if (firstArray[firstIndex] < secondArray[secondIndex]) {
                result.append(firstArray[firstIndex++]).append(" ");
            } else {
                result.append(secondArray[secondIndex++]).append(" ");
            }
        }

        while (firstIndex < firstCount) {
            result.append(firstArray[firstIndex++]).append(" ");
        }

        while (secondIndex < secondCount) {
            result.append(secondArray[secondIndex++]).append(" ");
        }

        return result.toString().trim();
    }
}
