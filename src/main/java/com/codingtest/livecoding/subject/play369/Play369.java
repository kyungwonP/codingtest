package com.codingtest.livecoding.subject.play369;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Play369 {
    /**
     * 369 게임
     */

    private final GameRule gameRule;

    public Play369(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String region = br.readLine();
        Play369 play = new Play369(GameRegionFactory.getRegion(region));

        System.out.println(play.play(n));
    }

    private String play(int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            result.append(gameRule.getReplace(i)).append(" ");
        }

        return result.toString().trim();
    }
}
