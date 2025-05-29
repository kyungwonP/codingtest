package com.codingtest.livecoding.subject.wordfiltering;

public class FilteringFactory {
    public static Filtering setFilteringType(FilterPolicy type) {
        return switch (type) {
            case DEFAULT -> new DefaultFiltering();
            case REMOVE -> new RemoveFiltering();
            case PARTIAL -> new PartialFiltering();
            default -> throw new IllegalArgumentException("Unknown FilterPolicy: " + type);
        };
    }
}
