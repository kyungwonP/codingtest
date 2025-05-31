package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test2589 {
    /**
     * 보물섬
     * 보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다.
     * 각 칸은 육지(L)나 바다(W)로 표시되어 있다. 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다.
     * 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
     * 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.
     * 예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.
     * 보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다.
     * 이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.
     * <p>
     * 출력
     * 첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.
     */

    private static int h;
    private static int w;
    private static char[][] map;
    private static boolean[][] visited;
    private static List<List<Point>> islands = new ArrayList<>();
    private static int islandIndex = 0;

    private static int[] MOVE_ROW = {-1, 1, 0, 0}; // 상 하 좌 우
    private static int[] MOVE_COL = {0, 0, -1, 1}; // 상 하 좌 우

    private static class Point {
        int height;
        int weight;

        Point(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        visited = new boolean[h + 1][w + 1];

        for (int i = 0; i < h; i++) {
            String line = br.readLine();

            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        solution();
    }

    private static void solution() {
        islands.add(new ArrayList<>());

        // 그래프 연결 확인
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 'L') {
                    boolean island = findIsland(i, j);

                    if (!island) {
                        islandIndex++;
                        islands.add(new ArrayList<>());
                    }

                }
            }
        }

        // 구해진 섬에서 가장 먼 거리 찾기

        int result = 0;

        for (List<Point> island : islands) {
            int hours = findPresent(island);

            result = Math.max(result, hours);
        }

        System.out.println(result);

    }

    // 섬 찾기
    private static boolean findIsland(int currentHeight, int currentWeight) {
        boolean flag = false;

        if (!visited[currentHeight][currentWeight] && map[currentHeight][currentWeight] == 'L') {

            visited[currentHeight][currentWeight] = true;
            islands.get(islandIndex).add(new Point(currentHeight, currentWeight));

            for (int i = 0; i < 4; i++) {
                int nextHeight = currentHeight + MOVE_ROW[i];
                int nextWeight = currentWeight + MOVE_COL[i];

                if (nextHeight >= 0 && nextHeight < h && nextWeight >= 0 && nextWeight < w) {
                    boolean isIsland = findIsland(nextHeight, nextWeight);
                    if (isIsland) {
                        flag = true;
                    }
                }

            }
        }

        return flag;
    }

    // 가장 먼거리의 땅 찾기
    private static int findPresent(List<Point> island) {
        int result = 0;
        Queue<Point> queue = new LinkedList<>();

        for (Point point : island) {
            System.out.println(point.height + " " + point.weight);

            queue.offer(point);

            boolean[][] islandVisited = new boolean[h + 1][w + 1];
            islandVisited[point.height][point.weight] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    Point poll = queue.poll();

                    if (!islandVisited[poll.height][poll.weight]) {

                        islandVisited[poll.height][poll.weight] = true;
                        islands.get(islandIndex).add(new Point(poll.height, poll.weight));

                        for (int k = 0; k < 4; k++) {
                            int nextHeight = poll.height + MOVE_ROW[k];
                            int nextWeight = poll.weight + MOVE_COL[i];

                            if (nextHeight >= 0 && nextHeight < h && nextWeight >= 0 && nextWeight < w) {
                            }

                        }

                    }

                }
            }
        }
        System.out.println("----------------------");


        return result;
    }

    private static void bfs(List<Point> island) {


    }

}
