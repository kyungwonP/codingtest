package com.codingtest.study2.problem8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test14 {
    /**
     * 14. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
     * 설명
     * N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
     * 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
     * 행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
     * 도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
     * 피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
     * 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
     * 예를 들어, 도시의 지도가 아래와 같다면
     * 0 1 0 0
     * 0 0 2 1
     * 0 0 1 0
     * 1 2 0 2
     * (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
     * 최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
     * 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
     * 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
     * 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
     * <p>
     * 입력
     * 첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.
     * 둘째 줄부터 도시 정보가 입력된다.
     * <p>
     * 출력
     * 첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.
     */

    private int result = 0;
    private List<Point> houses = new ArrayList<>();
    private List<Point> pizzaStores = new ArrayList<>();

    private static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = in.nextInt();
            }
        }

        in.nextLine();

        System.out.println(new Test14().solution(n, m, map));
    }

    private int solution(int n, int m, int[][] map) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    houses.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    pizzaStores.add(new Point(i, j));
                }
            }
        }

        calculation(n, m);

        return result;
    }

    private void calculation(int n, int m) {
        boolean[] visited = new boolean[pizzaStores.size()];

        for (int i = 0; i < n; i++) {
            dfs(m, houses.get(i), visited, new ArrayList<>(), 0);
        }
    }

    private void dfs(int m, Point house, boolean[] visited, List<Point> choices, int sum) {
        if (choices.size() == m) {
            if (result == 0 || sum < result) {
                result = sum;
            }
        }

        for (int i = 0; i < pizzaStores.size(); i++) {
            if (!visited[i]) {
                Point currentPoint = pizzaStores.get(i);
                System.out.println(sum + " + |" + house.row + "-" + currentPoint.row + "| + |" + house.col + "-" + currentPoint.col + "|");
                int calculation = Math.abs(house.row - currentPoint.row) + Math.abs(house.col - currentPoint.col);
                visited[i] = true;
                choices.add(pizzaStores.get(i));
                dfs(m, house, visited, choices, sum + calculation);
                visited[i] = false;
                choices.remove(pizzaStores.get(i));
            }
        }
    }
}