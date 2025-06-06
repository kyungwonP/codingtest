package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test14891 {
    /**
     * 톱니바퀴
     * 총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 아래 그림과 같이 일렬로 놓여져 있다. 또, 톱니는 N극 또는 S극 중 하나를 나타내고 있다.
     * 톱니바퀴에는 번호가 매겨져 있는데, 가장 왼쪽 톱니바퀴가 1번, 그 오른쪽은 2번, 그 오른쪽은 3번, 가장 오른쪽 톱니바퀴는 4번이다.
     * 이때, 톱니바퀴를 총 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다. 회전은 시계 방향과 반시계 방향이 있고, 아래 그림과 같이 회전한다.
     * 톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다. 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다.
     * 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.
     * 예를 들어, 아래와 같은 경우를 살펴보자.
     * 두 톱니바퀴의 맞닿은 부분은 초록색 점선으로 묶여있는 부분이다. 여기서, 3번 톱니바퀴를 반시계 방향으로 회전했다면, 4번 톱니바퀴는 시계 방향으로 회전하게 된다.
     * 2번 톱니바퀴는 맞닿은 부분이 S극으로 서로 같기 때문에, 회전하지 않게 되고, 1번 톱니바퀴는 2번이 회전하지 않았기 때문에, 회전하지 않게 된다.
     * 따라서, 아래 그림과 같은 모양을 만들게 된다.
     * 위와 같은 상태에서 1번 톱니바퀴를 시계 방향으로 회전시키면, 2번 톱니바퀴가 반시계 방향으로 회전하게 되고, 2번이 회전하기 때문에, 3번도 동시에 시계 방향으로 회전하게 된다.
     * 4번은 3번이 회전하지만, 맞닿은 극이 같기 때문에 회전하지 않는다. 따라서, 아래와 같은 상태가 된다.
     * 톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다.
     * 상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.
     * 다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다.
     * 각 방법은 두 개의 정수로 이루어져 있고, 첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다.
     * 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.
     * <p>
     * 출력
     * 총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.
     * 1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
     * 2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
     * 3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
     * 4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
     */

    private static List<List<Integer>> tires = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();

            List<Integer> list = new ArrayList<>();
            for (char ch : chars) {
                list.add(Character.getNumericValue(ch));
            }

            tires.add(list);
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentTireNumber = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                List<Integer> list = tires.get(j);
                for (int num : list) {
                    System.out.print(num);
                }
                System.out.println();
            }
            System.out.println("------------");

            dfs(currentTireNumber - 1, currentTireNumber - 1, turn, 0);
        }

        for (int j = 0; j < 4; j++) {
            List<Integer> list = tires.get(j);
            for (int num : list) {
                System.out.print(num);
            }
            System.out.println();
        }

        int sum = 0;
        int score = 1;

        for (int i = 0; i < 4; i++) {
            List<Integer> tire = tires.get(i);

            if (tire.getFirst() == 1) {
                sum += score;
            }

            score *= 2;
        }

        System.out.println(sum);
    }

    private static void dfs(int targetNumber, int currentTireNumber, int currentTurn, int sideStatus) {
        // 맞닿은 부분이 서로 같을 경우 회전 x
        // 1(시계) -1(반시계)
        // 우선 순위 : 옆 톱니가 회전하면 상태체크하여 회전, 이때 상태 같으면 회전 x
        // 양끝 톱니일 경우 옆 톱니가 회전 안 하는 경우 회전 x

        int left = 2;
        int right = 6;

        if (currentTireNumber < 0 || currentTireNumber > 3) {
            return;
        }

        // 톱니 회전
        if (targetNumber == currentTireNumber) {
            turn(currentTireNumber, currentTurn);
            dfs(targetNumber, currentTireNumber - 1, currentTurn * -1, sideStatus);
            dfs(targetNumber, currentTireNumber + 1, currentTurn * -1, sideStatus);
        } else if (targetNumber > currentTireNumber) {
            // 현재 타이어번호보다 돌려진 톱니번호가 크면 현재타이어는 right, 돌려진 톱니는 left
            int diff = currentTireNumber + 1;
            if (tires.get(diff).get(left) != tires.get(currentTireNumber).get(right)) {
                turn(currentTireNumber, currentTurn);
                dfs(targetNumber, currentTireNumber - 1, currentTurn * -1, sideStatus);
            }
        } else if (targetNumber < currentTireNumber) {
            // 돌려진 톱니가 현재 타이어 번호보다 작으면 left 기준
            // 현재 타이어번호보다 돌려진 톱니번호가 작으면 현재타이어는 left, 돌려진 톱니는 right
            int diff = currentTireNumber - 1;
            if (tires.get(diff).get(right) != tires.get(currentTireNumber).get(left)) {
                turn(currentTireNumber, currentTurn);
                dfs(targetNumber, currentTireNumber + 1, currentTurn * -1, sideStatus);
            }
        }
    }

    private static void turn(int currentTireNumber, int currentTurn) {
        List<Integer> tire = tires.get(currentTireNumber);

        // 톱니 회전
        if (currentTurn == -1) {
            // 반시계
            tire.addLast(tire.getFirst());
            tire.removeFirst();
        } else {
            // 시계
            tire.addFirst(tire.getLast());
            tire.removeLast();
        }

        tires.set(currentTireNumber, tire);
    }
}
