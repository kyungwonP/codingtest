package com.codingtest.study2.problem2;

import java.util.Scanner;

public class Test3 {
    /**
     * 3. 가위 바위 보
     * 설명
     * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
     * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
     * 예를 들어 N=5이면
     * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * <p>
     * 출력
     * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
     */
    public static void main(String[] args) {
        Test3 t = new Test3();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String a = in.nextLine();
        String b = in.nextLine();
        String[] results = t.solution(count, a, b);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private String[] solution(int count, String a, String b) {
        String[] aList = a.split(" ");
        String[] bList = b.split(" ");
        String[] result = new String[count];

        for (int i = 0; i < count; i++) {
            String aCurrent = aList[i];
            String bCurrent = bList[i];
            result[i] = getResult(aCurrent, bCurrent);
        }

        return result;
    }

    private String getResult(String aCurrent, String bCurrent) {
        if ("1".equals(aCurrent)) {
            if ("2".equals(bCurrent)) {
                return "B";
            } else if ("3".equals(bCurrent)) {
                return "A";
            }
        } else if ("2".equals(aCurrent)) {
            if ("1".equals(bCurrent)) {
                return "A";
            } else if ("3".equals(bCurrent)) {
                return "B";
            }
        } else if ("3".equals(aCurrent)) {
            if ("1".equals(bCurrent)) {
                return "B";
            } else if ("2".equals(bCurrent)) {
                return "A";
            }
        }

        return "D";
    }
}
