package com.codingtest.livecoding.subject.play369;

public class GameRegionFactory {

    public static GameRule getRegion(String region) {
        switch (region) {
            case "seoul":
                return new SeoulGameRule();
            case "daejeon":
                return new DaejeonGameRule();
            case "busan":
                return new BusanGameRule();
            default:
                throw new IllegalArgumentException("invalid region");
        }
    }
}
